package week1.day1;

public class Factorial {
	/*
	 * Goal: Find the Factorial of a given number
	 * 
	 * input: 5
	 * output: 5*4*3*2*1 = 120
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1)
	 * 2)
	 * 3) 
	 * 
	 */
	public Long findFactorialUsingLoop(Long input) {
		Long fact = input;
		for (Long i = input; i >1; i--) {
			fact = fact*(i-1);
		}
		return fact;
	}	

	public Long findFactorialUsingRecursion(Long input) {
		if(input>1) {
			return input*findFactorialUsingRecursion(input-1);
		}
		return 1L;
	}
	
	public static void main(String[] args) {

		Factorial factorial = new Factorial();
		
		Long input = 5L;
		
		System.out.println("Loop Method: Factorial of " + input + " is " + factorial.findFactorialUsingLoop(input));

		System.out.println("Loop Method: Factorial of " + input + " is " + factorial.findFactorialUsingRecursion(input));
		
	}

}
