package com.cg.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable {
	private String name;
	private String mobileNo;
	private Wallet wallet;
	private String password;
	private String EmailId;

	public Customer() {
		wallet = new Wallet();
	}

	public Customer(String mobileNo2, String name2, String password, String emailId, Wallet wallet2) {
		this.name = name2;
		mobileNo = mobileNo2;
		wallet = wallet2;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return EmailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getPassword() {
		return password;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
