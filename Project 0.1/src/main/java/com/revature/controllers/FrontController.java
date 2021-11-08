package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;

public class FrontController {

	public static boolean thisIsCustomer = false;
	public static boolean thisIsEmployee = false;
	public static boolean thisIsManager = false;
	public static Scanner sc = new Scanner(System.in);
	
	public static void runMenu() {
		boolean run = true;
		while(run) {
			System.out.println("Welcome to Mid Century Madness! Where you can find the best vintage items." 
					+ "\nWhat do you want to do today?:"
					+ "\n1: Login"
					+ "\n2: Register"
					+ "\n3: Exit");
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				UserController.login(sc);
//				LoginMenu(sc);
				System.out.println();
				break;
			case "2":
				RegisterMenu(sc);
				System.out.println();
				break;
			case "3":
				System.out.println("Thanks for visiting!");
				run = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}
		sc.close();
	}
	
private static void LoginMenu(Scanner sc2) {            //get rid of this method
		
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:"
					+ "\n1: Customer Login"
					+ "\n2: Employee Login"
					+ "\n3: Return to main menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
//				thisIsCustomer = true;
				UserController.login(sc2);
				System.out.println();
				break;
			case "2":
//				thisIsEmployee = true;
				UserController.login(sc2);
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

	private static void RegisterMenu(Scanner sc2) {
		
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:"
					+ "\n1: Customer Register"
					+ "\n2: Employee Register"
					+ "\n3: Return to main menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
				thisIsCustomer = true;
				UserController.run(sc2);
				System.out.println();
				break;
			case "2":
				thisIsEmployee = true;
				UserController.run(sc2);
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
