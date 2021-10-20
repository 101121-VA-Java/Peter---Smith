package com.revature.models;

import java.time.LocalDate;

public class ImportantTask extends Task{

	public ImportantTask() {
		super();
		LocalDate.now();
	}	

	public ImportantTask(String name, LocalDate dueDate) {
	super(name, dueDate);
	// TODO Auto-generated constructor stub
	}

	public void stress() {
		this.setDueDate(this.getDueDate().minusDays(1));
	}


}