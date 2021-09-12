package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Account {
	
	@Id
	private int custID;
	private String acno;
	private String name;
	private String branchName;
	private String bankName;
	private long balance;
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [custID=" + custID + ", acno=" + acno + ", name=" + name + ", branchName=" + branchName
				+ ", bankName=" + bankName + ", balance=" + balance + "]";
	}
	

}
