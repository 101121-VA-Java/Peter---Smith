package com.revature.services;

import java.util.List;

import com.revature.daos.ItemDao;
import com.revature.models.Item;


public class ItemService {

	ItemDao id = new ItemDao();
	
	
	public int add(Item newItem) {
		
		return id.add(newItem);
	}


	public int removeItem(int number) {
		return id.delete(number);
		
	}


	public List<Item> viewItems() {
		
		return id.getAll();
		
		
	}
	
	public Item getById(int number) {
		return id.getById(number);
		
	}
	
}
