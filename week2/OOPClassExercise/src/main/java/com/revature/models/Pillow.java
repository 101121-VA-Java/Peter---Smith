package com.revature.models;

import com.revature.exceptions.ThirtyThreeException;

public class Pillow extends Order{   // //  Extends Order to show Inheritance

		
	private String size;
	private String firmness;
	
	public Pillow() {   //  Inheritance from Object class implies Super()
		
	}
	
	public Pillow(String size, String firmness) {
		super();		// super shows Inheritance form Object class
		this.size = size;
		this.firmness = firmness;
	}
	
	
//  Getters and setters auto generated for Encapsulation
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFirmness() {
		return firmness;
	}
	public void setFirmness(String firmness) {
		this.firmness = firmness;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firmness == null) ? 0 : firmness.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pillow other = (Pillow) obj;
		if (firmness == null) {
			if (other.firmness != null)
				return false;
		} else if (!firmness.equals(other.firmness))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pillow [size=" + size + ", firmness=" + firmness + "]";
	}
	
	
	
}	