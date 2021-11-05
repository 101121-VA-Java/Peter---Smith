package com.revature.daos;

import java.util.List;

public interface GenericDao<T> {

	 int add(T t);
	 List<T> getAll();
	 T getById(int id);
	 boolean update(T t);
	 int delete(int id);

	
}
