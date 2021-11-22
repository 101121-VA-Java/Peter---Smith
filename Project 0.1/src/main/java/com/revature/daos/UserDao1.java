package com.revature.daos;

import java.util.List;

import com.revature.models.ErsUsers;

public interface UserDao1 {

	int add(ErsUsers t);
	List<ErsUsers> getAll();
	ErsUsers getById(int id);
	boolean update(ErsUsers t);
	ErsUsers getUserByUsernameAndPassword(String username, String password);
	
}
