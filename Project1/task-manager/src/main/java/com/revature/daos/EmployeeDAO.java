package com.revature.daos;


import java.util.List;
import com.revature.models.Employee;


public interface EmployeeDAO {
	
	Employee insertEmployee(Employee em);
	Employee getEmployeeById(int id);
	Employee getEmployeeByUsername(String username);
	//Employee getEmployeeByPassword (String password);
	Employee updateEmployee(Employee em);
	

	
	List<Employee> getEmployees();

	

}
