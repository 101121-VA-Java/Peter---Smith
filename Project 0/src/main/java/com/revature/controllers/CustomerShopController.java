package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerShopController {

	private static CustomerService cs = new CustomerService();
	private static Customer customer;
	private static Scanner sc;
	
	public static void run(Scanner scan) {
		sc = scan;
		
		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		try {
			customer = cs.login(username, password);

			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
		}
	}
	
	public static void CustomerMenu() {
		
	}
}	
