package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.EmployeeService;

public class EmployeeLoginController {

	private static EmployeeService es = new EmployeeService();
	private static Employee employee;
	
	public static void run(Scanner sc) {

		System.out.println();
		System.out.println("Please enter your username:");
		String username = sc.nextLine();
		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		
		employee = es.login(username, password);
		if	 (employee == null) {
			System.out.println("Invalid credentials");
			return;
		}
		System.out.println("Welcome " + employee.getName() + "!");
				
		System.out.println();
		System.out.println("Would you like to change your login credentials?:"
			+ "\n1: Yes"
			+ "\n2: No");
		String choice = sc.nextLine();
		if (choice.equals("1")) {
			ChangeEmployeeLogin(employee, sc);
		}

		Role choice1 = employee.getRole();
		if (choice1 == Role.MANAGER) {
			ManagerMenu(sc);
			System.out.println();
		} else if (choice1 == Role.ADMIN) {
			AdminMenu(sc);
			System.out.println();
		} else {	
			EmployeeMenu(sc);
			System.out.println();
		}
		
	}
	
	public static void ChangeEmployeeLogin(Employee emp, Scanner sc) {
		EmployeeService es2 = new EmployeeService();
		boolean run = true;
		while(run) {
			System.out.println("Please enter your NEW name: (at least 4 char)");
			String name = sc.nextLine();
			name = name.trim();
			if(name.length() < 4) {
				System.out.println("Your name should be at least 4 characters.");
			} else {
				System.out.println("Please enter your NEW username: (at least 4 char)");
				String username = sc.nextLine();
				username = username.trim();
				if(username.length() < 4) {
					System.out.println("Your username should be at least 4 characters.");
				} else {
				
					System.out.println("Please enter your New password: (at least 4 char).  Password is case sensitive");
					String password = sc.nextLine();
					password = password.trim();
					if(password.length() < 4) {
						System.out.println("Your password should be at least 4 characters.");
					} else {
				//  we can now check if the new username and or password is already in use.  
						
						Employee employee2 = es2.login(username, password);
						if	 (employee2 != null) {
							System.out.println("Credentials already in use.\nPlease try again.");
						} else {
							emp.setName(name);
							emp.setPassword(password);
							emp.setUsername(username);
							run = false;
					
						}
					}
				}
			}
		}	
	}


	public static void EmployeeMenu(Scanner sc2) {
		System.out.println("Hi " + employee.getName() + ". You have reached Employee menu");
	/*
	 * view tasks assigned to me
	 * update status of tasks assigned to me
	 * add item to the shop
	 * remove item from the shop
	 * accept or reject pending offer for item	
	 * view all payments
	 */
		
		boolean empRun = true;
		while(empRun) {
			System.out.println();
			System.out.println("Please select from the following options:"
					+ "\n1: View/Edit tasks assigned to me"
					+ "\n2: Pending offers for items"
					+ "\n3: View/Add/Remove Items from inventory"
					+ "\n4: View all payments"
					+ "\n5: Retuen to previous menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
//				EmployeeLoginController.run(sc2);
				System.out.println();
				break;
			case "2":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "3":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "4":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;	
			case "5":
				System.out.println();
				empRun = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}
	}
	
	public static void ManagerMenu(Scanner sc2) { 
		System.out.println("Hi " + employee.getName() + ". You have reached Manager menu");
	/*
	 * view employees assigned to me
	 * assign tasks with due dates	
	 * change task due dates
	 * add item to the shop
	 * remove item from the shop
	 * accept or reject pending offer for item	
	 * 	 * view all payments
	 */
		
		boolean empRun = true;
		while(empRun) {
			System.out.println();
			System.out.println("Please select from the following options:"
					+ "\n1: View employess and tasks"
					+ "\n2: Pending offers for items"
					+ "\n3: View/Add/Remove Items from inventory"
					+ "\n4: View all payments"
					+ "\n5: Retuen to previous menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
				EmployeeService es2 = new EmployeeService();
				List<Employee> e = es2.getEmployeesByManager(employee.getId());
				for(Employee emp3 : e) {
					System.out.println(emp3.getName());
				}	
				System.out.println();
				break;
			case "2":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "3":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "4":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;	
			case "5":
				System.out.println();
				empRun = false;
				break;
			default:
				System.out.println("Invalid selection, please try again");
				System.out.println();
			}
		}
	}
	
	public static void AdminMenu(Scanner sc2) {
		System.out.println("Hi " + employee.getName() + ". You have reached Admin menu");
		/*
		 * view all employees and managers
		 * assign tasks with due dates
		 * change task due dates
		 * add item to the shop
		 * remove item from the shop
		 * accept or reject pending offer for item	
		 * 	 * view all payments
		 */
		
		boolean empRun = true;
		while(empRun) {
			System.out.println();
			System.out.println("Please select from the following options:"
					+ "\n1: View employess and managers"
					+ "\n2: Pending offers for items" 
					+ "\n3: View/Add/Remove Items from inventory"
					+ "\n4: View all payments"
					+ "\n5: Retuen to previous menu");
			String choice = sc2.nextLine();
			switch(choice) {
			case "1":
				EmployeeService es2 = new EmployeeService();
				List<Employee> managers = es.getAllManagers();
				for(Employee e : managers) {
					System.out.println("Manager: " + e.getName());
					System.out.println("Assigned Employees:");
					List<Employee> employee = es2.getEmployeesByManager(e.getId());
					for(Employee m : employee) {
						System.out.println(m.getName());
					}	
				}	
				System.out.println();
				break;
			case "2":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "3":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;
			case "4":
//				EmployeeRegisterController.run(sc2);
				System.out.println();
				break;	
			case "5":
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

   
