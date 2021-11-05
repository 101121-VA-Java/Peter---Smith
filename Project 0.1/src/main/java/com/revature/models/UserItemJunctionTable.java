package com.revature.models;

public class UserItemJunctionTable {

	private int id;
	private int itemId;
	private int userId;
	
	public UserItemJunctionTable() {
		super();
		
	}

	public UserItemJunctionTable(int itemId, int userId) {
		super();
		this.itemId = itemId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getitemId() {
		return itemId;
	}

	public void setitemId(int itemId) {
		this.itemId = itemId;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}
	
	
}
