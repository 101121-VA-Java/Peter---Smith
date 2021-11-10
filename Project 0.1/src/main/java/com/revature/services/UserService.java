package com.revature.services;

import com.revature.controllers.FrontController;
import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.util.LoggerUtil;

public class UserService {

	
	UserDao ud = new UserDao();

	public int register(User newUser) {
		
		if (FrontController.thisIsEmployee) {
			newUser.setRole("EMPLOYEE");
		} else if (FrontController.thisIsCustomer){
			newUser.setRole("CUSTOMER");
		}
		
		int newUserId = -1;                                    
		try{
            newUserId = ud.add(newUser);
            if(newUserId == -1) throw new Exception();
        } catch(Exception e){
            LoggerUtil.descriptiveError("Registration failed. User already exists or bad input.");
        }
        return newUserId;
		
	}
	
	public User Login(String username, String password) {
		
		try {
			for (User user : ud.getAll()) {
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					return user;
				}
			}
			 throw new Exception();
        } catch (Exception e) {
            LoggerUtil.descriptiveError("Bad username/password");
        }
			
		return null;
	}

	}
