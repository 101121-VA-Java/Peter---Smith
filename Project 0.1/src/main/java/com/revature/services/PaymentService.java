package com.revature.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.PaymentDao;
//import com.revature.models.Item;
import com.revature.models.Payment;

public class PaymentService {

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

	public void updateBalance(Payment pay, int num) {
		
		LocalDate localDate = LocalDate.now();
		if (num >= pay.getRemainingBalance()) {
			num = pay.getRemainingBalance();
			pay.setRemainingBalance(0);
		} else {
			pay.setRemainingBalance(pay.getRemainingBalance() - num);
		}
		pay.setLastPaymentDate(localDate);    
		pd.update(pay);
	}

	public Payment createNewPayment(int itemId, int userId) {
		
		ItemService is = new ItemService();
		Payment newpayment = new Payment(itemId, userId, 0, is.getById(itemId).getPrice());
		return newpayment;
	}

	public List<Payment> viewItems() {
		
		List<Payment> userpayments = new ArrayList<>();
		Payment pyts = null;
		
		for (Payment pmnt : pd.getAll()) {
			pyts = new Payment(pmnt.getId(), pmnt.getItemId(), pmnt.getUserId(), pmnt.getPayment(), pmnt.getRemainingBalance(), pmnt.getLastPaymentDate());
			userpayments.add(pyts);
		}
		return userpayments;
		
	}

	public Payment getPaymentByItemIdAndUserId(int itemid, int userid) {
		
		for (Payment pmnt : pd.getAll()) {
			if (pmnt.getItemId() == itemid && pmnt.getUserId() == userid) {
				return pmnt;
				
			}
		}
		return null;
	}

	public Payment getPaymentbyId(int number) {
		
		return pd.getById(number);
	}

}
