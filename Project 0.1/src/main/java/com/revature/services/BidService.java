package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.BidDao;
import com.revature.models.Bid;
import com.revature.models.Item;

public class BidService {

	BidDao bd = new BidDao();

	public Bid getById(int number) {
		
		return bd.getById(number);
				
	}

	public int makeBid(int id, int offer, int uId) {
		
		Bid bid = new Bid(offer, uId, id, 0);
		
		return bd.add(bid);
	}
	

	public List<Bid> getOpenBidsByUser(int id) {
		
		List<Bid> userbids = new ArrayList<>();
		Bid ubids = null;
		for (Bid bds : getBidsByUser(id)) {
			if (bds.getBidStatus() == 0) {
				ubids = new Bid(bds.getId(), bds.getPrice() , id, bds.getItemId()); 
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
				ubids = new Bid(bdr.getId(), bdr.getPrice() , id, bdr.getItemId()); 
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

	public List<Bid> getHighestOfferEachItem() {
		
		int biditemid = -1;
		boolean add1 = false;
		boolean add = false;
		int price = 0;
		List<Bid> highbids = new ArrayList<>(); 
		Bid hbids = null;
		for (Bid bdr : bd.getAll()) {
			price = 0;
			for (Bid bddr : getOpenBidsForItem(bdr.getItemId())) {
				add = false;
				if (bddr.getPrice() > price) {
					price = bddr.getPrice();
					hbids = new Bid(bddr.getId(), bddr.getPrice() , bddr.getOwnerId(), bddr.getItemId()); 
					add = true;
					biditemid = bddr.getItemId();
				}
			}
			if (add) {
				for (Bid bidr : highbids) {
					add1 = true;
					if (bidr.getItemId() == biditemid) { 
						add1 = false;	
					}
				}
				if (add1) {
					highbids.add(hbids);
				}
			}
			
		}
		return highbids;
		
	}
	
	public List<Bid> getOpenBidsForItem(int itemId) {
		
		List<Bid> highbids = new ArrayList<>(); 
		Bid hbids = null;
		for (Bid bdr : bd.getAll()) {
			if(bdr.getItemId() == itemId && bdr.getBidStatus() == 0) {
				hbids = new Bid(bdr.getId(), bdr.getPrice() , bdr.getOwnerId(), itemId); 
 				highbids.add(hbids);
			}
		}
		return highbids;
		
	}

	public boolean rejectBid(int num) {
		
		Bid rejectbid = bd.getById(num);
		rejectbid.setBidStatus(-1);
		return bd.update(rejectbid);
		
		
	}

	public boolean acceptBid(int number) {
		
		Bid acceptbid = bd.getById(number);
		acceptbid.setBidStatus(1);
		if (bd.update(acceptbid)) {
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
