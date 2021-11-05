package com.revature.models;

public class PaymentUserJunctionTable {

	private int id;
	private int userId;
	private int paymentId;
	
	public PaymentUserJunctionTable() {
		super();
		
	}

	public PaymentUserJunctionTable(int userId, int paymentId) {
		super();
		this.userId = userId;
		this.paymentId = paymentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
