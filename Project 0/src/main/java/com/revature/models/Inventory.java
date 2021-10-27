package com.revature.models;

import java.util.ArrayList;
import java.util.List; 

public class Inventory {

	private List<Pillow> inventory;
	
	public Inventory() {
		inventory = new ArrayList<Pillow>();
	}
	
	public void addPillow(Pillow pillow) {
		inventory.add(pillow);
	}

	@Override
	public String toString() {
		String total = "";
		for (int i = 0; i < inventory.size(); i++) {
			Pillow p = inventory.get(i);
			total += p.toString();
		}
		return total;
	}
	
	
}
