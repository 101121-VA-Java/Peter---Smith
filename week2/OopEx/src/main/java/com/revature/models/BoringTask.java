package com.revature.models;
import java.time.LocalDate;
public class BoringTask extends Task{

	public BoringTask() {
		super();
		LocalDate.now();
	}	

	public BoringTask(String name, LocalDate dueDate) {
		super(name, dueDate);
	}

	public void procrastinate() {
		this.setDueDate(this.getDueDate().plusDays(1));
	}
 

}