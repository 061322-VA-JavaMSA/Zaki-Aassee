package com.revature.services;

import com.revature.daos.EmployeePostgres;
import com.revature.daos.ManagerDAO;
import com.revature.daos.ManagerPostgres;
import com.revature.models.Employee;
import com.revature.models.Manager;

public class ManagerService {
	
	ManagerDAO mDao = new ManagerPostgres();

	

	
	public Manager fireEmoloyee (String username) {
		
		
		
		return mDao.fireEmployeeByUsername(username);
		
	}
	

	

}
