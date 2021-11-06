package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.BidDao;
import com.revature.models.Bid;

public class BidService {

	BidDao bd = new BidDao();

	public Bid getById(int number) {
		
		return bd.getById(number);
				
	}

	public int makeBid(int id, int offer, int uId) {
		
		Bid bid = new Bid(offer, uId, id);
		
		return bd.add(bid);
	}
	

	public List<Bid> getUserBids(int id) {
		
		List<Bid> userbids = new ArrayList<>();
		Bid ubids = null;
		
		for (Bid bdr : bd.getAll()) {
			if (bdr.getOwnerId() == id ) {
				ubids = new Bid(bdr.getId(), bdr.getPrice() , id, bdr.getItemId()); 
 				userbids.add(ubids);
			}
		}
		return userbids;
	}
	
	
}
