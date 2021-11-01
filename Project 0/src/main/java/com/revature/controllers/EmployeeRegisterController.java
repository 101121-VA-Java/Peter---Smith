package com.revature.controllers;

import java.util.Scanner;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeRegisterController {

	private static EmployeeService us = new EmployeeService();
		
	public static void run(Scanner sc) {
		System.out.println();
		System.out.println("Please enter your name: (at least 4 char)");
		String name = sc.nextLine();
		name = name.trim();
		if(name.length() < 4) {
			System.out.println("Your name should be at least 4 characters.");
			return;
		}
		System.out.println("Please enter your username: (at least 4 char)");
		String username = sc.nextLine();
		username = username.trim();
		if(username.length() < 4) {
			System.out.println("Your username should be at least 4 characters.");
			return;
		}
			
		System.out.println("Please enter your password: (at least 4 char).  Password is case sensitive");
		String password = sc.nextLine();
		password = password.trim();
		if(password.length() < 4) {
			System.out.println("Your password should be at least 4 characters.");
			return;
		}
			
		Employee newEmp = new Employee(name, username, password);
			
			newEmp = us.addEmployee(newEmp);
			if (newEmp != null) {
				System.out.println("Welcome " + newEmp.getName());
			} else {
				System.out.println("Username is already in use.\nPlease try again.");
		}
	}
}
