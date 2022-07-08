package com.revaure.daos;

import java.util.List;

import com.revaure.models.Employee;




public interface EmployeeDAO {
	
	Employee insertUser(Employee e);
	Employee getUserById(int id);
	Employee getUserByUsername(String username);
	List<Employee> getUsers();

}
