package week1.day1;

public class VerifyPositiveOrNegative {

	public void printPositiveOrNegative(int inputNumber) {
		if(inputNumber<0) {
			System.out.println("The number " + inputNumber + " is negative");
		}
		else if(inputNumber>0){
			System.out.println("The number " + inputNumber + " is positive");			
		}
		else {
			System.out.println("The number " + inputNumber + " is neither positive nor negative");
		}
	}
	
	public static void main(String[] args) {
		
		VerifyPositiveOrNegative verifyPositiveOrNegative = new VerifyPositiveOrNegative();

		int inputNumber = 40;
		verifyPositiveOrNegative.printPositiveOrNegative(inputNumber);		

		inputNumber = -40;
		verifyPositiveOrNegative.printPositiveOrNegative(inputNumber);

		inputNumber = 0;
		verifyPositiveOrNegative.printPositiveOrNegative(inputNumber);

	}

}
