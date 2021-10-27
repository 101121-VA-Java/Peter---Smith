package com.revature.models;

public class Pillow {

	private int id;
	private Size size;  //using enums
	private Density density;
	private int stockAmount;
	private double pillowCost;
	private double pillowRetail;
	
	public Pillow() {
		super();
		
	}

	public Pillow(int id, Size size, Density density, int stockAmount, double pillowCost, double pillowRetail) {
		super();
		this.id = id;
		this.size = size;
		this.density = density;
		this.stockAmount = stockAmount;
		this.pillowCost = pillowCost;
		this.pillowRetail = pillowRetail;
	}

	@Override
	public String toString() {
		return "Pillow [id=" + id + ", size=" + size + ", density=" + density + ", stockAmount=" + stockAmount
				+ ", pillowCost=" + pillowCost + ", pillowRetail=" + pillowRetail + "]";
	}

	
	
}

