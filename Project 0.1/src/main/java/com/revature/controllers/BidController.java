package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Bid;
import com.revature.models.Item;
import com.revature.services.BidService;
import com.revature.services.ItemService;

public class BidController {

	private static BidService bs = new BidService();
	private static ItemService is = new ItemService();

	public void makeOffer(Scanner sc, int uId) {
		
		System.out.println("Please enter the ID of the item you want to bid on");
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
		System.out.println("The item selected is " + itm.getName() + " for $" + itm.getPrice());
		System.out.println("Is this correct? Y or N");
		String yorn = sc.nextLine();
		if (yorn.toLowerCase().equals("n")) {
			return;
		}
		
		System.out.println("Please enter your bid");
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

	public void viewOpenBids(Scanner sc, int userid) {
		List<Bid> bds = bs.getOpenBidsByUser(userid);
		if (bds.equals(null)) {
			System.out.println("You have no open bids");
		} else {
			for (Bid bids : bds) {
				System.out.println(is.getById(bids.getItemId()).getName() + ":  Your offer price: $" + bids.getPrice());
				System.out.println(); 
			}	
		}
		return;
	}

	public void acceptOrRejectItem(Scanner sc) {
		
		for (Bid bds : bs.getHighestOfferEachItem()) {
			
			is.getById(bds.getItemId()).toString();
			System.out.println("The highest offer price: $" + bds.getPrice());
			System.out.println();
		}
		
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:" 
					+ "\n1: Accept a highest offer"
					+ "\n2: Reject a highest offer"
					+ "\n3: Exit");

			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				System.out.println("Please enter the number of the bid you want to accept");
				String number1 = sc.nextLine();
				int number = Integer.parseInt(number1);
				if(number <0) {
					break;
				}
				if (!bs.acceptBid(number)) {
					System.out.println("Sorry, accepting the bid did not work");
				} else {
					System.out.println("Bid has been accepted");
				}	
				System.out.println();
				break;
			case "2":
				System.out.println("Please enter the number of the bid you want to reject");
				String num1 = sc.nextLine();
				int num = Integer.parseInt(num1);
				if(num <0) {
					break;
				}
				if (!bs.rejectBid(num)) {
					System.out.println("Sorry, rejection did not work");
				} else {
					System.out.println("Bid has been rejected");
				}
				System.out.println();
				break;
			case "3":	
				System.out.println();
				empRun = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}	
		return;	
	
	}

	

	
}
