package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Density;
import com.revature.models.Inventory;
import com.revature.models.Pillow;
import com.revature.models.Size;

public class InventoryController {

	static void menu() {
		System.out.println("1- Add new item ");
		System.out.println("2- Display all items ");
		System.out.println("3- Remove an item ");
		System.out.println("4- Display items by id ");
		System.out.println("5- Edit an item ");
		System.out.println("6- Exit ");
	}
	
	public void InventoryDisplay(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			menu();
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				Pillow inv = new Pillow();
				System.out.println("Enter the item number ");
				inv.setId(sc.nextInt());
				System.out.println("Enter the item size ");
				inv.setSize(Size.valueOf(sc.nextLine()));
				System.out.println("Enter the item density ");
				inv.setDensity(Density.valueOf(sc.nextLine()));
				System.out.println("Enter the item price ");
				inv.setPrice(sc.nextDouble());
				break;
			case "2":
				break;
			case "3":
				
				break;
			case "4":
				break;
			case "5":
				
				break;
			case "6":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}	
	}
}
