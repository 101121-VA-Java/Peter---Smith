package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		return x + y;
	}
	
	public double subtract(double x, double y) {
		return x - y;
	}
	
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public double divide(double x, double y) {
		if (y == 0) {
			throw new CalculatorException(); 
		}
		
		return x / y;
	}
	
	public boolean isPrime(int i) {
		
		if (i <=1) {
			return false;
		}
		
		for (int j = 2; j < i/2; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		
		
		return true;
	}
}
