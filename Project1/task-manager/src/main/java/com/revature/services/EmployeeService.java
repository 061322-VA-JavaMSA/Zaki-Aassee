package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeHibernate;

import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {
	public EmployeeDAO ed = new EmployeeHibernate();
	
	public Employee createEmployee(Employee em ) throws UserNotCreatedException{
		em.setRole(Role.BASIC_USER);
		em.setFirstname("John"); // by defult the firstname will be John , though we set another one in the request time. Harded coded here
		
		Employee createdEmployee = ed.insertEmployee(em);
		
//		if (createdEmployee.getId() == -1) {
//			throw new UserNotCreatedException();
//			
//		}
			
		//return ed.insertEmployee(em);
		return createdEmployee;
		
	}
	
	public Employee getEmployeeById(int id) throws UserNotFoundException {
		Employee em = ed.getEmployeeById(id);
		
		if (em == null) {
			throw new UserNotFoundException();
			
		}
		return em;
		
	}
	public List<Employee> getEmployees(){
		List<Employee> em = ed.getEmployees();
		
		return em;
		
	}
	public Employee updateEmployee (Employee em) throws UserNotFoundException{
		Employee updated = ed.updateEmployee(em);
		
		return updated;
		
	}
	
	public Employee getEmployeeByUsername (String username) {
		
		Employee em = ed.getEmployeeByUsername(username);
		
		return em;
		
		
	}
}
