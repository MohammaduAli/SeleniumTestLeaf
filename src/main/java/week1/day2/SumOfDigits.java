package week1.day2;

public class SumOfDigits {

	public void printSumOfDigits(int inputNumber) {
		int sum = 0;
		
		System.out.println("The input number is " + inputNumber);
		
		while(inputNumber>0) {
			int reminder = inputNumber%10;
			int quotient = inputNumber/10;
			sum = sum + reminder;
			inputNumber = quotient;
			System.out.println("Reminder: " + reminder + " Quotient: " + quotient);
		}
		
		System.out.println("The sum is " + sum);
	}
	
	public static void main(String[] args) {

		SumOfDigits sumOfDigits = new SumOfDigits();
		
		int inputNumber = 123;
		sumOfDigits.printSumOfDigits(inputNumber);

	}

}
