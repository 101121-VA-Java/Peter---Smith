package com.revature.controllers;

import java.util.List;
import java.util.Scanner;
import com.revature.models.Item;
import com.revature.models.Payment;
import com.revature.services.ItemService;

public class ItemController {

	
	private static ItemService is = new ItemService();
	
	
	void addItem(Scanner sc) {
		System.out.println("Please enter item name: ");
		String name = sc.nextLine();
		if(name.trim().length() < 1) {
			System.out.println("The name should be at least 1 character.");
			return;
		}
		System.out.println("Please enter item price: ");
		String price1 = sc.nextLine();
		int price = Integer.parseInt(price1);
		if(price1.trim().length() < 1 || price <=0) {
			return;
		}
		System.out.println("Please enter item description (max 50 characters): ");
		String description = sc.nextLine();
	
		Item newItem = new Item(price, name, description);
		if (is.add(newItem) == -1) {  //  error adding item
			System.out.println("There was a problem adding the item.  Please try again ");
		} else {
			System.out.println("Item added succesfully");
		}
		return;
	}


	public void removeItem(Scanner sc) {
		
		System.out.println("Please enter item number to remove: ");
		String number1 = sc.nextLine();
		int number = Integer.parseInt(number1);
		if(number <0) {
			return;
		}
		if (is.removeItem(number) == -1) {
			System.out.println("That item number does not exist.  Please try again ");
		} else {
			System.out.println("Item removed succesfully");
		}
		return;
	}


	public void viewItems() {
		
		
		List<Item> itms =  is.viewItems();
		System.out.println(" ID   PRICE   NAME      DESCRIPTION");
		for (Item i : itms) {
			if (!i.isOwned()) {
				System.out.println(i.getId() + "     " + i.getPrice() + "     " + i.getName() + "        " + i.getDescription());
			}
		}
		System.out.println();
	}


	public void viewPastBoughtItems(Scanner sc, int id) {
		
		List<Item> itms = is.getPastPurchasedItemsByUserId(id);
		if (itms.isEmpty() ) {
			System.out.println("You have not purchased any items");
		} else {
			System.out.println("Your past items:");
			for (Item items : itms) {
				System.out.println(items.getName());
			}	
		}
		
		System.out.println();
	}


	public void viewOpenBalanceItems(Scanner sc, int userid) {
		PaymentController pc = new PaymentController();
		List<Item> itms = is.getopenBalanceItemsByUserId(userid);
		if (itms.isEmpty() ) {
			System.out.println("You have no itmes with a remaining payment");
		} else {
			System.out.println("Your items with a remaining balance:");
			for (Item items : itms) {
				Payment p = pc.getPaymentByItemIdAndUserId(items.getId(), userid);
				System.out.println("Payment #" + p.getId() + ":  "+ items.getName() + " has a balance of $" + p.getRemainingBalance());
			}	
		}
		System.out.println();
		
	}
		

}
