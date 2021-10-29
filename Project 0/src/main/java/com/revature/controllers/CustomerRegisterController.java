package com.revature.controllers;

import java.util.Scanner;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerRegisterController {

	private static CustomerService us = new CustomerService();
		
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
			
		Customer newCus = new Customer(name, username, password);
			
		try {
			newCus = us.addCustomer(newCus);
			System.out.println("Welcome " + newCus.getName() + "!");
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username is already in use.\nPlease try again.");
		}
	}
}

