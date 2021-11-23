package com.revature.services;

import java.util.Arrays;

import com.revature.daos.DaoFactory;
import com.revature.daos.UserDao;
import com.revature.models.ErsUsers;

public class AuthService {

	private UserDao ud;

	public AuthService() {
		ud = DaoFactory.getDaoFactory().getUserDao();
	}

	/**
	 * Service method to login an employee based on username/password
	 * @param String username, String password
	 * @return String token if credentials are valid, null otherwise
	 */
	public String login(String username, String password) {
		String token = null;
		ErsUsers principal = ud.getUserByUsernameAndPassword(username, password);
		if (principal != null) {
			/*
			 *  TODO add better implementation.  Got this one from Kevin!!
			 */
			token = principal.getId() + ":" + principal.getRole();
		}
		return token;
	}
	
	/**
	 * Service method to check the permission of the user to access certain functionalities
	 * @param String token, Role... allowedRoles
	 * @return true if a user is authenticated and has permission, false otherwise
	 */
	@SuppressWarnings("unlikely-arg-type")
	public boolean checkPermission(String token, String... allowedRoles) {
		if(token == null) {
			return false;
		}
		String[] info = token.split(":"); 
		int token_id = Integer.parseInt(info[0]);
		String token_role = info[1];
		ErsUsers principal = ud.getById(token_id);
		if(principal != null && token_role.equals(principal.getRole()) 	// Authentication of user: make sure user is logged in
				&& Arrays.asList(allowedRoles).contains(token_role)) {	// Authorization of user: make sure user has the permissions to use the functionality
			return true;
		}
		return false;
	}
	
}
