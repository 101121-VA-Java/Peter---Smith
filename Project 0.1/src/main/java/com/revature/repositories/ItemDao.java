package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;

public class ItemDao implements GenericDao<Item>{

	private ArrayList<Item> items = new ArrayList<>();

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public List<Item> addList(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item add(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Item t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
