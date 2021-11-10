package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.revature.models.Item;
import com.revature.services.ItemService;

public class ItemServiceTest {

	private static ItemService is = new ItemService();

	

	 @Order(1)
	 @Test 
	    void add() {
	        int before = is.viewItems().size();
	        is.add(new Item());
	        int after = is.viewItems().size();
	        assertNotEquals(before, after);
	    }
	 
	 @Order(2)
	 @Test
	    void removeItem() {
	        int before = is.viewItems().size();
	        is.removeItem(16);
	        int after = is.viewItems().size();
	        assertNotEquals(before, after);
	    }

	 @Order(3)
	 @Test 
	    void getById() {
//	        Item before = (15, 833, "Backhoe", "Green", true);
	        Item actual = is.getById(15);
	        assertAll(() -> assertEquals(15, actual.getId()),
	        		 () -> assertEquals(833, actual.getPrice()),
	                 () -> assertEquals("Backhoe", actual.getName()),
	            	 () -> assertEquals("Green", actual.getDescription()),
	                 () -> assertTrue(actual.isOwned())
	         );
	    }
	 
	 @Order(4)
	 @Test 
	    void updateItem() {
		 	Item n = is.getById(3);
		 	n.setPrice(400);
	        assertTrue(is.updateItem(n));
	    }

//	 
//   ugh!  need to list all items	 
//	 @Test 
//	    void viewItems() {
//
//	        List<Item> actual = is.viewItems();
//	        assertAll(() -> assertEquals(15, actual.getId()),
//	        		 () -> assertEquals(833, actual.getPrice()),
//	                 () -> assertEquals("Backhoe", actual.getName()),
//	            	 () -> assertEquals("Green", actual.getDescription()),
//	                 () -> assertTrue(actual.isOwned())
//	         );
//	    }
	 
	 @Order(5)
	 @Test 
	    void markItemAsOwned() {
	        assertTrue(is.markItemAsOwned(3, 400));
	    }
	 
	 @Order(6)
	 @Test 
	 void getOpenBalanceItemsByUserId() {
		 	List<Item> n = is.getopenBalanceItemsByUserId(0);
		 	assertTrue(n.isEmpty());
	    }
	 
	 @Order(7)
	 @Test 
	 void getPastPurchasedItemsByUserId() {
		 	List<Item> n = is.getPastPurchasedItemsByUserId(0);
		 	assertTrue(n.isEmpty());
	    }
	 
	}
