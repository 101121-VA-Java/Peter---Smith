package com.revature.models;

public class Pillow {

	private int id;
	private Size size;  //using enums
	private Density density;
	private double price;
	
	public Pillow() {
		super();
		
	}

	public Pillow(int id, Size size, Density density, double price) {
		super();
		this.id = id;
		this.size = size;
		this.density = density;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pillow [id=" + id + ", size=" + size + ", density=" + density + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Density getDensity() {
		return density;
	}

	public void setDensity(Density density) {
		this.density = density;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}

