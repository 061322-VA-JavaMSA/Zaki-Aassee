package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	// the idea of DAO is that is should only hanld data access logic, 
	// persistence to users/employees like add, update , delete
	Employee createEmployee(Employee E);
	Employee retrieveEmployeeById(int id);
	List<Employee> retrieverEmployee();
	Employee retrieveEmployeeByUsername(String username);
	boolean updateEmployee(Employee E);
	boolean deleteEmployee(int id);
	
	

}
