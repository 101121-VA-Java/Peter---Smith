package com.revature.services;

import com.revature.daos.ItemDao;
import com.revature.models.Item;


public class ItemService {

	ItemDao id = new ItemDao();

	public int add(Item newItem) {
		
		return id.add(newItem);
	}
	
	
}
