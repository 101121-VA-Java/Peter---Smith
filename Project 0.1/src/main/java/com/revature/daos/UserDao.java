package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public class UserDao implements GenericDao<User> {

	UserPostgres up = new UserPostgres();
	
	@Override
	public int add(User t) {
		return (up.add(t));
		
	}
	@Override
	public List<User> getAll() {
		
		return up.getAll();
	}
	@Override
	public User getById(int id) {
	
		return up.getById(id);
	}
	@Override
	public boolean update(User t) {
	
		return up.update(t);
	}
	@Override
	public int delete(int id) {
		
		return up.delete(id);
	}
	
	  
}
