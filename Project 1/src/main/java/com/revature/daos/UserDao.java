package com.revature.daos;

import java.util.List;

import com.revature.models.ErsUsers;

public class UserDao implements GenericDao<ErsUsers>{

	private UserPostgres up = new UserPostgres();
	
	@Override
	public int add(ErsUsers t) {
		return up.add(t);
	}

	@Override
	public List<ErsUsers> getAll() {
		return up.getAll();
		}

	@Override
	public ErsUsers getById(int id) {
		return up.getById(id);
	}

	@Override
	public boolean update(ErsUsers t) {
		return up.update(t);
	}

	@Override
	public int delete(int id) {
		return up.delete(id);
	}

	public ErsUsers getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
