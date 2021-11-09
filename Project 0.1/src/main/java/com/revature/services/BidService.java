package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.BidDao;
import com.revature.models.Bid;
import com.revature.models.Item;

public class BidService {

	BidDao bd = new BidDao();
	BidDao bd2 = new BidDao();
	ItemService is = new ItemService();

	public Bid getById(int number) {
		
		return bd.getById(number);
				
	}

	public int makeBid(int itemid, int offer, int userid) {
		
		Bid bid = new Bid(offer, userid, itemid, 0);
		
		return bd.add(bid);
	}
	

	public List<Bid> getOpenBidsByUser(int id) {
		
		List<Bid> userbids = new ArrayList<>();
		Bid ubids = null;
		for (Bid bds : getBidsByUser(id)) {
			if (bds.getBidStatus() == 0) {
				ubids = new Bid(bds.getId(), bds.getPrice() , id, bds.getItemId(), bds.getBidStatus()); 
				userbids.add(ubids);
			}
		}
		return userbids;
	}
	
	public List<Bid> getBidsByUser(int id) {
		
		List<Bid> userbids = new ArrayList<>();
		Bid ubids = null;
		
		for (Bid bdr : bd.getAll()) {
			if (bdr.getOwnerId() == id ) {
				ubids = new Bid(bdr.getId(), bdr.getPrice() , id, bdr.getItemId(), bdr.getBidStatus()); 
 				userbids.add(ubids);
			}
		}
		return userbids;
	}
	
	public List<Bid> getBidsByItem(int id) {
		
		List<Bid> userbids = new ArrayList<>();
		Bid ubids = null;
		
		for (Bid bdr : bd.getAll()) {
			if (bdr.getItemId() == id ) {
				ubids = new Bid(bdr.getId(), bdr.getPrice() , bdr.getBidderId(), id); 
 				userbids.add(ubids);
			}
		}
		return userbids;
	}

	public List<Bid> getOffersEachItem() {
		
		List<Bid> highbids = new ArrayList<>(); 
		Bid hbids = null;
		for (Bid bdr : bd.getAllByItem()) {
			if (bdr.getBidStatus() == 0) {
				hbids = new Bid(bdr.getId(), bdr.getPrice() , bdr.getOwnerId(), bdr.getItemId(), bdr.getBidStatus()); 
				highbids.add(hbids);
			}
			
		}
		return highbids;
	}	


	public boolean rejectBid(int num) {
		
		Bid rejectbid = bd.getById(num);
		if (rejectbid.getBidStatus() == 1) {  // if this item has already been accepted, do not reject
			return false;
		}
		rejectbid.setBidStatus(-1);
		return bd.update(rejectbid);
		
		
	}

	public boolean acceptBid(int number) {
		
		Bid acceptbid = bd.getById(number);
		if (acceptbid.equals(null)) {
			return false;
		}
		acceptbid.setBidStatus(1);
		if (bd.update(acceptbid)) {
			is.markItemAsOwned(acceptbid.getItemId(), acceptbid.getPrice());              //  Bid has been accepted, mark the item as 'owned'
			if (markBidsAsRejected(acceptbid.getItemId())) {
				return true;
			}
		}
				
		return false;
		
	}

	private boolean markBidsAsRejected(int itemId) {
		
		boolean result = true;
		for (Bid bdr : bd.getAll()) {
			if(bdr.getItemId() == itemId && bdr.getBidStatus() != 1) {
				bdr.setBidStatus(-1);
				if (!bd.update(bdr)) {
					result = false;
				}
			}
			
		}
		return result;
	}

	
	public  List<Bid> getAcceptedBids(int userid) {

		List<Bid> userbids = new ArrayList<>();
		Bid pbids = null;
		for (Bid bdr : getBidsByUser(userid)) {
			if (bdr.getBidStatus() == 1 ) {
				pbids = new Bid(bdr.getId(), bdr.getPrice() , bdr.getOwnerId(), bdr.getItemId()); 
 				userbids.add(pbids);
			}
		}
		
		return userbids;		
	}
}
