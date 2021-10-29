package com.revature.controllers;

import java.util.Scanner;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeRegisterController {

	private static EmployeeService us = new EmployeeService();
		
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
			
		Employee newEmp = new Employee(name, username, password);
			
		try {
			newEmp = us.addEmployee(newEmp);
			System.out.println("Welcome " + newEmp.getName() + "!");
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Username is already in use.\nPlease try again.");
		}
	}
}
