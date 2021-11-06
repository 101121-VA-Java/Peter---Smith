package com.revature.models;

public class Bid {

	private int id;
	private int price;
    private int bidderId;                 // id of the customer making a bid
    private int itemId;                   // id of the item
	
    public Bid() {
		super();
	}

	public Bid(int price, int bidderId, int itemId) {
		super();
		this.price = price;
		this.bidderId = bidderId;
		this.setItemId(itemId);
	}
	
	public Bid(int id, int price, int bidderId, int itemId) {
		super();
		this.id = id;
		this.price = price;
		this.bidderId = bidderId;
		this.itemId = itemId;
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
