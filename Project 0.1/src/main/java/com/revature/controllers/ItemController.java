package com.revature.controllers;

import java.util.List;
import java.util.Scanner;
import com.revature.models.Item;
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
		
		for (Item i : itms) {
			if (i.isOwned() == false) {
				System.out.println(i);
			}
		}
		
	}	
}
