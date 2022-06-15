package com.revature.strings;
import java.util.Scanner;
import java.util.Random;



public class Project0 {
	
	Scanner scan = new Scanner (System.in);
	
	StringBuilder sb = new StringBuilder ();
	

	public static void main (String[] args) {
		Scanner scan = new Scanner (System.in);
		//StringBuilder sb = new StringBuilder ();
		
		
		System.out.println("Hello Please select from below options : 1-Print a random number , 2 - Reverse a String , 3 - Exit");
		String s = scan.nextLine();
		

	switch (s) {
	case "1":
		System.out.println(Math.random()*120);
		break;
	case "2" :
		System.out.println("Enter a String we will reverse it :");
		
		String ss = scan.nextLine();
		StringBuilder sb = new StringBuilder (ss);
		
		System.out.print(ss + " " + sb.reverse());
		
		
		break;
		
		
		
	case "3":
		System.out.print("Goodbye");
			
		break;
		
	default :
		System.out.println("No Option");
		
		
		
		
		
	}
//	System.out.println("Not an options ");
	
	
	
	}
		
		
	
				
		

		
	
		
	
	
	
	

}
