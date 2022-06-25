package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.exceptions.LoginExceptions;
import com.revature.models.Item;
import com.revature.services.Authentication;
import com.revature.util.ConnectionHandler;

public class DriverMain {
	static Scanner scan;
	static Authentication as;

	public static void main(String[] args) throws IOException {
		Item item = new Item();
		scan = new Scanner(System.in);
		String username= null;
		String password = null;
		System.out.println("Enter username: ");
		username = scan.nextLine();
		System.out.println("enter password: ");
		password = scan.nextLine();
	
		try {
			System.out.println(as.login(username, password));
		}
		catch (LoginExceptions e) {
			System.out.println("invalid " + e);
			
		}
		scan.close();

	}

}
