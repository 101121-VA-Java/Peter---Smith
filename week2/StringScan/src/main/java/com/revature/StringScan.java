package com.revature;

public class StringScan{

	public static void main(String[] args) {
		
		String s = "Hello"; // literal
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		System.out.println("Is s == to s1? " + (s == s1) ); // true
		System.out.println("Is s == to s2? " + (s == s2) ); // false
		System.out.println("Is s .equals to s2? " + s.equals(s2));
		
		s2 = s2.intern();
		System.out.println("Once interned, is s == to s2? " + (s == s2) ); // false
		
		System.out.println();
		
		/*
		 * Comparing objects in Java:
		 * 		- == vs .equals
		 * 			- == compares the value in the Stack, used for primitives
		 * 				- if used on reference types, compare the memory address
		 * 			- .equals (if implemented properly) compares the value of the objects as defined in the class
		 * 				- default implementation in the Object class is ==
		 * 					- need to override based on Class fields
		 */
		
		
		Object a = new Object();
		Object b = new Object();
		
		System.out.println("Is object a == b? " + (a == b));
		System.out.println("Is object a .equals b? " + a.equals(b));
		
		/*
		 * String methods to be play around with:
		 * 		- substring
		 * 		- replace
		 * 		- chartAt
		 * 		- ...
		 */
		
		StringBuilder sb = new StringBuilder("Hello world!");
		
		System.out.println(sb.reverse());
		
		//generally use string builder
		StringBuffer sbuff = new StringBuffer("Hello");
		
		StringScan sd = new StringScan();
		
		System.out.println(sd.removeEveryOtherLetter("Hello World"));
		
		System.out.println(sd.getControllerValue("localhost:3500/controller/resource"));
	}
	
	/*
	 * Using StringBuilder and its associated methods (if needed), 
	 * create a method that removes every other letter of a String passed in 
	 * and return that newly created string.
	 */
	public String removeEveryOtherLetter(String s) {
			StringBuilder newS = new StringBuilder();
			for (int i = 0; i < s.length(); i +=2) {
				newS.append(s.charAt(i));
				
			}
// in theory this should work, but above way is better  			
//			StringBuilder newS = new StringBuilder(s);
//			for (int i = 1; i < s.length()/2; i ++) {
//				newS.deleteCharAt(i);
				
//			}
	
		return newS.toString();	
		}		


	/*
	 * Given the string of a url of the format localhost:3500/[controller]/[resource]
	 * where "localhost:3500" is a constant
	 * controller and resource can be any 1 word
	 * return the value of controller as a string
	 */
	public String getControllerValue(String url) {
	//	StringBuilder newS = new StringBuilder();
		int beg = url.indexOf('/');	
		int end = url.indexOf('/', beg + 1);
		String r = url.substring(beg + 1, end);
				
		return r;
	}

}
