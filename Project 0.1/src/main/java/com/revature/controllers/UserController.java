package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.UserService;


public class UserController {

	private static UserService us = new UserService();
	private static BidController bc = new BidController();
	private static PaymentController pc = new PaymentController();
	private static User newUser;
		
	public static void run(Scanner sc) {
		System.out.println();
		System.out.println("Please enter your name: (at least 1 char)");
		String name = sc.nextLine();
		if(name.trim().length() < 1) {
			System.out.println("Your name should be at least 1 characters.");
			return;
		}
		System.out.println("Please enter your username: (at least 1 char)");
		String username = sc.nextLine();
		if(username.trim().length() < 1) {
			System.out.println("Your username should be at least 1 characters.");
			return;
		}
			
		System.out.println("Please enter your password: (at least 4 char)");
		String password = sc.nextLine();
		if(password.trim().length() < 4) {
			System.out.println("Your password should be at least 4 characters.");
			return;
		}
		System.out.println();
		
//		if (FrontController.thisIsEmployee) {                               //TODO if time to implement manager                          
//			System.out.println("Please enter your pass number given to you by hiring manager)");
//			int managerId = sc.nextInt();
//		employeeMenu(sc);
//		}
		
		newUser = new User(name, username, password, 0);
		
		int reg = us.register(newUser);
		
		if (reg != -1) {
			System.out.println("Welcome " + newUser.getName());
			if (FrontController.thisIsEmployee) {
				employeeMenu(sc);
			}else if (FrontController.thisIsCustomer){
            	CustomerMenu(sc);
       		} 
		} else {
			System.out.println("Username is already in use.\nPlease try again.");
   		}
		
	}

	public static void login(Scanner sc) {
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		
		System.out.println("Please enter your password: ");
		String password = sc.nextLine();
		newUser = us.Login(username, password);
		if (newUser == null) {
			System.out.println("Sorry, username or password does not match. ");
		} else {
			System.out.println("Welcome " + newUser.getName());
			System.out.println();
			if (newUser.getRole().equals("EMPLOYEE")) {
				employeeMenu(sc);
			}else if (newUser.getRole().equals("CUSTOMER")){
            	CustomerMenu(sc);
       		} 
		}
		
	}
		
	private static void CustomerMenu(Scanner sc) {
		
		ItemController ic = new ItemController();
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:"
					+ "\n1: View items for sale"
					+ "\n2: Make a bid for an item"
					+ "\n3: View my current bids"
					+ "\n4: View items with remaining payments"
					+ "\n5: Make a payment"
					+ "\n6: View past purchased items"
					+ "\n7: Exit");
	//      System.out.println("6: Log out");    TODO decide if needed
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				ic.viewItems(); 
				break;
			case "2":
				bc.makeOffer(sc, newUser.getId());
				System.out.println();
				break;
			case "3":
				bc.viewOpenBids(sc, newUser.getId());
				System.out.println();
				break;
			case "4":
				ic.viewOpenBalanceItems(sc,newUser.getId());
				System.out.println();
				break;
			case "5":
				pc.makePayment(sc, newUser.getId());
				System.out.println();
				break;
			case "6":
				ic.viewPastBoughtItems(sc, newUser.getId());
				System.out.println();
				break;
			case "7":
				System.out.println();
				empRun = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}	

	}

	private static void employeeMenu(Scanner sc) {
		
		ItemController ic = new ItemController();
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:" 
					+ "\n1: Add item to the shop"
					+ "\n2: Accept or reject the current highest offer for an item"
					+ "\n3: Remove listing"
					+ "\n4: View all payments"
					+ "\n5: Exit");
//	      System.out.println("6: Log out");    TODO decide if needed
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				ic.addItem(sc); 
				break;
			case "2":
				bc.acceptOrRejectItem(sc);
				System.out.println();
				break;
			case "3":
				ic.removeItem(sc);
				System.out.println();
				break;
			case "4":
				pc.viewAllPayments();
				System.out.println();
				break;
			case "5":
				System.out.println();
				empRun = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}
	}
	
}
