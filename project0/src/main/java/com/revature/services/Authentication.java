package com.revature.services;

import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.ManagerDAO;
import com.revature.daos.ManagerPostgres;
import com.revature.models.Customer; 
import com.revature.models.Employee;
import com.revature.models.Manager;

public class Authentication {
	
	
	private EmployeeDAO employeeDao = new EmployeePostgres();
	private CustomerDAO customerDao = new CustomerPostgres();
	private ManagerDAO managerDao = new ManagerPostgres();
	
	private static Logger log = LogManager.getLogger(Authentication.class);
	
	
	
	public Employee login(String username, String password) throws Exception { 
 
		if (username == null || password == null) {
			System.out.println("your input is null");

		}
		

		Employee employee = employeeDao.retrieveEmployeeByUsername(username);
	
		if (employee == null || !employee.getEmployeePassword().equals(password) && (employee.getEmployeePassword()==null)) { 
																																														
			System.out.println("your input is wrong");
			throw new Exception("Wrong inputs");

		}
		return employee;
	}

	public Customer userLogin(String username, String password) throws Exception {

		if (username == null || password == null) {
			System.out.println("you input is null");

		}
		Customer customer = customerDao.retrieveCustomerByUsername(username);

		if (customer == null || !customer.getUserPassword().equals(password)) {
			throw new Exception("Wrong inputs");

		}

		return customer;

	}

	public Manager managerLogin(String username, String password) throws LoginException {

		if (username == null || password == null) {
			System.out.println("input is null");
		}
		Manager manager = managerDao.retrieveManagerByUsername(username);

		if (manager == null || !manager.getMgrPassword().equals(password)) {
			//System.out.println("");
			throw new LoginException("Wrong Inputs");
			

		}
		

		return manager;
	}

}
