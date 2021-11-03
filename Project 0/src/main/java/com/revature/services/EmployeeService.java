package com.revature.services;


import java.util.List;

import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {

	private static EmployeeDao ed = new EmployeeList();
	private static EmployeeDao ed2 = new EmployeeList();

	// temp code to set up employees.  all this will be replaced when we have a database to work with
//	public static void setUp() {

//		
//		EmployeeService es2 = new EmployeeService();
////		EmployeeDao ed = new EmployeeList();
////		
//		Employee newEmp0 = new Employee(7, "Peter Smith", "peterSmith", "pbs67", Role.ADMIN, null);
//		ed.add(newEmp0);
//		Employee newEmp2 = new Employee(2, "Frank Smith", "FSmith", "12345", Role.MANAGER, newEmp0);
//		ed.add(newEmp2);
//		Employee newEmp3 = new Employee(3, "Abba Jones", "AJ567", "87rty", Role.MANAGER, newEmp0);
//		ed.add(newEmp3);
//		Employee newEmp4 = new Employee(4, "Employee A", "EA789", "EA789", Role.BASIC_USER, newEmp2);
//		ed.add(newEmp4);
//		Employee newEmp5 = new Employee(5, "Employee B", "EMPB", "EMPB", Role.BASIC_USER, newEmp2);
//		ed.add(newEmp5);
//		Employee newEmp6 = new Employee(6, "Employee C", "EMPC", "EMPC", Role.BASIC_USER, newEmp3);
//		ed.add(newEmp6);
//		Employee newEmp1 = new Employee(1, "Employee D", "EMPD", "EMPD", Role.BASIC_USER, newEmp3);
//		ed.add(newEmp1);
//		
//		List<Employee> managers = es2.getAllStaff();
//		for(Employee em : managers) {
//			System.out.println("Name: " + em.getName() + "  " + em.getRole());
//			System.out.println();
//		}
//		return; 	
//	}	
//// ----------------------------------------------------------------- End of temp code
		
	
	
	
	public Employee addEmployee(Employee e) {

		Employee newEmp = this.getEmployeeByUsername(e.getUsername());
		if(newEmp != null) {
			return null;
		}
		e.setRole(Role.BASIC_USER);
		e.setManager(ed.getById(0));   // defaulting to employee 0 which is ADMIN
 
		return ed.add(e);
	}
	
	public Employee getEmployeeByUsername(String username){
		List<Employee> employees = ed.getAll();
		for(Employee e : employees) {
			if (e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
	
	public List<Employee> getAllManagers(){
		List<Employee> managers = null;
		List<Employee> employees = getAllStaff();
		for(Employee e : employees) {
			System.out.println(e.getName() + "     -   " + e.getRole());          //  TODO remove.  for testing
			System.out.println(e.getRole() == Role.MANAGER);
			System.out.println(e.getRole().equals(Role.MANAGER));
			if (e.getRole() == Role.MANAGER) {
				System.out.println(e.getName());          //  TODO remove.  for testing
				managers = ed2.addList(e);
			}
		}
		return managers;
	}	
	
	public List<Employee> getEmployeesByManager(int id){
		List<Employee> employeeList = null;
		List<Employee> employees = getAllStaff();
		for(Employee e : employees) {
			if (e.getRole().equals(Role.BASIC_USER) && e.getManager().getId() == id) {
				employeeList = ed2.addList(e);
			}
		}
		return employeeList;
	}	
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeeList = null;
		List<Employee> employees = getAllStaff();
		for(Employee e : employees) {
			if (e.getRole().equals(Role.BASIC_USER)) {
				employeeList = ed2.addList(e);
			}
		}
		return employeeList;
	}	
	
	public List<Employee> getAllStaff(){
		List<Employee> employees = ed.getAll();
		return employees;
	}	
	
	public List<Employee> getEmployeesAndManagers(){

		List<Employee> employees = getAllManagers();
		employees.addAll(getAllEmployees());
		return employees;
	}	
	
	public Employee login(String username, String password) {
		Employee emp = this.getEmployeeByUsername(username);
		if(emp == null || !emp.getPassword().equals(password)) {
			return null;
		}
		return emp;
	}

	
}
