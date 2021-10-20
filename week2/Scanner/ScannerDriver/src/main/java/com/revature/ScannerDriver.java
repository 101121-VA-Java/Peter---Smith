package com.revature; 

/*
 * Create a menu that gives a user multiple options:
 * 		- 1: get a random number
 * 		- 2: Using StringBuffer, reverse a word of the user's choice
 * 		- 3: exit the program
 * This menu should repeat until the user decides to exit.
 */

import java.util.Random;
import java.util.Scanner;

public class ScannerDriver {
static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			int option = ScannerDriver.chooseOption();

			switch(option) {
		
			case 1:
				ScannerDriver.RandomNumber();
				break;
			case 2:
				ScannerDriver.ReverseWord();
				break;
			case 3:
				run = false;
				ScannerDriver.ExitApp();
				break;
			default:
				System.out.println("Invalid number, please try again.");
			}
			
		}	
		sc.close();
	}
	

	public static int chooseOption() {
				
		System.out.println("Please choose from the options below:");
		System.out.println("Choose 1 for a random number:");
		System.out.println("Choose 2 to reverse a word of your choice:");
		System.out.println("Choose 3 to exit:");
		System.out.println();
		int input = sc.nextInt();
	return input;	

	}
	public static void RandomNumber() {
		Random rand = new Random();
		int randint = rand.nextInt(50);
		System.out.println("Your random number is: " + randint);
		
	return;	

	}
	public static void ReverseWord() {
		sc.nextLine();
		System.out.println("Please enter a word:");
		StringBuffer sb = new StringBuffer(sc.nextLine());
		System.out.println("Your reversed word is: " + sb.reverse());
		
	return;	

	}
	public static void ExitApp() {
		System.out.println("Goodbye!");
		
		return;	
	}	
}

