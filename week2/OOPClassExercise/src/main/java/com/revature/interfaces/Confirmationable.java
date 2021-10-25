package com.revature.interfaces;   //  Interface to show Abstraction

public interface Confirmationable {

	default void sendConfirmationEmail() {
		System.out.println("Confirmation email sent to customer");
	}
	
}
