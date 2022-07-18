package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeHibernate;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;

public class AuthService {
	private static Logger log = LogManager.getLogger(AuthService.class);
	Logger log1 = LogManager.getLogger(AuthService.class.getName());

	
	
	private EmployeeDAO ed = new EmployeeHibernate();
	
	public Employee login (String username, String password)throws UserNotFoundException, LoginException{
		
		Employee current = ed.getEmployeeByUsername(username);
		
		if (current == null) {
			throw new UserNotFoundException();
		}
		
		if (!current.getPassword().equals(password)) {
			throw new LoginException();
			
		}
		log.info("User Logged in ", current);
		log1.info(current);
		
		return current;
		
	}
	
	
	
	


}
