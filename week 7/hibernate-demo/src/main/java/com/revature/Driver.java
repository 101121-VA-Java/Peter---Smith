package com.revature;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentHibernate;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeHibernate;
import com.revature.models.Department;
import com.revature.models.Employee;

public class Driver {

	private static DepartmentDao dd = new DepartmentHibernate();
	private static EmployeeDao ed = new EmployeeHibernate();
	
	public static void main(String[] args) {
	
//	// Object state is transient
//	Department newDep = new Department();
//	newDep.setName("FunZone");
//	// Department [id=0, name=FunZone]
//	System.out.println(newDep);
//
//	
//	dd.add(newDep);
//	
//	// printing out a detached instance of our object
//	//Department [id=1, name=FunZone]
//	System.out.println(newDep);
//	
//	Department fromDb = dd.getById(1);
//	
//	System.out.println(fromDb);
//	
//	System.out.println(dd.getDepartments());
//	
//	System.out.println("Criteria result: " + dd.getByName("FunZone"));
//	
//	dd.delete(fromDb);
	
	//-------------- now for some employees
	
	Employee newEmp = new Employee();
	newEmp.setName("Gragg");
	
	System.out.println(newEmp);

	
	System.out.println(ed.add(newEmp));
	
	Employee fromDb = ed.getById(2);
	
	System.out.println(fromDb);
	
	System.out.println(ed.getEmployees());
	
	System.out.println("Criteria result: " + ed.getByName("Gilligan"));
	
	ed.delete(fromDb);
	
	}

}
