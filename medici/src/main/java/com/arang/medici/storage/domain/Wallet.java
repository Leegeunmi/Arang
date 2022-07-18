package com.arang.medici.storage.domain;

public class Wallet {
	private String userId;			// 사용자 아이디
	private double balance;			// 결제하는 금액
	private double resultBalance;	// 결제후 잔액
	private String sucessMsg;
	private String failMsg;
	
	public Wallet() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public double getResultBalance() {
		return resultBalance;
	}

	public void setResultBalance(double resultBalance) {
		this.resultBalance = resultBalance;
	}

	public String getSucessMsg() {
		return sucessMsg;
	}

	public void setSucessMsg(String sucessMsg) {
		this.sucessMsg = sucessMsg;
	}

	public String getFailMsg() {
		return failMsg;
	}

	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}
	
	
}
