package com.revature.models;

import java.time.LocalDate;

public class Payment {
                           
	private int id;  
	private int itemId;
	private int userId;
	private int payment;               // the current payment, might be partial or entire price
	private int remainingBalance;       // total price (from items) minus all payments
	private LocalDate lastPaymentDate;              
	
	public Payment() {
		super();
	}
	
	
	public Payment(int itemId, int userId, int payment, int remainingBalance, LocalDate lastPaymentDate) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.payment = payment;
		this.remainingBalance = remainingBalance;
		this.lastPaymentDate = lastPaymentDate;
	}


	public Payment(int id, int itemId, int userId, int payment, int remainingBalance, LocalDate lastPaymentDate) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.userId = userId;
		this.payment = payment;
		this.remainingBalance = remainingBalance;
		this.lastPaymentDate = lastPaymentDate;
	}

	public Payment(int itemId, int userId, int payment, int remainingBalance) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.payment = payment;
		this.remainingBalance = remainingBalance;
	}


	public Payment(int payment, int remainingBalance, LocalDate lastPaymentDate) {
		super();
		this.payment = payment;
		this.remainingBalance = remainingBalance;
		this.lastPaymentDate = lastPaymentDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(int remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(LocalDate localDate) {
		this.lastPaymentDate = localDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
}
