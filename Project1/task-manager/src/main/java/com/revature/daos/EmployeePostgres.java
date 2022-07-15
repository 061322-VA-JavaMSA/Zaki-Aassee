package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class EmployeePostgres implements EmployeeDAO {

	@Override
	public Employee insertEmployee(Employee em) {

		String sql = "insert into ers_employee (ers_user_id, ers_username, ers_password, ers_role) values (?,?,?,?) returning ers_user_id;";
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, em.getId());
			ps.setString(2, em.getUsername());
			ps.setString(3, em.getPassword());
			ps.setString(4, em.getRole().toString());
			
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				em.setId(rs.getInt("ers_user_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// orm , object relational mapping , connection betw different types of parts
		
		return em;		
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from ers_employee where ers_user_id= ?;";
		Employee em =null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				em = new Employee();
				em.setId(rs.getInt("ers_user_id"));
				em.setUsername(rs.getString("ers_username"));
				em.setPassword(rs.getString("ers_password"));
				em.setRole(Role.valueOf(rs.getString("user_role")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}
	@Override
	public Employee getEmployeeByUsername(String username) {
		String sql = "select * from ers_employee where ers_username  = ?;";
		Employee em = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				em = new Employee();
				em.setId(rs.getInt("ers_user_id"));
				em.setUsername(rs.getString("ers_username"));
				em.setPassword(rs.getString("ers_password"));
				em.setRole(Role.valueOf(rs.getString("user_role")));
				em.setFirstname(rs.getString("user_firstname"));
				em.setLastname(rs.getString("user_lastname"));
				
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return em;
	}


	@Override
	public List<Employee> getEmployees() {
	
		String sql = "select * from ers_employee;";
		List<Employee> employees = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnectionFromEnv()){
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("ers_user_id"));
				em.setUsername(rs.getString("ers_username"));
				em.setPassword(rs.getString("ers_password"));
				em.setRole(Role.valueOf(rs.getString("ers_role")));
				
				employees.add(em);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	

	}

	@Override
	public Employee getEmployeeByPassword(String password) {
		String sql = "select * from ers_employee where ers_password = ?;";
		Employee em = null;
		
		try (Connection c = ConnectionUtil.getConnectionFromEnv();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, password); 

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				em = new Employee();
				em.setId(rs.getInt("ers_user_id"));
				em.setUsername(rs.getString("ers_username"));
				em.setPassword(rs.getString("ers_password"));
				em.setRole(Role.valueOf(rs.getString("user_role")));
				em.setFirstname(rs.getString("user_firstname"));
				em.setLastname(rs.getString("user_lastname"));
				
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return em;

	
	}

	@Override
	public Employee updateEmployee(Employee em) {
		// TODO Auto-generated method stub
		return null;
	}
}

	


