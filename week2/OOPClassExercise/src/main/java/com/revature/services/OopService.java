package com.revature.services;

import com.revature.models.User;
import com.revature.interfaces.Confirmationable;
import com.revature.models.Pillow;
import com.revature.models.RushOrder;

import java.time.LocalDate;

public class OopService {

	public void doEncapsulation() {
		User u = new User();
		System.out.println("New user, no data");
		System.out.println(u);
		
		u.setUsername("Otto");
		u.setPassword("12345");
		u.setEmail("Otto@abc.com");
		System.out.println("Encapsulation, using setters");
		System.out.println(u);
		
		System.out.println("Encapsulation test, using getter");
		System.out.println("u email: " + u.getEmail());
		
		
	}

	public void doInheritance() {
		User u = new User();

		u.setUsername("Moe");
		u.setPassword("trwg7q");
		u.setEmail("");
		System.out.println("New user with data");
		System.out.println(u);
		
		LocalDate due = LocalDate.now();
		RushOrder ro = new RushOrder(100, due, due.plusDays(10));
		System.out.println("Inheritance test, creating Order from RushOrder extends");
		System.out.println(ro);
		
		ro.rush();
		System.out.println("Inheritance test, extended method to rush the date");
		System.out.println(ro); 
	}

	public void doPolymorphism() {

		LocalDate due = LocalDate.now();
		RushOrder ro = new RushOrder(101, due, due.plusDays(10));
		System.out.println("\"This prints toString() from method override RushOrder class: ");
		System.out.println(ro);
	
		System.out.println("Method overloading");
		System.out.println("Due date before: " + ro.getShipDate());
		ro.rush();
		System.out.println("Due date after Rush(): " + ro.getShipDate());
		ro.rush(5);
		System.out.println("Due date after rush(5): " + ro.getShipDate());

		
	}
	
	public void doAbstraction() {
				
		Confirmationable con = new Pillow();
		
		System.out.println("Using Confirmationable interface");
		con.sendConfirmationEmail();
	}
	
	public void doException() { 
	
		Pillow con = new Pillow();
		System.out.println("This will throw a new exception ThirtyThree");
		System.out.println("Trying to set order number to a negative number via Order setOrderNumber");
		con.setOrderNumber(0);
		
	}
	
	public void doHandleException() {
		
		RushOrder con = new RushOrder();
		System.out.println("Trying to set order number to a negative number via RushOrder.  SetOrderNumber is overridden to handle negative numbers");
		con.setOrderNumber(-1);
		System.out.println(con);
		System.out.println("See?!?  oderNumber was set to 0");
	}
}	

