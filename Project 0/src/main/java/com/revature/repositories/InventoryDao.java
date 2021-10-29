package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.models.Inventory;

public interface InventoryDao {
	Inventory getAllInventory(); // returns an array of all of the employees available
	Employee getInventoryById(int id);
	int addInventory(Inventory inv); // returns assigned id
	Inventory editInventory(Inventory inv);  //returns boolean depending on operation success 
	boolean deleteInventory(int id);  //returns boolean depending on operation success 
}
