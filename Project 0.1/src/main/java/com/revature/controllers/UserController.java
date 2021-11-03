package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;


public class UserController {

	private static boolean thisIsCustomer = false;
	private static boolean thisIsEmployee = false;
	private static UserService us = new UserService();
		
	public static void run(Scanner sc) {
		System.out.println();
		System.out.println("Please enter your name: (at least 4 char)");
		String name = sc.nextLine();
		if(name.trim().length() < 4) {
			System.out.println("Your name should be at least 4 characters.");
			return;
		}
		System.out.println("Please enter your username: at least 4 char");
		String username = sc.nextLine();
		if(username.trim().length() < 4) {
			System.out.println("Your username should be at least 4 characters.");
			return;
		}
			
		System.out.println("Please enter your password: at least 4 char");
		String password = sc.nextLine();
		if(password.trim().length() < 4) {
			System.out.println("Your password should be at least 4 characters.");
			return;
		}
			
		User newUser = new User(username, password);
			//       TODO add method in userservice to check if this exists  us.register
		if (newUser != null) {
			System.out.println("Welcome " + newUser.getName());
			if (thisIsCustomer) {
				CustomerMenu();
			}
            if (thisIsEmployee) {
            	employeeMenu(sc);
       		} else {
			System.out.println("Username is already in use.\nPlease try again.");
       		}
		}
		
	}

	private static void CustomerMenu() {
		System.out.println("Please select from the following options:"
				+ "\n1: View items for sale"
				+ "\n2: Make an offer for an item"
				+ "\n3: View my shopping cart"
				+ "\n4: View remaining payments"
				+ "\n5: Exit");
//      System.out.println("6: Log out");    TODO decide if needed
		
	}

	private static void employeeMenu(Scanner sc) {
		/* add item to the shop
		 * accept or reject offer
		 * remove item
		 * view all payments
		 */
		
		System.out.println("Please select from the following options:" 
				+ "\n1: Add item to the shop"
				+ "\n2: Accept or reject the current highest offer for an item"
				+ "\n3: Remove listing"
				+ "\n4: View all payments"
				+ "\n5: Exit");
//      System.out.println("6: Log out");    TODO decide if needed
	}
	
}
