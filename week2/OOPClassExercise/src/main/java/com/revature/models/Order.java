package com.revature.models;

import java.time.LocalDate;

import com.revature.exceptions.ThirtyThreeException;

import com.revature.interfaces.Confirmationable;

public abstract class Order implements Confirmationable{  // abstract class to show Abstaction

	protected int orderNumber;        //Access modifier Protected to show encapsulation
	protected LocalDate orderDate;
	protected LocalDate shipDate;
	
	private Pillow pillow;
	
	public Order(){
		super();		// super shows Inheritance form Object class
	}
	
	public Order(int orderNumber, LocalDate orderDate, LocalDate shipDate) {
		super();			// super shows Inheritance form Object class
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
	}
	
//  Overriding auto generated for Polymorphism
	@Override
	public void sendConfirmationEmail() {
		// TODO Auto-generated method stub
		Confirmationable.super.sendConfirmationEmail();
	}

	
	//  Getters and setters auto generated for Encapsulation
		
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		if (this.orderNumber <= 0) {
			throw new ThirtyThreeException();
		}
		this.orderNumber = orderNumber;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getShipDate() {
		return shipDate;
	}
	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
	}
	public Pillow getPillow() {
		return pillow;
	}

	public void setPillow(Pillow pillow) {
		this.pillow = pillow;
	}
	
	
	
	//   Overriding auto generated for Polymorphism
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderNumber;
		result = prime * result + ((shipDate == null) ? 0 : shipDate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (shipDate == null) {
			if (other.shipDate != null)
				return false;
		} else if (!shipDate.equals(other.shipDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", shipDate=" + shipDate + "]";
	}

				
}
