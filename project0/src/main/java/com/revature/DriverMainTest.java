package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.Item;
import com.revature.util.ConnectionHandler;

public class DriverMainTest {
	ConnectionHandler c ;


	public static void main(String[] args) {
		
	Item item = new Item();
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password ="0011";
		
	
		System.out.println();
		
		
		
		
		
		System.out.println("Enter id : ");
		
		
		Scanner scan = new Scanner (System.in);
		String input =scan.nextLine();
		
		
		
	
		try {
		String sql = "select * from items where item_name ='"+input+"';";
		
		Connection c = DriverManager.getConnection(url, username, password);
		Statement s = c.createStatement();
		ResultSet rs= s.executeQuery(sql);
		
		
		
		while (rs.next()) {
			
			item.setItemNumber(rs.getString("item_number"));
			item.setItemCategory(rs.getString("item_category"));
			item.setItemModel(rs.getString("item_model"));
			item.setItemName(rs.getString("item_name"));
			item.setItemPrice(rs.getFloat("item_price"));
			item.setItemQuantity(rs.getInt("item_quantity"));
			
		}
		}
		catch (SQLException e) {
			e.fillInStackTrace();
		}
		System.out.println(item);
		
		scan.close();
	

	}

}
