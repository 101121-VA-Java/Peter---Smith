package com.revature.services;


import java.util.List;

import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeList;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {

	private static EmployeeDao ed = new EmployeeList();
	private static EmployeeDao ed2 = new EmployeeList();
	
	public Employee addEmployee(Employee e) {

		Employee newEmp = this.getEmployeeByUsername(e.getUsername());
		if(newEmp != null) {
			return null;
		}
		e.setRole(Role.BASIC_USER);
		e.setManager(ed.getById(0));   // defaulting to employee 0 which is the owner, and has code ADMIN
 
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
			if (e.getRole().equals(Role.MANAGER)) {
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
