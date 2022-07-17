package com.revature.services;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeHibernate;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;

public class AuthService {
	
	private EmployeeDAO ed = new EmployeeHibernate();
	
	public Employee login (String username, String password)throws UserNotFoundException, LoginException{
		
		Employee current = ed.getEmployeeByUsername(username);
		
		if (current == null) {
			throw new UserNotFoundException();
		}
		
		if (!current.getPassword().equals(password)) {
			throw new LoginException();
			
		}
		
		return current;
		
	}
	
	
	
	


}
