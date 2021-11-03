package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserDao implements GenericDao<User>{

	private final ArrayList<User> users = new ArrayList<>();

	public ArrayList<User> getUsers() {
		return users;
	}

	@Override
	public List<User> addList(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User add(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
