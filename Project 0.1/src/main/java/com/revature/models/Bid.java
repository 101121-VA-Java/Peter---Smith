package com.revature.models;

public class Bid {

	private int id;
	private int price;
    private int bidderId;                 // id of the customer making a bid
//    private int itemId;                   TODO don't think i need,  will now have junction table between bid id and item id
	
    public Bid() {
		super();
	}

	public Bid(int price, int ownerId) {
		super();
		this.price = price;
		this.bidderId = ownerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOwnerId() {
		return bidderId;
	}

	public void setOwnerId(int ownerId) {
		this.bidderId = ownerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

}
