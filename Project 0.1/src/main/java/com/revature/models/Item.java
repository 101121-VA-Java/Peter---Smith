package com.revature.models;

public class Item {

    private int id;
    private int price;
    private String name;
    private String description;
    private boolean owned;               //  false implies item for sale.  true when an offer is accepted

    
	public Item() {
		super();
		}

	
	public Item(int price, String name, String description) {
		super();
		this.price = price;
		this.name = name;
		this.description = description;
		this.owned = false;
	}

	@Override
	public String toString() {
		return (" " + id + "   " + price + "   " + name + "      " + description);
	}


	public Item(int id, int price, String name, String description, boolean owned) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
		this.owned = owned;
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



	public boolean isOwned() {
		return owned;
	}



	public void setOwned(boolean owned) {
		this.owned = owned;
	}







	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}

	
	
    
}
