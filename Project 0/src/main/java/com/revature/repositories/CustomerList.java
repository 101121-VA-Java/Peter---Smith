package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;


public class CustomerList implements CustomerDao {

	private List<Customer> customers;

	public CustomerList() {
		customers = new ArrayList<>();
		// System defined EnrollmentAdmin User added to the customers list to be used as
		// default admin for all new user
//		Customer EnrollmentAdmin = new Customer(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN,
//				null);
//		customers.add(EnrollmentAdmin);
	}

	@Override
	public Customer add(Customer t) {
		// generating a new id for new customers
		t.setId(customers.size());
		// add method returns true if adding to a collection was successful
		customers.add(t);
		// TODO add check that add was successful
		return t;

	}

	@Override
	public Customer getById(int id) {
		// Iterate to see if customers contain the id
		for (Customer c : customers) {
			// returns the customer if found
			if (c.getId() == id) {
				return c;
			}
		}
		// returns null otherwise
		return null;
	}

	@Override
	public List<Customer> getAll() {
		return customers;
	}

	@Override
	public boolean update(Customer t) {
		Customer temp = getById(t.getId());
		if (temp == null || temp.equals(t)) {
			return false;
		}
		customers.set(t.getId(), t);
		return true;
	}
}
