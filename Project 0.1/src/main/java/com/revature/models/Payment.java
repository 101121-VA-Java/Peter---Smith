package com.revature.models;

import java.util.Date;

public class Payment {
                            // junction table between payment and customer
	private int id;         // junction table between payment and item.  get total price from item
	private int payment;    // Might be partial payment.  But might be entire price, therefore item is owned 
	private int remainingBalance;
	private Date lastPaymentDate;               // TODO should payment be deleted from DB when item paid in full?
	
	public Payment() {
		super();
	}
	
	public Payment(int payment, int remainingBalance, Date lastPaymentDate) {
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
	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	
	
}
