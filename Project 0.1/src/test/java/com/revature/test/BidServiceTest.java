package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.revature.daos.BidDao;
import com.revature.models.Bid;
import com.revature.services.BidService;

public class BidServiceTest {
	public static int d;
	private static BidService bs = new BidService();
	private static BidDao bd = new BidDao();
	
	 @Test 
	    void getById() {
	        Bid actual = bs.getById(7);
	        assertAll(() -> assertEquals(7, actual.getId()),
	        		 () -> assertEquals(500, actual.getPrice()),
	                 () -> assertEquals(8, actual.getBidderId()),
	            	 () -> assertEquals(6, actual.getItemId()),
	                 () -> assertEquals(-1,actual.getBidStatus())
	         );
	    }
	 
	 @Test 
	    void makeBid() {
	        int before = bd.getAll().size();
	        d = bs.makeBid(4, 300, 1);
	        int after = bd.getAll().size();
	        assertNotEquals(before, after);
	    }
	 
	 @Test 
	 void getOpenBidsByUser() {
		 	List<Bid> n = bs.getOpenBidsByUser(2);
		 	 assertTrue(n.isEmpty());
	    }
	 
	 @Test 
	 void getBidsByUser() {
		 	List<Bid> n = bs.getBidsByUser(2);
		 	 assertTrue(n.isEmpty());
	    }
	 
	 @Test 
	 void getBidsByItem() {
		 	List<Bid> n = bs.getBidsByItem(2);
		 	 assertTrue(n.isEmpty());
	    }
//    a lot if bids to add  :(	 
//	 @Test 
//	 void getOffersEachItem() {
//		 	List<Bid> n = bs.getOffersEachItem();
//		    assertAll(() -> assertEquals(7, n.getId()),
//	        		 () -> assertEquals(500, n.getPrice()),
//	                 () -> assertEquals(8, n.getBidderId()),
//	            	 () -> assertEquals(8, n.getItemId()),
//	                 () -> assertEquals(-1, n.getBidStatus())
//	         );
//	    }
	 
	 
	 @Test 
	    void rejectBid() {
	        assertFalse(bs.rejectBid(300));
	    }
	 
//	 @Test 
//	    void acceptBid() {
//	        assertFalse(bs.acceptBid(300));
//	    }
	 
	 @Test 
	    void markBidsAsRejected() {
	        assertFalse(bs.markBidsAsRejected(300));
	    }
	 
	 @Test 
	    void getAcceptedBids() {
			List<Bid> n = bs.getAcceptedBids(200);
	        assertTrue(n.isEmpty());
	
	    }
	 
	 @AfterAll
		public static void tearDown() {
			bd.delete(d);
		}
}
