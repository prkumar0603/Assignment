package com.example.demo.model;

import javax.persistence.*;

@Entity
public class LoginUser {
	
	@Id
	private int custID;
	private String pass;
	
	public LoginUser() {
		super();
	}
	public LoginUser(int custID, String pass) {
		this.custID = custID;
		this.pass = pass;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "LoginUser [custID=" + custID + ", pass=" + pass + "]";
	}
	
	
	
}
