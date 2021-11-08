package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.BidDao;
import com.revature.models.Bid;
import com.revature.models.Item;

public class BidService {

	BidDao bd = new BidDao();
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

	public List<Bid> getHighestOfferEachItem() {
		
//		int biditemid = -1;
		boolean firsttime = true;
		boolean add = false;
		int price;
		List<Bid> highbids = new ArrayList<>(); 
		Bid hbids = null;
		for (Bid bdr : getAllOpenBids()) {
			System.out.println("11111");
			price = 0;
//			add = false;
			for (Bid bddr : getBidsByItem(bdr.getItemId())) {
//				add = false;
				System.out.println("22222");
				if (bddr.getPrice() > price) {
					System.out.println("333333");
					price = bddr.getPrice();
					hbids = new Bid(bddr.getId(), bddr.getPrice() , bddr.getOwnerId(), bddr.getItemId()); 
//					add = true;
//					biditemid = bddr.getItemId();
				}
			}
			if (firsttime) {
				System.out.println("44444");
				highbids.add(hbids);
				
				firsttime = false;
			} else {
//				if (add) {1
				add = true;
//					System.out.println("55555");
//					for (Bid bidr : highbids) {
//						System.out.println("66666");
//						System.out.println(bidr);
//						if (bidr.getItemId() == bdr.getItemId()) {
//							System.out.println("77777");
//							add = false;	
//						}
//					}
					if (add) {
						System.out.println("88888");
						highbids.add(hbids);
					}
//				}
			}
			
		}
		return highbids;
		
	}
	
	public List<Bid> getAllOpenBids() {
		
		List<Bid> allopenbids = new ArrayList<>(); 
		Bid hbids = null;
		for (Bid bdr : bd.getAll()) {
			if(bdr.getBidStatus() == 0) {
				System.out.println("0000");
				hbids = new Bid(bdr.getId(), bdr.getPrice() , bdr.getOwnerId(), bdr.getItemId()); 
 				allopenbids.add(hbids);
			}
		}
		return allopenbids;
	}
	
	public List<Bid> getBidsbyItem(int itemId) {
		
		List<Bid> highbids = new ArrayList<>(); 
		Bid hbids = null;
		System.out.println("656565");
		for (Bid bdr : bd.getAll()) {
			System.out.println("121212");
			System.out.println(bdr.getItemId());
			System.out.println(itemId);
			if(bdr.getItemId() == itemId) {
				System.out.println("99999");
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
		if (acceptbid.equals(null)) {
			return false;
		}
		acceptbid.setBidStatus(1);
		if (bd.update(acceptbid)) {
			is.markItemAsOwned(acceptbid.getItemId());              //  Bid has been accepted, mark the item as 'owned'
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
