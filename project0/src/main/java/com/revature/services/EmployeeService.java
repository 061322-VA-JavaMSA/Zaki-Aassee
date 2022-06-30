package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeePostgres;
import com.revature.models.Employee;

public class EmployeeService {
	private EmployeeDAO ed = new EmployeePostgres();
	
	public List<Employee> getEmployee(){
		return ed.retrieveEmployee();
	} 
	
	public Employee createEmployee (Employee e) {
//		 logic to validate employee
//		 if okay 
//		e = ed.createEmployee(e);
//		
		
		return ed.createEmployee(e);
	}
//	public Employee getAdmin (String e) {
//		return ed.retieveAdminByUsername(e);
//		
//	}

	public Employee deleteEmployee (String username) {
		return ed.deleteEmployeeByUsername(username);
	}
	
}

