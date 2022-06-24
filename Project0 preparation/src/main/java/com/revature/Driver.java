package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.User;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		String url="jdbc:postgresql://localhost:5432/postgres";
		String username="postgres";
		String password="0011";
		
		Connection c= null;
		try {
			
			c=DriverManager.getConnection(url, username, password);
			System.out.println(c.getMetaData().getDriverName());
			
		}
		
		catch (SQLException e) {
			
			e.fillInStackTrace();
		}

		System.out.println("Please select from below menu:");
		System.out.println("For female employee count enter (1)");
		System.out.println("For male employee count enter (2)");
		Scanner input = new Scanner (System.in);
		//int id = Integer.parseInt(input.nextLine());
		//String sql = "select gender from users where user_id = "+ id +"; ";
		
		Statement s = c.createStatement();
		//ResultSet result = s.executeQuery(sql);
		//System.out.println(result);
		
		int idd = Integer.parseInt(input.nextLine());
		ResultSet r;
		String countF = "select count (gender) from users where gender = 'Female';";
		String countM = "select count (gender) from users where gender = 'Male';";
		
		if (idd == 1) {
			r=s.executeQuery(countF);
			r.next();
			int count = r.getInt("count");
			
			System.out.println("The overall count of female employees is " + count );
		}
		else {
			r= s.executeQuery(countM);
			r.next();
			int count = r.getInt("count");
			
			System.out.println("The overall count of male employees is " + count );
		}
	
		r.close();
		input.close();
		
		
		
		
		
		//User u = null; ;
//		while (result.next()) {
//		 u = new User();
//			//u.setUsername(result.getString("user_name"));
//			//u.setId(result.getInt("user_id"));
//			//u.setEmail(result.getString("email_address"));
//			u.setGender(result.getString("gender"));
//			//u.setPassword(result.getString("user_password"));
//			System.out.println(result.getString("gender"));
		
			
		}
		//System.out.println(u);
		//c.close();
		

		

	

}
