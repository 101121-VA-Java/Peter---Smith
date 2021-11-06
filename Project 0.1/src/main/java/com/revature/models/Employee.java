package com.revature.models;

import com.revature.daos.ItemDao;

public class Employee extends User{

	private String payment;
    private ItemDao shoppingCart;
    
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
    
    
}
