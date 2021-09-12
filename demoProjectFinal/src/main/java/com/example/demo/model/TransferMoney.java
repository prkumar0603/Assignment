package com.example.demo.model;

import javax.persistence.*;

@Entity
public class TransferMoney {

	@Id
	private long txnID;
	private String fromAC;
	private String toAC;
	private long amt;
	
	public long getTxnID() {
		return txnID;
	}
	public void setTxnID(long txnID) {
		this.txnID = txnID;
	}
	public String getFromAC() {
		return fromAC;
	}
	public void setFromAC(String fromAC) {
		this.fromAC = fromAC;
	}
	public String getToAC() {
		return toAC;
	}
	public void setToAC(String toAC) {
		this.toAC = toAC;
	}
	public long getAmt() {
		return amt;
	}
	public void setAmt(long amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "TransferMoney [txnID=" + txnID + ", fromAC=" + fromAC + ", toAC=" + toAC + ", amt=" + amt + "]";
	}
	
}
