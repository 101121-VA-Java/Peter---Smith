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

	public boolean updateBalance(Payment pay, int amount) {
		
		LocalDate localDate = LocalDate.now();
		if (amount >= pay.getRemainingBalance()) {
			amount = pay.getRemainingBalance();
			pay.setRemainingBalance(0);
		} else {
			pay.setRemainingBalance(pay.getRemainingBalance() - amount);
		}
		pay.setLastPaymentDate(localDate);    
		return pd.update(pay);
	}

	public int createNewPayment(int bidId, int userId) {
		
		BidService bs = new BidService();
		Payment newpayment = new Payment(bs.getById(bidId).getItemId() , userId, 0, bs.getById(bidId).getPrice(), LocalDate.now());
		return pd.add(newpayment);
		
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
