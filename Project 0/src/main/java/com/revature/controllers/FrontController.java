package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	private static Scanner sc = new Scanner(System.in);
	
	public static void runMenu() {
		boolean run = true;
		while(run) {
			System.out.println("Welcome to The Greatest Pillow! What do you want to do today?:"
					+ "\n1: Employee Service"
					+ "\n2: Customer Service"
					+ "\n3: Exit");
			String choice = sc.nextLine();
			switch(choice) {
			case "1":
				EmployeeMenu(sc);
				System.out.println();
				break;
			case "2":
				CustomerMenu(sc);
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
	
	private static void CustomerMenu(Scanner sc2) {
		
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:"
					+ "\n1: Customer Login"
					+ "\n2: Customer Register"
					+ "\n3: Return to main menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
				CustomerShopController.run(sc2);
				System.out.println();
				break;
			case "2":
				CustomerRegisterController.run(sc2);
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

	private static void EmployeeMenu(Scanner sc2) {
		
		boolean empRun = true;
		while(empRun) {
			System.out.println("Please select from the following options:"
					+ "\n1: Employee Login"
					+ "\n2: Employee Register"
					+ "\n3: Return to main menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
				EmployeeLoginController.run(sc2);
				System.out.println();
				break;
			case "2":
				EmployeeRegisterController.run(sc2);
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
