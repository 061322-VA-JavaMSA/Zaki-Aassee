package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;
import com.revature.util.ConnectionHandler;

public class CustomerPostgres implements CustomerDAO {
	private Logger log = LogManager.getLogger(CustomerPostgres.class);

	@Override
	public Customer createCustomer(Customer customer) {
		String sql = "insert into users1 (last_name, first_name, email_address, phone_number, user_name, password) values (?,?,?,?,?,?);";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, customer.getLasName());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getEmaiAddress());
			ps.setDouble(4, customer.getPhoneNumber());
			ps.setString(5, customer.getUserName());
			ps.setString(6, customer.getUserPassword());

//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				customer.setLasName(rs.getString("last_name"));
//				customer.setFirstName(rs.getString("first_name"));
//				customer.setEmaiAddress(rs.getString("email_address"));
//				customer.setPhoneNumber(rs.getDouble("phone_number"));
//				customer.setUserName(rs.getString("user_name"));
//				customer.setUserPassword(rs.getString("password"));
//				
//				
//			}
		} catch (SQLException e) {
			System.out.println("null!");
			log.error("Logging Error" + e);
		}

		return customer;
	}

	@Override
	public List<Customer> retrieveCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer retrieveCustomerByUsername(String username) {
		Customer customer = new Customer();
		String sql = "select * from users1 where user_name =?;";
		try (Connection c = ConnectionHandler.getConnectionFromEnv();) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setUserPassword(rs.getString("password"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			log.error("Logged" + e.getLocalizedMessage());
		}

		return customer;
	}

}
