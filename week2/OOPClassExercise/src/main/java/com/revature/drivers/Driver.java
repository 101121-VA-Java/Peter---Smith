package com.revature.drivers;

import java.util.Scanner;
import com.revature.services.OopService;

public class Driver {

 private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		OopService oop = new OopService();
		System.out.println("What would like to do?");
		String choice = sc.nextLine();
		switch(choice.toLowerCase()) {
			case "encapsulation":
				oop.doEncapsulation();
				break;
			case "inheritance":
				oop.doInheritance();
				break;
			case "polymorphism":
				oop.doPolymorphism();
				break;
			case "abstraction":
				oop.doAbstraction();
				break;
			case "exception":
				oop.doException();
				break;
			case "handleexception":
				oop.doHandleException();
				break;
			default:
				System.out.println("Option not available.");
		}
		sc.close();
	}
	
	
}
