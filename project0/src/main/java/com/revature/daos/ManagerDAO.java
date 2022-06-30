package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Manager;

public interface ManagerDAO {
	
	Manager fireEmployeeByUsername(String username);
	Manager retrieveItemByCategory (String itemCategory);
	Employee createEmployee (Employee em);
	Manager retrieveManagerByUsername (String username);
	Manager retrieveManagerByPassword (String password);


	
	
	
	

}
