package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
//import org.hibernate.sql.ast.tree.predicate.Predicate;

import com.revature.models.Employee;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

public class EmployeeHibernate implements EmployeeDAO {

	public Employee insertEmployee(Employee em) {
		
		//em.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int)s.save(em);
			//String username = (String)s.save("username", em);
			
			
		
			
			em.setId(id);
			//em.setUsername(username);
			tx.commit();	
		} catch(ConstraintViolationException e) {
	
			
		}
		return em;
	}

	public Employee getEmployeeById(int id) {
		Employee em = null;
		
		
		try (Session s  = HibernateUtil.getSessionFactory().openSession();){ // putting in try block it close automatically once created. no need to s.close();
			em= s.get(Employee.class, id); // instead codes from jdbc we used getmethod to retrieve user by id
			
		}
		
		return em;
	}
	
	public Employee getEmployeeByUsername(String username) {
		Employee em = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
	
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		
			Root<Employee> root = cq.from(Employee.class);
			
		
			Predicate predicateForUsername = cb.equal(root.get("username"), username);

			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			em = (Employee) s.createQuery(cq).getSingleResult();
		}
		
		return em;
		
	}



	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			employees = s.createQuery("from Employee",Employee.class).list();
			
			
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByPassword(String password) {
		
		
	Employee em = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
	
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

			Root<Employee> root = cq.from(Employee.class);
			
		
			Predicate predicateForUsername = cb.equal(root.get("password"), password);

			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			em = (Employee) s.createQuery(cq).getSingleResult();
		}
		
		return em;
		
	}
	
	public Employee updateEmployee(Employee em) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			
			Transaction tx = s.beginTransaction();
			s.update("Employee", em);
			tx.commit();
			
			
		}
		return em;
		
	}



}
