package com.revature.services;

import java.util.List;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerPostgres;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class CustomerService {
	private CustomerDAO uDao = new CustomerPostgres();
	
	
	public List<Customer> getCustomer(){
		return uDao.retrieveCustomer();
	} 
	
	public Customer createCustomer (Customer user) {
	
		
		
		return uDao.createCustomer(user);
	}
	
	public Customer getCustomer (String username) {
		return uDao.retrieveCustomerByUsername(username);
		
	}
	

}
