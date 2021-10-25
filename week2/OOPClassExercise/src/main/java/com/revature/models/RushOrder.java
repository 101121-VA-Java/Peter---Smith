package com.revature.models;

import java.time.LocalDate;

public class RushOrder extends Order{   //  Extends Order to show Inheritance

	public RushOrder() {
		super();		// super shows Inheritance form Object class
	}
	
	public RushOrder(int orderNumber, LocalDate orderDate, LocalDate shipDate) {
		super(orderNumber, orderDate, shipDate);
		// TODO Auto-generated constructor stub
	}

	public void rush() {
		this.setShipDate(this.getShipDate().minusDays(1));
	}
	
//   Overload	
	public void rush(int days) {
		this.setShipDate(this.getShipDate().minusDays(days));
	}
	
	
	//    Overrides to show Polymorphism
	
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", rushedShipDate=" + shipDate + "]";
    }
	
	public void setOrderNumber(int orderNumber) {
		if (this.orderNumber <= 0) {
			this.orderNumber = 0;
		} else {
			this.orderNumber = orderNumber;
		}	
	}	
}	
