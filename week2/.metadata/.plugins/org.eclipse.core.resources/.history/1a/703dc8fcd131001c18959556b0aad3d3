package com.revature.models;

import java.time.LocalDate;

public class OopEx {
	
	// Instance variables
	private String name;
	
	LocalDate dueDate;
	
	public OopEx(String name, LocalDate dueDate) {
		super();
		this.name = name;
		this.dueDate = dueDate;
	}

	public OopEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OopEx [name=" + name + ", dueDate=" + dueDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OopEx other = (OopEx) obj;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}


