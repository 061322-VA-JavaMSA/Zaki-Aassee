package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;


public interface CustomerDAO {
	
	Customer createCustomer(Customer customer);
	List<Customer> retrieveCustomer();
	boolean deleteCustomer(String username);
	Customer retrieveCustomerByUsername(String username);


	
	
	

}
