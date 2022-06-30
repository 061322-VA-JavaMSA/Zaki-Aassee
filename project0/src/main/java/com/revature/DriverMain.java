package com.revature;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.ItemPostgres;
import com.revature.daos.ManagerPostgres;
import com.revature.exceptions.LoginExceptions;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.models.Manager;
import com.revature.services.Authentication;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.services.ItemService;
import com.revature.services.ManagerService;

public class DriverMain {
	static Authentication auth;
	static Scanner scan;
	static EmployeePostgres ep;
	static EmployeeService es;
	static Employee e;
	static Item i;
	static ItemPostgres ip;
	static ItemService iS;
	static CustomerService cs;
	static CustomerPostgres cp;
	static Customer c;
	static String username;
	static String password;
	static ManagerPostgres mp;
	static ManagerService ms;
	static Manager mgr;

	public static void main(String[] args) throws Exception {
		String repeat = null;

		scan = new Scanner(System.in);
		auth = new Authentication();
		ep = new EmployeePostgres();
		es = new EmployeeService();
		ip = new ItemPostgres();
		iS = new ItemService();
		cs = new CustomerService();
		cp = new CustomerPostgres();
		c = new Customer();
		mp = new ManagerPostgres();

		while (!"end".equals(repeat)) {
			System.out.println("\n");
			System.out.println(" ** Welcom to MiniBestBuy! ** ");
			System.out.println(" ** Please select from below options to proceed: ** ");
			System.out.println(
					" Enter (1) to LogIn as Employee \n Enter (2) to LogIn as Customer \n Enter (3) to Create new user account \n Enter (0) to Login as Manager:");
			int in = scan.nextInt();
			String username = null;
			String password = null;
			String username2 = null;
			String password2 = null;

			if (in == 1) {
				repeat = "end";
				System.out.println("Welcome Employee!");
				System.out.println("Enter your username:");
				username = scan.next();
				System.out.println("Enter your password:");
				password = scan.next();
				try {
					auth.login(username, password);
				} catch (LoginExceptions e) {
					e.printStackTrace();
				}
				System.out.println("welcome");

				// e = ep.retrieveEmployeeByUsername(username);
				// System.out.println(e);
				System.out.println(" 1 -View items \n 2- Add new items \n 3- Delete Items");
				int a = 0;
				a = scan.nextInt();
				if (a == 1) {
					List<Item> items = iS.getItems();
					System.out.println("Item list:");
					System.out.println(" * * * * * * * * * * * * * ");
					for (Item iT : items) {
						System.out.println(iT);
					}

				} else if (a == 2) {
					Item newItem = new Item();
					System.out.println("Creating your new Item");

					System.out.println("Enter Item Number:");
					String itemNumber = scan.next();

					System.out.println("Enter Item Name:");
					String itemName = scan.next();

					System.out.println("Enter Item Price:");
					Float itemPrice = scan.nextFloat();

					System.out.println("Enter Item category:");
					String itemCat = scan.next();

					System.out.println("Enter Item Item Model:");
					String itemModel = scan.next();

					System.out.println("Enter Item item Quantity:");
					int itemQuantity = scan.nextInt();

					newItem.setItemNumber(itemNumber);
					newItem.setItemName(itemName);
					newItem.setItemPrice(itemPrice);
					newItem.setItemCategory(itemCat);
					newItem.setItemModel(itemModel);
					newItem.setItemQuantity(itemQuantity);

					iS.createItem(newItem);
					System.out.println("Below Item was created:");
					System.out.println((newItem));

				} else if (a == 3) {
					Item i = new Item();
					System.out.println("Please Enter Item Number to delete:");
					String itemnumber = scan.next();
					i.setItemNumber(itemnumber);
					iS.deleteItem(i);
					System.out.println("This item was deleted: " + itemnumber);

				}

			} else if (in == 2) {
				repeat = "end";

				System.out.println("Enter you username:");
				username2 = scan.next();
				System.out.println("Enter your password:");
				password2 = scan.next();

				auth.userLogin(username2, password2);

				System.out.println("Welcome Customer!");
				System.out.println(" 1- View available items");
				int a = scan.nextInt();
				if (a == 1) {
					List<Item> items = iS.getItems();

					for (Item iT : items) {
						System.out.println(iT);
					}
				}
				System.out.println("Enter (2)- To buy an Item (3)- To Exit");
				a = scan.nextInt();
				if (a == 2) {
					String s = null;
					while (!"end".equals(s)) {

						Item i = new Item();
						System.out.println("Select from above Items and enter item_number:");
						String itemnumber = scan.next();
						iS.getItem(itemnumber);
						i = iS.getPrice(itemnumber);
						System.out.println("Buy the item" + itemnumber + "?");
						System.out.println("(1)- Confirm!");
						int c = scan.nextInt();
						if (c == 1) {
							s = "end";
							System.out.println("Item added to your cart ");
							System.out.println(
									"need more items ? \n Enter 1 to continue shopping Enter 2 to exit shopping:");
							int aa = scan.nextInt();
							if (aa == 1) {
								s = null;
							} else if (aa == 2) {
								s = "end";
								System.out.println("Bye");
							}
						} else {
							System.out.println("Select from items :");
							s = null;
						}
					}
				} else if (a == 3) {
					System.out.println("Bye");
				}

			} else if (in == 3) {
				repeat = "end";
				Customer newCustomer = new Customer();
				System.out.println("Welcome to new user portal \n Please enter your informaion:");

				System.out.println("LastName:");
				String lastnm = scan.next();
				System.out.println("FirsName:");
				String firstnm = scan.next();
				System.out.println("Email:");
				String emailad = scan.next();
				System.out.println("Phone:");
				double phonenm = scan.nextDouble();
				System.out.println("Username:");
				String uname = scan.next();
				System.out.println("Password:");
				String pass = scan.next();

				newCustomer.setLasName(lastnm);
				newCustomer.setFirstName(firstnm);
				newCustomer.setEmaiAddress(emailad);
				newCustomer.setPhoneNumber(phonenm);
				newCustomer.setUserName(uname);
				newCustomer.setUserPassword(pass);

				c = cs.createCustomer(newCustomer);
				System.out.println("Created!");
				System.out.println(c);

			} else if (in == 0) {
				repeat = "end";
				System.out.println("Please Enter your Credentials");
				System.out.println("Enter Username:");
				username2 = scan.next();

				System.out.println("Enter Password:");
				password2 = scan.next();

				auth.managerLogin(username2, password2);

				// mgr= mp.retrieveManagerByUsername(username2);
				System.out.println("Welcome");
				System.out.println(" 1- Make new employee account \n 2- Fire an employee \n 3- View Sale offers");

				int a;
				a = scan.nextInt();

				if (a == 1) {

					Employee newEmployee = new Employee();
					System.out.println("Enter new employee's information:");
					System.out.println("Enter employee_id:");
					int id = scan.nextInt();
					System.out.println("Enter employee_name:");
					String name = scan.next();
					System.out.println("Enter employee_username:");
					String uname = scan.next();
					System.out.println("Enter employee_password:");
					String pass = scan.next();
					System.out.println("Enter assigned_category:");
					String cat = scan.next();
					System.out.println("Enter employee_role:");
					String role = scan.next();

					newEmployee.setId(id);
					newEmployee.setEmployeName(name);
					newEmployee.setEmployeeUsername(uname);
					newEmployee.setEmployeePassword(pass);
					newEmployee.setEmployeeAssignedCategory(cat);
					newEmployee.setEmployeeRole(role);

					e = es.createEmployee(newEmployee);

					System.out.println("Created!");
					System.out.println(e);

				} else if (a == 2) {
					Employee deletedEmployee = new Employee();
					System.out.println("Enter Employee's username:");
					String username0 = scan.next();
					deletedEmployee.setEmployeeUsername(username0);
					e = es.deleteEmployee(username0);
					System.out.println("Employee Deleted from Databse" + username0);

				} else if (a == 3) {
					System.out.println("No Sales for this month");
				}

			} else {

				System.out.println("Your input was wrong. Try again");
				repeat = null;
			}
		}
		scan.close();

	}

}
