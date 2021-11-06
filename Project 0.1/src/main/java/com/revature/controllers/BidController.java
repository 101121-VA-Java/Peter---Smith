package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Bid;
import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.BidService;
import com.revature.services.ItemService;

public class BidController {

	private static BidService bs = new BidService();
	private static ItemService is = new ItemService();

	public void makeOffer(Scanner sc, int uId) {
		
		System.out.println("Please enter the number of the item you want to bid on");
		String number1 = sc.nextLine();
		int number = Integer.parseInt(number1);
		if(number <0) {
			return;
		}
		
		Item itm = is.getById(number);
		if (itm == null) {
			System.out.println("Sorry that item number does not exist");
			System.out.println();
			return;
		}
		System.out.println();
		System.out.println("The item selected is:");
		itm.toString();
		System.out.println();
		System.out.println("Is this correct? Y or N");
		String yorn = sc.nextLine();
		if (yorn.toLowerCase() == "n") {
			return;
		}
		
		System.out.println("How much do you want to offer for " + itm.getName() + "?");
		String offer1 = sc.nextLine();
		int offer = Integer.parseInt(offer1);
		if(offer <0) {
			System.out.println("Sorry, we can't accept that offer");
			return;
		}
		
		if (bs.makeBid(itm.getId(), offer, uId) == -1) {
			System.out.println("Sorry that bid was not accepted.  Please try again");
		} else {
			System.out.println("Bid accepted. Good luck!");
		}
		
		return;
	}

	public void viewBids(Scanner sc, int id) {
	
		for (Bid bds : bs.getUserBids(id)) {
		
			is.getById(bds.getItemId()).toString();
			System.out.println("Your offer price: $" + bds.getPrice());
			System.out.println();
		}
		return;
	}
	
}
