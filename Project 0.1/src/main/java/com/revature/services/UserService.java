package com.revature.services;

import com.revature.controllers.FrontController;
import com.revature.daos.UserDao;
import com.revature.daos.UserPostgres;
import com.revature.models.Item;
import com.revature.models.User;

public class UserService {

	
	UserDao ud = new UserDao();

	public int register(User newUser) {
		
		if (FrontController.thisIsEmployee) {
			newUser.setRole("EMPLOYEE");
		} else if (FrontController.thisIsCustomer){
			newUser.setRole("CUSTOMER");
		}
		
		return ud.add(newUser);
		                                    // TODO add logging here?
	}
	
	public User Login(String username, String password) {
		
		for (User user : ud.getAll()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

	}
