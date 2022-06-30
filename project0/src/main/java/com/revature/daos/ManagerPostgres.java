package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.util.ConnectionHandler;

public class ManagerPostgres implements ManagerDAO {

	

	@Override
	public Manager fireEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager retrieveItemByCategory(String itemCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createEmployee(Employee em) {
		
//	String sql = "insert into employees (employee_id, employee_name, employee_username, employee_password, assigned_category, employee_role) values (?,?,?,?,?,?);";
//		
//		try (Connection c = ConnectionHandler.getConnectionFromEnv();){
//			
//			PreparedStatement ps = c.prepareStatement(sql);
//			ps.setInt(1, em.getId());
//			ps.setString(2, em.getEmployeName());
//			ps.setString(3, em.getEmployeeUsername());
//			ps.setString(4, em.getEmployeePassword());
//			ps.setString(5, em.getEmployeeAssignedCategory());
//			ps.setString(6, em.getEmployeeRole());
//				
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				em.setId(rs.getInt("employee_id"));
//				em.setEmployeName(rs.getString("employee_name"));
//				em.setEmployeeUsername(rs.getString("employee_username"));
//				em.setEmployeePassword(rs.getString("employee_password"));
//				em.setEmployeeAssignedCategory(rs.getString("assigned_category"));
//				em.setEmployeeRole(rs.getString("employee_role"));
//				
//				
//			
//				
//			}
//		}
//		catch (SQLException e) {
//			System.out.println("Database error");
//		}	
		return null;
	}

	@Override
	public Manager retrieveManagerByUsername(String username) {
		Manager mgr = new Manager();
		String sql = "select * from manager where admin_username = ?;";
		
		try (Connection c = ConnectionHandler.getConnectionFromEnv();){
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
		
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			mgr.setMgrId(rs.getInt("admin_id"));
			mgr.setMgrName(rs.getString("admin_name"));
			mgr.setMgrUsername(rs.getString("admin_username"));
			mgr.setMgrPassword(rs.getString("admin_password"));
			}
		}
		catch (SQLException e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
		
		return mgr;
		
	}

	@Override
	public Manager retrieveManagerByPassword(String password) {
	
		return null;
	}



}
