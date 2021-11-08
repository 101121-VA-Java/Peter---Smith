package com.revature.models;

public class Bid {

	private int id;
	private int price;						// offer price (asking price in Item object)
    private int bidderId;                 // id of the customer making a bid
    private int itemId;                   // id of the item
    private int bidStatus;					// 0 if bid is being considered, 1 if accepted, -1 if rejected
    
    public Bid() {
		super();
	}

	public Bid(int price, int bidderId, int itemId) {
		super();
		this.price = price;
		this.bidderId = bidderId;
		this.setItemId(itemId);
	}
	
	public Bid(int id, int price, int bidderId, int itemId, int bidStatus) {
		super();
		this.id = id;
		this.price = price;
		this.bidderId = bidderId;
		this.itemId = itemId;
		this.bidStatus = bidStatus;
	}

	public Bid(int price, int bidderId, int itemId, int bidStatus) {
		super();
		this.price = price;
		this.bidderId = bidderId;
		this.itemId = itemId;
		this.bidStatus = bidStatus;
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

	public int getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}

}
