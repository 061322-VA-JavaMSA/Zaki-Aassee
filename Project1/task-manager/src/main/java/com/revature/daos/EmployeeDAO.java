package com.revature.daos;


import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Role;


public interface EmployeeDAO {
	
	Employee insertEmployee(Employee em);
	Employee getEmployeeById(int id);
	Employee getEmployeeByUsername(String username);
	//Employee getEmployeeByPassword (String password);
	Employee updateEmployee(Employee em);
	Role role (Role r);
	
	

	
	List<Employee> getEmployees();

	

}
