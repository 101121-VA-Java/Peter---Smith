package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.models.Item;
import com.revature.services.ItemService;

public class ItemServiceTest {

	private static ItemService is;
	
	 @Test
	    void removeItem() {
	        int before = is.viewItems().size();
	        is.removeItem(1);
	        int after = is.viewItems().size();
	        assertNotEquals(before, after);
	    }

//	 @Test
//	 void add() {
//	        Item newItem = new Item(400, "name1", "description");
//	        int expected = is.viewItems().size() + ObjectSizeFetcher.getObjectSize(new Item());
//	        is.add(newItem);
//	        int actual = is.viewItems().size();
//	        assertNotEquals(expected, actual);
//	    }
	 
	 @Test 
	    void add() {
	        int before = is.viewItems().size();
	        is.add(new Item());
	        int after = is.viewItems().size();
	        assertNotEquals(before, after);
	    }
	 
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
	 
	 @Test 
	    void markItemAsOwned() {
	        assertTrue(is.markItemAsOwned(3, 400));
	    }

	 
	 
}
