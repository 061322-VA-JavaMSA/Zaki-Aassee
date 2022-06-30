package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	// the idea of DAO is that is should only hanld data access logic, 
	// persistence to users/employees like create, update , delete
	Employee createEmployee(Employee employee);
	Employee retrieveEmployeeById(int id);
	List<Employee> retrieveEmployee();
	Employee retrieveEmployeeByUsername(String username);
	Employee retrieveEmployeeByPassword(String password);
	Employee deleteEmployeeByUsername(String username);
	

	
	
	
	
	

}
