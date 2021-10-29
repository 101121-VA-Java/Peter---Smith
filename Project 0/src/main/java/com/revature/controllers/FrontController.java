package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
private static Scanner sc = new Scanner(System.in);
	
	public static void runMenu() {
		boolean run = true;
		while(run) {
			System.out.println("Welcome to The Greatest Pillow! Please select from the following options:"
					+ "\n1: Employee Login"
					+ "\n2: Employee Register"
					+ "\n3: Customer Login"
					+ "\n4: Customer Register"
					+ "\n5: Exit");
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				EmployeeLoginController.run(sc);
				System.out.println();
				break;
			case "2":
				EmployeeRegisterController.run(sc);
				System.out.println();
				break;
			case "3":
				CustomerShopController.run(sc);
				System.out.println();
				break;
			case "4":
				CustomerRegisterController.run(sc);
				System.out.println();
				break;
			case "5":
				System.out.println("Thanks for visiting!");
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
				System.out.println();
			}
		}
		sc.close();
	}
	
}
