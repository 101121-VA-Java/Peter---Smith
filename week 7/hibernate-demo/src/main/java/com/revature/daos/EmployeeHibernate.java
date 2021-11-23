package com.revature.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDao{

	public Employee add(Employee d) {
		// In hibernate, the session represents the connection to the database
		Session s = HibernateUtil.getSessionFactory().openSession();
		// starts the transaction
		Transaction tx = s.beginTransaction();
		/*
		 * saves object to database The id of the object saved has been updated to the
		 * generated value from database
		 */
		// id is generated id
		// takes transient department and makes persisted
		int id = (int) s.save(d);
		// commits the transaction
		tx.commit();
		// close the session
		// d is now detached because the session has been closed
		s.close();

		return d;
	}

	public Employee getById(int id) {
		Employee d = null;
				
		//HQL
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			// instead of working with table name/column name, work with class and fields
			String hql = "from Employee where id = :employee_id";
			TypedQuery<Employee> tq = s.createQuery(hql, Employee.class);
			tq.setParameter("employee_id", id);
			d = tq.getSingleResult();
		}
		return d;
	}
	
	public Employee getByName(String name) {
		Employee d = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			// define entity to be searched
			Root<Employee> root = cq.from(Employee.class);
			
			// defining "where name = ... && condition"
			Predicate predicateForName = cb.equal(root.get("name"), name);
//			Predicate predicateForSomethingElse = cb.equal(root.get("id"), passedInId);
//			Predicate predicateForNameAndSomethingElse = cb.and(predicateForName, predicateForSomethingElse);
			
			// cq.select(root).where(predicateForNameAndSomethingElse);
			cq.select(root).where(predicateForName);
			
			// retrieving the result
			d = (Employee) s.createQuery(cq).getSingleResult();
		}
		return d;
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = null;
				
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			employees = s.createNamedQuery("getAllNq", Employee.class).getResultList();
		}
		return employees;
	}
	
	/**
	 * Retrieves employees by department id from the database
	 * @return a List of Employee objects
	 */
	@Override
	public List<Employee> getEmployeesByDepartmentId(int deptId) {
//		List<Employee> employees = null;
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//			CriteriaBuilder cd = s.getCriteriaBuilder();
//			CriteriaQuery<Employee> cq = cd.createQuery(Employee.class);
//			Root<Employee> root = cq.from(Employee.class);
//			Predicate predicateForDepartmentId = cd.equal(root.get("d_Id"), deptId);
//			cq.select(root).where(predicateForDepartmentId);
//			employees = s.createNamedQuery("getEmpsbyDIdNq", Employee.class).getResultList();
//		}
//		return employees;
	
		
		
		List<Employee> employees = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			Predicate predicateForDeptId = cb.equal(root.get("department"), deptId);
			cq.select(root).where(predicateForDeptId);
			employees = (List<Employee>) s.createQuery(cq).getResultList();
		}
		return employees;

		
		
		
	}

	public void update(Employee d) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.update(d);
			tx.commit();
		}

	}

	public void delete(Employee d) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(d);
			tx.commit();
		}

	}
	
}
