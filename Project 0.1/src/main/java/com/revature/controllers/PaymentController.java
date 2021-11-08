package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.models.Payment;
//import com.revature.models.User;
import com.revature.services.ItemService;
import com.revature.services.PaymentService;

public class PaymentController {

	PaymentService ps = new PaymentService();
//	ItemService is = new ItemService();
	
	public void makePayment(Scanner sc, int userid) {

		ItemService is = new ItemService();
		System.out.println("Please enter the item number");		
		String number1 = sc.nextLine();
		int number = Integer.parseInt(number1);
		if(number1.trim().length() < 1 || number <=0) {
			return;
		}
		
		Payment pay = ps.getPaymentbyItemId(number);
		if (pay == null) {
			if (is.getById(number).isOwned()) {
				pay = ps.createNewPayment(number, userid);
			} else {
				System.out.println("Your bid on that item has not been accepted");
				return;
			}
		}
		Item itm = is.getById(pay.getItemId());
		System.out.println("The total price is: " + itm.getPrice() + " and the remaining balance is: " + pay.getRemainingBalance());
		System.out.println("Please enter the amount of the payment");
		String num1 = sc.nextLine();
		int num = Integer.parseInt(num1);
		if(num1.trim().length() < 1 || num <=0) {
			System.out.println("Enter a positive amount next time. ");
			return;
		}

		ps.updateBalance(pay, num);
		
		
	}

	public void viewAllPayments() {
		
		List<Payment> pmts =  ps.viewItems();
		
		for (Payment i : pmts) {
				System.out.println(i);
		}
		if (pmts == null) {
			System.out.println("There are no payments at this time");
		}
	}
	
}
