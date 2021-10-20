package com.revature.driver;

import java.time.LocalDate;

import com.revature.models.OopEx;

public class OopExDriver {
	public static void main(String[] args) {
	
		OopEx student1 = new OopEx();
		OopEx student2 = new OopEx("Ralph",LocalDate.now());
		
		System.out.println("Student1 toString: " + student1.toString());
		System.out.println("Student1 name: " +student1.getName());
		
		student1.setName("Slim");
		System.out.println("Student1 toString: " +student1.toString());
		student1.setDueDate(LocalDate.of(2021, 10, 25));
		System.out.println("Student1 toString with date: " +student1.toString());
		
		System.out.println("Student2 toString: " +student2.toString());
			
		System.out.println("Student1 name getter: " + student1.getName());
		System.out.println("Student2 name getter: " + student2.getName());
		
		System.out.println("Student1 date getter: " + student1.getDueDate());
		System.out.println("Student2 date getter: " + student2.getDueDate());
		
		System.out.println();
		String q = student1.getName();
		System.out.println("does student1.getname .equals harcoded Slim? " + q.equals("Slim"));
	}
}



