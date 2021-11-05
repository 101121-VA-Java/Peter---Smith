package com.revature.daos;

import java.util.List;

import com.revature.models.Item;

public class ItemDao implements GenericDao<Item>{

	ItemPostgres ip = new ItemPostgres();
	
	@Override
	public int add(Item t) {
		
		return (ip.add(t));
	}

	@Override
	public List<Item> getAll() {
		
		return (ip.getAll());
	}

	@Override
	public Item getById(int id) {
		
		return (ip.getById(id));
	}

	@Override
	public boolean update(Item t) {
		
		return (ip.update(t));
	}

	@Override
	public int delete(int id) {
		
		return (ip.delete(id));
	}

	
	
}
