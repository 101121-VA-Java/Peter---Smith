package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.services.UserService;


public class UserController {

	private static ItemController ic = new ItemController();
	private static UserService us = new UserService();
		
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
		
//		if (FrontController.thisIsEmployee) {                               //TODO if time to implement manager                          
//			System.out.println("Please enter your pass number given to you by hiring manager)");
//			int managerId = sc.nextInt();
//		employeeMenu(sc);
//		}
		
		User newUser = new User(username, password);
		
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
		User newUser = us.Login(username, password);
		if (newUser == null) {
			System.out.println("Sorry, username or password does not match. ");
		} else {
			System.out.println("Welcome " + newUser.getName());
			if (FrontController.thisIsEmployee) {
				employeeMenu(sc);
			}else if (FrontController.thisIsCustomer){
            	CustomerMenu(sc);
       		} 
		}
		
	}
		
	private static void CustomerMenu(Scanner sc) {
		System.out.println("Please select from the following options:"
				+ "\n1: View items for sale"
				+ "\n2: Make an offer for an item"
				+ "\n3: View my shopping cart"
				+ "\n4: View remaining payments"
				+ "\n5: Exit");
//      System.out.println("6: Log out");    TODO decide if needed
		
	}

	private static void employeeMenu(Scanner sc) {
	
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
//				System.out.println("Please enter item name: ");
//				String name = sc.nextLine();
//				if(name.trim().length() < 1) {
//					System.out.println("The name should be at least 1 character.");
//					break;
//				}
//				System.out.println("Please enter item price: ");
//				String price1 = sc.nextLine();
//				int price = Integer.parseInt(price1);
//				if(price1.trim().length() < 1 || price <=0) {
//					break;
//				}
//				System.out.println("Please enter item price: ");
//				String description = sc.nextLine();
//
//				Item newItem = new Item(price, name, description);
//				if (ui.add(newItem) == -1) {  //  error adding item
//					System.out.println("There was a problem adding the item.  Please try again ");
//				} else {
//					System.out.println("Item added succesfully");
//				}
				break;
			case "2":
				
				UserController.run(sc);
				 // TODO some error checking
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
	}
	
}
