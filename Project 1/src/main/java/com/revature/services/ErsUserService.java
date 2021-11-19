package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.UserDao;
import com.revature.models.ErsUsers;

public class ErsUserService {

	private UserDao ud;
	
	public ErsUserService() {
		ud = DaoFactory.getDaoFactory().getUserDao();
	}
	
	/**
	 * Service method to retrieve all employees, sets the employee passwords to null before returning them
	 * @return a List of Employees or an empty list if none are found
	 */
	public List<ErsUsers> getUsers(){
		
		List<ErsUsers> users = ud.getAll().stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return users;
	}

	/**
	 * Service method to retrieve an employee by id, sets the employee password to null before returning
	 * @param id of the employee
	 * @return a user or null if none is found
	 */
	public ErsUsers getUserById(int id){
		ErsUsers u = ud.getById(id);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
	
	/**
	 * Service method to retrieve an employee by its username and password, sets the employee password to null before returning
	 * @param username and password of the employee
	 * @return a user or null if none is found
	 */
	public ErsUsers getUserByUsernameAndPassword(String username, String password){
		ErsUsers u = ud.getUserByUsernameAndPassword(username, password);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
}
