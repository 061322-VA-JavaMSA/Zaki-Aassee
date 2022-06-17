package Package1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class SimpleCalculatorTest {
	
	@Test 
	public void add() {
		SimpleCalculator add = new SimpleCalculator();
		int expected = 4;
		//calculator.add(2, 2);
		assertEquals(expected, add.Add(2, 2));	
		
	}
	@Test
	public void IsNumMinusItselfIsZero() {
		SimpleCalculator sub = new SimpleCalculator();
		float expected = 0;
		assertEquals(expected, sub.Substract(7));
		
	}
	@Test 
	public void DivisionByZeroCheck() {
		SimpleCalculator div = new SimpleCalculator();
		assertThrows(DevideByZeroException.class, () -> div.Devide(9, 0));
	}
	
	@Test
	public void MultiplicationTest() {
		SimpleCalculator Mul = new SimpleCalculator();
		
		int expected = 100;
		assertEquals(expected, Mul.Multiply(10, 10));
		
	}
	@Test
	public void SomeOfArrayCheck() {
		SimpleCalculator SumOfArrayCheck = new SimpleCalculator();
		int expected = 15;
		assertEquals(expected, SumOfArrayCheck.sumOfArray[5]);
		
	
	}

}
