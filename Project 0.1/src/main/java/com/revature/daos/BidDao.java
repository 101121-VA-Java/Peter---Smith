package com.revature.daos;

import java.util.List;

import com.revature.models.Bid;


public class BidDao implements GenericDao<Bid>{

	BidPostgres bp = new BidPostgres();
	
	@Override
	public int add(Bid t) {
		
		return (bp.add(t));
	}

	@Override
	public List<Bid> getAll() {
		
		return (bp.getAll());
	}

	@Override
	public Bid getById(int id) {
		
		return (bp.getById(id));
	}

	@Override
	public boolean update(Bid t) {
		
		return (bp.update(t));
	}

	@Override
	public int delete(int id) {
		
		return (bp.delete(id));
	}

	public List<Bid> getAllByItem() {
		
		return (bp.getAllByItem());
	}

	
	
}
