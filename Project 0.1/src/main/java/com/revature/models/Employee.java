package com.revature.models;

import com.revature.repositories.ItemDao;

public class Employee extends User{

	private String payment;
    private ItemDao shoppingCart;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String username, String password, String role) {
		super(id, name, username, password, role);
		// TODO Auto-generated constructor stub
	}
	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
    
    
}
