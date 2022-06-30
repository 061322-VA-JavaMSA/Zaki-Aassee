package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionHandler;

public class EmployeePostgres implements EmployeeDAO {
	
	@Override
	public Employee createEmployee(Employee employee) {
		String sql = "insert into employees (employee_id, employee_name, employee_username, employee_password, assigned_category, employee_role) values (?,?,?,?,?,?) returning employee_id;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getEmployeName());
			ps.setString(3, employee.getEmployeeUsername());
			ps.setString(4, employee.getEmployeePassword());
			ps.setString(5, employee.getEmployeeAssignedCategory());
			ps.setString(6, employee.getEmployeeRole());
			ResultSet rs = ps.executeQuery(); // id generated by the database ;

			
		}
		catch (SQLException e) {
			System.out.println("SQL Error: " + e);
			
		}
		return employee;
	}

	@Override
	public Employee retrieveEmployeeById(int id) {

		return null;
	}

	@Override
	public List<Employee> retrieveEmployee() {
		
		String sql = "select * from employees where employee_username =?;";
		List<Employee> employees = new ArrayList<>();
		try(Connection c = ConnectionHandler.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
	
			//Statement s = c.createStatement();
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("employee_id"));
				em.setEmployeName(rs.getString("employee_name"));
				em.setEmployeeUsername(rs.getString("employee_username"));
				em.setEmployeePassword(rs.getString("employee_password"));
				em.setEmployeeAssignedCategory(rs.getString("assigned_category"));
				em.setEmployeeRole(rs.getString("employee_role"));
				
				employees.add(em);
				
			}
		}
		catch (SQLException e ) {
			e.printStackTrace();
			System.out.println("bye");
		}
		
		return employees;
	}

	@Override
	public Employee retrieveEmployeeByUsername(String username) {
		Employee employee = new Employee();
		//String sql = "select * from employees where employee_username = 'cpool4';";
		String sql1 = "select * from employees where employee_username = ?;"; // using prepared statement , to avoid SQL
																				// injection
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql1);
			ps.setString(1, username);
			//ps.setString(2, "password");
			//ps.setString(2, "password"); // referes to the second ? mark in sql statement 

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee.setId(rs.getInt("employee_id"));
				employee.setEmployeName(rs.getString("employee_name"));
				employee.setEmployeeUsername(rs.getString("employee_username"));
				employee.setEmployeeAssignedCategory(rs.getString("assigned_category"));
				//employee.setItemCategory(rs.getString("assigned_category"));
				employee.setEmployeeRole(rs.getString("employee_role"));
				employee.setEmployeePassword(rs.getString("employee_password"));
			}

		}

		catch (SQLException e) {
			System.out.println("exception!");
	e.printStackTrace();

		}

		return employee;
	}
	
//	@Override
//	public Employee retrieveEmployeeByPassword(String password) {
//		//String sql = "select * from employees where employee_username = 'cpool4';";
//		String sql1 = "select * from employees where employee_password = ?;"; // using prepared statement , to avoid SQL
//																				// injection
//		Employee employee = null;
//
//		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
//			PreparedStatement ps = c.prepareStatement(sql1);
//			ps.setString(1, "password");
//			//ps.setString(2, "password");n // referes to the second ? mark in sql statement 
//
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				employee.setId(rs.getInt("employee_id"));
//				employee.setEmployeName(rs.getString("employee_name"));
//				employee.setEmployeeUsername(rs.getString("employee_username"));
//				employee.setEmployeeAssignedCategory(rs.getString("assigned_category"));
//				//employee.setItemCategory(rs.getString("assigned_category"));
//				employee.setEmployeeRole(rs.getString("employee_role"));
//				employee.setEmployeePassword(rs.getString("employee_password"));
//
//			}
//
//		}
//
//		catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//
//		return employee;
//	}

	@Override
	public Employee deleteEmployeeByUsername(String username) {
	
		String sql = "delete from employees where employee_username = ? returning employee_id;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
		}
		catch (SQLException e) {
			System.out.println("Database Exception "+ e);
		}
		return null;
	}

	@Override
	public Employee retrieveEmployeeByPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
