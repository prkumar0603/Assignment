package com.example.demo.model;

import javax.persistence.*;

@Entity
public class RegisterUser {
	
	@Id
	private int custID;
	private String acno;
	private String name;
	private String pass;
	
	@Transient
	private String confpass;
	
	private String dob;
	private String mobile;
	private String gender;
	
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConfpass() {
		return confpass;
	}
	public void setConfpass(String confpass) {
		this.confpass = confpass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [custID=" + custID + ", acno=" + acno + ", name=" + name + ", pass=" + pass + ", confpass="
				+ confpass + ", dob=" + dob + ", mobile=" + mobile + ", gender=" + gender + "]";
	}

}
