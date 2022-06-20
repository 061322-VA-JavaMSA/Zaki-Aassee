package setAndget;

import java.util.Scanner;

public class MyclassMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		Myclass std1 = new Myclass();
		Myclass std2 = new Myclass();
		Myclass std3 = new Myclass();
		Myclass std4 = new Myclass();
		Myclass std5 = new Myclass();
		Myclass std6 = new Myclass();
		Myclass std7 = new Myclass();
		Myclass std8 = new Myclass();
		Myclass std9 = new Myclass();
		Myclass std10 = new Myclass();
		
		String[] StdArr = new String [10];
		
		System.out.println("Please Enter Student Name: ");
		
		for (int i = 0 ; i <10; i++) {
			
			String StdName= input.next();
			
			StdArr[i]= StdName;
			
			std1.setName(StdArr[0]);
			std2.setName(StdArr[1]);
			std3.setName(StdArr[2]);
			std4.setName(StdArr[3]);
			std5.setName(StdArr[4]);
			std6.setName(StdArr[5]);
			std7.setName(StdArr[6]);
			std8.setName(StdArr[7]);
			std9.setName(StdArr[8]);
			std10.setName(StdArr[9]);
			
		}
		
		
		
		
	}

}
