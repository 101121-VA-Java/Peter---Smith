package com.revature.models;

public class BidUserJunctionTable {

	private int id;
	private int bidId;
	private int userId;
	
	public BidUserJunctionTable() {
		super();
		
	}

	public BidUserJunctionTable(int bidId, int userId) {
		super();
		this.bidId = bidId;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
