package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeList implements EmployeeDao {

	private List<Employee> employees;

	public EmployeeList() {
		employees = new ArrayList<>();
		// System defined EnrollmentAdmin User added to the employees list to be used as
		// default admin for all new user
		Employee EnrollmentAdmin = new Employee(0, "Enrollment Admin", "Enrollment Admin", "AdminPass", Role.ADMIN,
				null);
		employees.add(EnrollmentAdmin);
	}

	@Override
	public Employee add(Employee t) {
		// generating a new id for new employees
//		t.setId(employees.size());                          TODO add logic to get new id
		// add method returns true if adding to a collection was successful
		employees.add(t);
		// TODO add check that add was successful
		return t;

	}

	@Override
	public Employee getById(int id) {
		// Iterate to see if employees contain the id
		for (Employee e : employees) {
			// returns the employee if found
			if (e.getId() == id) {
				return e;
			}
		}
		// returns null otherwise
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return employees;
	}

	@Override
	public boolean update(Employee t) {
		Employee temp = getById(t.getId());
		if (temp == null || temp.equals(t)) {
			return false;
		}
//		employees.set(t.getId(), t);   this is array list
		//TODO add logic
		return true;
	}

	@Override
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> addList(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}
}
