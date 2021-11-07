package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.PaymentDao;
import com.revature.models.Item;
import com.revature.models.Payment;

public class PaymentService {

	ItemService is = new ItemService();
	PaymentDao pd = new PaymentDao();

	public List<Payment> getZeroBalancePaymentsByUserId(int id){
		
		List<Payment> userpayments = new ArrayList<>();
		Payment pyts = null;
		
		for (Payment pmnt : pd.getAll()) {
			if (pmnt.getUserId() == id && pmnt.getRemainingBalance() == 0) {
				pyts = new Payment(pmnt.getId(), pmnt.getItemId(), id, pmnt.getPayment(), pmnt.getRemainingBalance(), pmnt.getLastPaymentDate());
				userpayments.add(pyts);
			}
		}
		return userpayments;
	}
	
	public List<Payment> getOpenBalancePaymentsByUserId(int id){
		
		List<Payment> userpayments = new ArrayList<>();
		Payment pyts = null;
		
		for (Payment pmnt : pd.getAll()) {
			if (pmnt.getUserId() == id && pmnt.getRemainingBalance() != 0) {
				pyts = new Payment(pmnt.getId(), pmnt.getItemId(), id, pmnt.getPayment(), pmnt.getRemainingBalance(), pmnt.getLastPaymentDate());
				userpayments.add(pyts);
			}
		}
		return userpayments;
	}

	public Payment getPaymentbyItemId(int number) {
	
		for (Payment pmnt : pd.getAll()) {
			if (pmnt.getItemId() == number) {
				return pmnt;
				
			}
		}
		return null;
	}

	public void updateBalance(Payment pay, Item itm, int num) {
		
		if (num >= pay.getRemainingBalance()) {
			num = pay.getRemainingBalance();
			itm.setOwned(true);
			pay.setRemainingBalance(0);
		} else {
			pay.setRemainingBalance(pay.getRemainingBalance() - num);
		}
		pay.setLastPaymentDate(null);    //TODO curernt date
	}
}
