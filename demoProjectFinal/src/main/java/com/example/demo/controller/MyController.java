package com.example.demo.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Util.UserValidator;
import com.example.demo.model.Account;
import com.example.demo.model.LoginUser;
import com.example.demo.model.RegisterUser;
import com.example.demo.model.TransferMoney;
import com.example.demo.repository.AccountDAO;
import com.example.demo.repository.LoginDAO;
import com.example.demo.repository.RegisterDAO;
import com.example.demo.repository.TransferDAO;

@Controller
public class MyController {

	@Autowired
	RegisterDAO daoRegister;
	@Autowired
	LoginDAO daoLogin;
	@Autowired
	AccountDAO daoAccount;
	@Autowired
	TransferDAO daoTf;

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/home")
	public String homepage() {
		return "home.jsp";
	}

	@RequestMapping("/register")
	public String register(RegisterUser user, HttpServletRequest request) {
		System.out.println("user details -  " + user);

		String name = user.getName();
		String pass = user.getPass();
		String confpass = user.getConfpass();
		String dob = user.getDob();
		String mobile = user.getMobile();

		LoginUser u = new LoginUser(user.getCustID(), pass);

		if (UserValidator.checkName(name)) {
			if (UserValidator.checkPassword(pass, confpass)) {
				if (UserValidator.checkDOB(dob)) {
					if (UserValidator.checkMobile(mobile)) {
						daoRegister.save(user);
						daoLogin.save(u);
						setupAccount(user.getCustID(), user.getAcno(), name);
						request.getSession().setAttribute("succMsg", "User Successfully Registered. Please Login !!!");
					} else {
						System.out.println("Mobile Number is not 10 digits !!! ");
						request.getSession().setAttribute("errMsg", "Mobile Number is not 10 digits !!!");
					}
				} else {
					System.out.println("Age should be greater than limit !!!");
					request.getSession().setAttribute("errMsg", "Age should be greater than limit !!!");
				}
			} else {
				System.out.println("Password and Confirm Password should be same !!! ");
				request.getSession().setAttribute("errMsg", "Password and Confirm Password should be same !!!");
			}
		} else {
			System.out.println("Please enter only Characters in Name !!! ");
			request.getSession().setAttribute("errMsg", "Please enter only Characters in Name !!!");
		}

		return "register.jsp";
	}

	// -----------------------Account Setup -------------------------------
	public void setupAccount(int custID, String acno, String name) {

		Account account = new Account();

		account.setCustID(custID);
		account.setAcno(acno);
		account.setName(name);
		account.setBranchName("Boring Road");
		account.setBankName("STATE BANK OF INDIA");
		account.setBalance(0);

		daoAccount.save(account);

	}

	@RequestMapping("/login")
	public RedirectView login(LoginUser user, HttpServletRequest request) {
		// System.out.println(user);

		int custID = user.getCustID();
		String pass = user.getPass();

		Optional<Account> u = daoAccount.findById(custID);

		if (daoLogin.findByCustIDAndPass(custID, pass) != null) {
			System.out.println("login user = " + u.orElse(null));
			request.getSession().setAttribute("user", u.orElse(null));
			request.getSession().setAttribute("valid", "true"); // setting for authorised users
			return new RedirectView("home"); // redirect to home url
		}

		System.out.println("login failed");
		return new RedirectView(""); // redirected to /
	}

	@RequestMapping("/passwordreset")
	public String resetPassword(@RequestParam("currpass") String currentPassword,
			@RequestParam("newpass") String newPassword, @RequestParam("confpass") String confirmPassword,
			HttpServletRequest request) {

		// System.out.println(currentPassword+" "+newPassword+" "+confirmPassword);

		Account account = (Account) request.getSession().getAttribute("user");

		if (daoRegister.getCurrentPassword(account.getCustID()).equals(currentPassword)) {
			if (!currentPassword.equals(newPassword)) {
				if (newPassword.equals(confirmPassword)) {
					RegisterUser reg = (daoRegister.findById(account.getCustID())).orElse(null);
					LoginUser log = (daoLogin.findById(account.getCustID())).orElse(null);

					reg.setPass(newPassword);
					log.setPass(newPassword);
					daoRegister.save(reg);
					daoLogin.save(log);

					request.getSession().setAttribute("succMsg", "Password Changed Successfully !!! ");
					return "home.jsp";
				} else {
					request.getSession().setAttribute("errMsg", "Password and Confirm Password do not match !!! ");
				}
			} else {
				request.getSession().setAttribute("errMsg", "New password and Old Password are same !!! ");
			}
		} else {
			request.getSession().setAttribute("errMsg", "Current Password is Incorrect !!! ");
		}

		return "resetPass.jsp";
	}

	@RequestMapping("/transfer")
	public String transferFund(TransferMoney tm, HttpServletRequest request) {
		// System.out.println("Transfer money - "+tm);

		long txnId = tm.getTxnID();
		String fromAcc = tm.getFromAC();
		String toAcc = tm.getToAC();
		long amt = tm.getAmt();

		// checks - vaid toAccount number + balance in account
		Account toAccount = daoAccount.getAccountDetails(toAcc);
		Account fromAccount = daoAccount.getAccountDetails(fromAcc);

		if (toAccount != null) {
			if (fromAccount.getBalance() - amt >= 0) {
				long toAccNewBalance = toAccount.getBalance() + amt;
				long fromAccNewBalance = fromAccount.getBalance() - amt;
				toAccount.setBalance(toAccNewBalance);
				fromAccount.setBalance(fromAccNewBalance);
				daoAccount.save(toAccount);
				daoAccount.save(fromAccount);

				daoTf.save(tm); // saving is successfull transfer

				// updating current session --------------
				request.getSession().setAttribute("user", fromAccount);
				request.getSession().setAttribute("succMsg", "Money Transfer Successfull !!! ");
				return "home.jsp";
			} else {
				request.getSession().setAttribute("errMsg", "Not Sufficient balance in your Account!!! ");
			}
		} else {
			request.getSession().setAttribute("errMsg", "Please provide correct Account to Transfer Money !!! ");
		}

		return "fundTransfer.jsp";
	}
	
	
	@RequestMapping("/txn")
	public String Transactions(HttpServletRequest req) {
		Account account = (Account) req.getSession().getAttribute("user");
		String acno = account.getAcno();
		
		List<TransferMoney> txn =  daoTf.getTxnList(acno);
		// System.out.println(txn);
		req.getSession().setAttribute("txn", txn);
		req.getSession().setAttribute("txnCount", txn.size());
		
		/*
		 * for(TransferMoney transaction : txn) { System.out.println(transaction); }
		 */
		
		return "miniStmt.jsp";
	}
	

	@RequestMapping("/logout")
	public String LogOut(HttpServletRequest req) {
		req.getSession().removeAttribute("succMsg");
		req.getSession().removeAttribute("errMsg");
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("valid");
		req.getSession().removeAttribute("txn");
		req.getSession().removeAttribute("txnCount");
		return "index.jsp";
	}

}
