package com.revature.services;

import java.util.List;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Role;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerList;

public class CustomerService {

private static CustomerDao cd = new CustomerList();
	
	public Customer addCustomer(Customer c) throws UsernameAlreadyExistsException {

		Customer newCus = this.getCustomerByUsername(c.getUsername());
		if(newCus != null) {
			throw new UsernameAlreadyExistsException();
		}
//		e.setRole(Role.BASIC_USER);
//		e.setManager(ed.getById(0));
 
		return cd.add(c);
	}
	
	public Customer getCustomerByUsername(String username){
		List<Customer> Customers = cd.getAll();
		for(Customer c : Customers) {
			if (c.getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer login(String username, String password) throws LoginException {
		Customer cus = this.getCustomerByUsername(username);
		if(cus == null || !cus.getPassword().equals(password)) {
			throw new LoginException();
		}
		return cus;
	}

	
}
