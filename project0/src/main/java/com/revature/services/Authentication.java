package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeePostgres;
import com.revature.exceptions.LoginExceptions;
import com.revature.models.Employee;

public class Authentication {

	private EmployeeDAO employeeDao = new EmployeePostgres();
	
	
	public Employee login(String username, String password) throws LoginExceptions { // as we import class EmployeePostgres
			// checks if username and password are null throw exception 
		if (username == null || password == null) {
			 throw new LoginExceptions();
		}
		Employee employee = employeeDao.retrieveEmployeeByUsername(username);

		
		if (employee == null || !employee.getEmployeePassword().equals(password)) {  // checks if employee/user of that username has not retrieved or if don't match with records, throw exception 
			throw new LoginExceptions();
			
		}
		return employee;
	
	}

}
