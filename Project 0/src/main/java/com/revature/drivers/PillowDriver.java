package com.revature.drivers;

import java.util.List;

import com.revature.controllers.FrontController;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;
import com.revature.services.EmployeeService;

public class PillowDriver {

	public static void main(String[] args) {
		// temp code to set up employees.  all this will be replaced when we have a database to work with
		EmployeeService es2 = new EmployeeService();
		EmployeeDao ed = new EmployeeList();
		
		Employee EnrollmentAdmin = new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN,
				null);
		employees.add(EnrollmentAdmin);
		
		Employee newEmp = new Employee(7, "Peter Smith", "peterSmith", "pbs67", Role.ADMIN, null);
		newEmp = ed.add(newEmp);
		Employee newEmp2 = new Employee(2, "Frank Smith", "FSmith", "12345", Role.MANAGER, newEmp);
		newEmp2 = ed.add(newEmp2);
		Employee newEmp3 = new Employee(3, "Abba Jones", "AJ567", "87rty", Role.MANAGER, newEmp);
		newEmp3 = ed.add(newEmp3);
		Employee newEmp4 = new Employee(4, "Employee A", "EA789", "EA789", Role.BASIC_USER, newEmp2);
		newEmp4 = ed.add(newEmp4);
		Employee newEmp5 = new Employee(5, "Employee B", "EMPB", "EMPB", Role.BASIC_USER, newEmp2);
		newEmp5 = ed.add(newEmp5);
		Employee newEmp6 = new Employee(6, "Employee C", "EMPC", "EMPC", Role.BASIC_USER, newEmp3);
		newEmp6 = ed.add(newEmp6);
		Employee newEmp1 = new Employee(1, "Employee D", "EMPD", "EMPD", Role.BASIC_USER, newEmp3);
		newEmp1 = ed.add(newEmp1);
		
		List<Employee> managers = es2.getAllStaff();
		for(Employee e : managers) {
			System.out.println("Name: " + e.getName() + "  " + e.getRole());
			System.out.println();
		}
		
// -----------------------------------------------------------------
		
		FrontController.runMenu();

	}

	

}
