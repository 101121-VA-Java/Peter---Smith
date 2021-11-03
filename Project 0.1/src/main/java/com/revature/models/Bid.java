package com.revature.models;

public class Bid {

	private int price;
    private int ownerId;
	
    public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bid(int price, int ownerId) {
		super();
		this.price = price;
		this.ownerId = ownerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
    
    
}
