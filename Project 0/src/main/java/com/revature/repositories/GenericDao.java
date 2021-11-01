package com.revature.repositories;

import java.util.List;

//An interface for other Daos to extend
public interface GenericDao<T> {
	
	/*
	 * add
	 * getById
	 * getAll
	 * update
	 * 
	 * delete
	 */

	List<T> addList(T t);
	T add(T t);
	T getById(int id);
	List<T> getAll();
	boolean update(T t);
	boolean delete(T t);
}