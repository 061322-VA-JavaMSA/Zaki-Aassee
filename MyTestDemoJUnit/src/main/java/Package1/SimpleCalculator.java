<<<<<<< HEAD
package Package1;

import java.lang.reflect.Array;

public class SimpleCalculator {
	
	public int Add (int numA , int numB) {
		return numA + numB;
		
	}
	
	public float Substract(float A) {
		return A-A;
		
	}
	public int Devide(int a , int b) {
	
		if (b==0) {
			throw new DevideByZeroException();
			
		}
		return 0;
	}
	public int Multiply(int a , int b) {
	
		return a*b;
		
	}
	
	public int sumOfArray(int [] someNumbers) {
		someNumbers = new int[5];
		someNumbers[1]=1;
		someNumbers[1]=2;
		someNumbers[1]=3;
		someNumbers[1]=4;
		someNumbers[1]=5;
		
		int sum = 0;
		for (int value : someNumbers) {
			sum += value;
			
		}
		return sum;
	}


	
	

}
=======
package Package1;

import java.lang.reflect.Array;

public class SimpleCalculator {
	
	public int Add (int numA , int numB) {
		return numA + numB;
		
	}
	
	public float Substract(float A) {
		return A-A;
		
	}
	public int Devide(int a , int b) {
	
		if (b==0) {
			throw new DevideByZeroException();
			
		}
		return 0;
	}
	public int Multiply(int a , int b) {
	
		return a*b;
		
	}
	
	public int sumOfArray(int [] someNumbers) {
		someNumbers = new int[5];
		someNumbers[1]=1;
		someNumbers[1]=2;
		someNumbers[1]=3;
		someNumbers[1]=4;
		someNumbers[1]=5;
		
		int sum = 0;
		for (int value : someNumbers) {
			sum += value;
			
		}
		return sum;
	}


	
	

}
>>>>>>> 25d1586912ab94221ed62f954d3bf1abec33d4ea
