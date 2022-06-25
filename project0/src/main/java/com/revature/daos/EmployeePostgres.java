package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionHandler;

public class EmployeePostgres implements EmployeeDAO {

	@Override
	public Employee createEmployee(Employee E) {

		return null;
	}

	@Override
	public Employee retrieveEmployeeById(int id) {

		return null;
	}

	@Override
	public List<Employee> retrieverEmployee() {

		return null;
	}

	@Override
	public Employee retrieveEmployeeByUsername(String username) {
		String sql = "select * from employees where employee_username = 'cpool4';";
		String sql1 = "select * form employees where employee_username = ?;"; // using prepared statement , to avoid SQL
																				// injection
		Employee em = null;

		try (Connection c = ConnectionHandler.getConnectionFromFile();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "username");
			ps.setString(2, "password");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				em.setId(rs.getInt("employee_id"));
				em.setEmployeName(rs.getString("employee_name"));
				em.setEmployeeUsername(rs.getString("employee_username"));
				em.setEmployeeAssignedCategory(rs.getString("assigned_category"));
				em.setEmployeeRole(rs.getString("employee_role"));
				em.setEmployeePassword(rs.getString("employee_password"));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return em;
	}

	@Override
	public boolean updateEmployee(Employee E) {

		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {

		return false;
	}

}
