package com.revature.models;

public class Item {

	public static int numberOfItems;
    private int id;
    private int price;
    private String name;
    private Bid offer;
    
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, int price, String name, Bid offer) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.offer = offer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
    
}
