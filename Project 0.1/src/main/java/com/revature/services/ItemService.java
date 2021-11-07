package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ItemDao;
import com.revature.models.Item;
import com.revature.models.Payment;


public class ItemService {

	ItemDao id = new ItemDao();
	PaymentService ps = new PaymentService();
	
	
	public int add(Item newItem) {
		
		return id.add(newItem);
	}


	public int removeItem(int number) {
		return id.delete(number);
		
	}


	public List<Item> viewItems() {
		
		return id.getAll();
		
		
	}
	
	public Item getById(int number) {
		return id.getById(number);
		
	}


	public List<Item> getPastPurchasedItemsByUserId(int id2) {
		
		List<Item> paiditems = new ArrayList<>();

		for (Payment pmnt : ps.getZeroBalancePaymentsByUserId(id2)) {
			paiditems.add(getById(pmnt.getItemId()));
		}
		return paiditems;
	}


	public List<Item> getopenBalanceItemsByUserId(int id2) {
		List<Item> openitems = new ArrayList<>();

		for (Payment pmnt : ps.getOpenBalancePaymentsByUserId(id2)) {
			openitems.add(getById(pmnt.getItemId()));
		}
		return openitems;
	}
	
}
