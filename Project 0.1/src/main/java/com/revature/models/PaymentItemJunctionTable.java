package com.revature.models;

public class PaymentItemJunctionTable {

	private int id;
	private int itemId;
	private int paymentId;
	
	public PaymentItemJunctionTable() {
		super();
		
	}

	public PaymentItemJunctionTable(int itemId, int paymentId) {
		super();
		this.itemId = itemId;
		this.paymentId = paymentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
