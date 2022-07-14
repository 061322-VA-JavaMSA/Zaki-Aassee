package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeHibernate;
import com.revature.daos.EmployeePostgres;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {
	public EmployeeDAO ed = new EmployeeHibernate();
	
	public Employee createEmployee(Employee em ) throws UserNotCreatedException{
		em.setRole(Role.BASIC_USER);
		
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
}
