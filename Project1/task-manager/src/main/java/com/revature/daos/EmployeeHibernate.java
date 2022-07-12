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
		
		em.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(em);
			em.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			// log the errors
			
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
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			// define entity to be searched
			Root<Employee> root = cq.from(Employee.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"), username);
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateFromUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse);
			
			cq.select(root).where(predicateForUsername);
			
			// retrieves the result
			em = (Employee) s.createQuery(cq).getSingleResult();
		}
		
		return em;
		
	}

	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			employees = s.createQuery("from Employee",Employee.class).list();
			
			
		}
		return employees;
	}

}
