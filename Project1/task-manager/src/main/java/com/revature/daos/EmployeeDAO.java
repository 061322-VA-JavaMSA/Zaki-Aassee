package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;


public interface EmployeeDAO {
	
	Employee insertEmployee(Employee em);
	Employee getEmployeeById(int id);
	Employee getEmployeeByUsername(String username);
	Employee getEmployeeByEmail (String email);
	
	List<Employee> getEmployees();

	

}
