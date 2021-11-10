package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.Payment;
import com.revature.services.ItemService;
import com.revature.services.PaymentService;

public class PaymentController {

	PaymentService ps = new PaymentService();

	
	public void makePayment(Scanner sc, int userid) {

		ItemService is = new ItemService();
		System.out.println("Please enter the Payment number");		
		String number1 = sc.nextLine();
		int number = Integer.parseInt(number1);
		if(number1.trim().length() < 1 || number <=0) {
			return;
		}
		
		Payment pay = ps.getPaymentbyId(number);
		if (pay == null) {
				System.out.println("Your bid on that item has not been accepted");
				return;
		}
		if (pay.getUserId() != userid) {
			System.out.println("Incorrect payment number");
			return;
		}
		Item itm = is.getById(pay.getItemId());
		System.out.println("The total price is $" + itm.getPrice() + " and the remaining balance is $" + pay.getRemainingBalance());
		System.out.println("Please enter the amount of the payment");
		String num1 = sc.nextLine();
		int num = Integer.parseInt(num1);
		if(num1.trim().length() < 1 || num <=0) {
			System.out.println("Enter a positive amount next time. ");
			return;
		}

		if (ps.updateBalance(pay, num)) {
			System.out.println("Thank you for your payment");
		} else {
			System.out.println("Sorry your payment was not accepted");
		}
		
		
	}

	public void viewAllPayments() {
		
		List<Payment> pmts =  ps.viewItems();
		
		for (Payment i : pmts) {
			if(i.getPayment() != 0) {
				System.out.println("Payment #" + i.getId() + "  By customer #" + i.getUserId() + " paid $" + i.getPayment());
			}
		}
		if (pmts.isEmpty()) {
			System.out.println("There are no payments at this time");
		}
	}

	public  Payment getPaymentByItemIdAndUserId(int itemid, int userid) {
		
		return ps.getPaymentByItemIdAndUserId(itemid, userid);
	}
	
}
