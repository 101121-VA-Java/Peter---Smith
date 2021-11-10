package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.revature.daos.PaymentDao;
import com.revature.models.Payment;
import com.revature.services.PaymentService;

public class PaymentServiceTest {
 
	public static int d;
	public static PaymentService ps = new PaymentService();
	public static PaymentDao pd = new PaymentDao();
	
	 @Test 
	 void getOpenBalancePaymentsByUserId() {
		 	List<Payment> n = ps.getOpenBalancePaymentsByUserId(0);
		 	 assertTrue(n.isEmpty());
	 }      
	        
	 @Test 
	  void getZeroBalancePaymentsByUserId() {
		 List<Payment> n = ps.getZeroBalancePaymentsByUserId(0);
		 assertTrue(n.isEmpty());
	 }
	 

	 @Test 
	  void getPaymentByItemId() {
		 Payment n = ps.getPaymentbyItemId(15);
		 assertAll(() -> assertEquals(1, n.getId()),
        		 () -> assertEquals(15, n.getItemId()),
                 () -> assertEquals(7, n.getUserId()),
            	 () -> assertEquals(655, n.getRemainingBalance())
         );
	 }
	 
	 @Test 
	  void getPaymentById() {
		 Payment n = ps.getPaymentbyId(1);
		 assertAll(() -> assertEquals(1, n.getId()),
       		 () -> assertEquals(15, n.getItemId()),
                () -> assertEquals(7, n.getUserId()),
           	 () -> assertEquals(655, n.getRemainingBalance())
        );
	 }
	 
	 
	 @Test 
	  void getPaymentByItemIdAndUserId() {
		 Payment n = ps.getPaymentByItemIdAndUserId(15, 7);
		 assertAll(() -> assertEquals(1, n.getId()),
      		 () -> assertEquals(15, n.getItemId()),
               () -> assertEquals(7, n.getUserId()),
          	 () -> assertEquals(655, n.getRemainingBalance())
       );
	 }
	 
//	 
//   ugh!  need to list all items	 
//	 @Test 
//	    void viewItems() {
//
//	        List<Payment> n = ps.viewItems();
//	        assertAll(() -> assertEquals(1, n.getId()),
//	        		() -> assertEquals(15, n.getItemId()),
//	        		() -> assertEquals(0, n.getUserId()),
//	        		() -> assertEquals(655, n.getRemainingBalance())
//	         );
//	    }
	 
//	 @Test 
//	  void createNewPayment() {
//		 int n = ps.createNewPayment(5, 0);
//		 assertAll(() -> assertEquals(0, n.getPayment()),
//     		 () -> assertEquals(5, n.getItemId()),
//              () -> assertEquals(0, n.getUserId()),
//         	 () -> assertEquals(98, n.getRemainingBalance())
//      );
//		 d = n.getId();
//	 }
	 
	 @Test 
	  void updateBalance() {
	      Payment p = new Payment(20,1,0,500);
		  assertFalse(ps.updateBalance(p, 300));
	 } 
	 
	 @AfterAll
		public static void tearDown() {
			pd.delete(d);
		}
}
