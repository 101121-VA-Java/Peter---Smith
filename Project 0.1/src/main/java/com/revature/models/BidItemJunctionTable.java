package com.revature.models;

public class BidItemJunctionTable {

	private int id;
	private int bidId;
	private int itemId;
	
	public BidItemJunctionTable() {
		super();
		
	}

	public BidItemJunctionTable(int bidId, int itemId) {
		super();
		this.bidId = bidId;
		this.itemId = itemId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
}
