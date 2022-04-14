package week1.day1;

public class ConvertNegativeNumber {
//Problem statement: Convert a negative number to positive number
	int negativeNumber = -140;
	
	public void convertNegativeToPositive(int inputNumber) {
		if(inputNumber<0) {
			int positiveNumber = inputNumber * -1;
			System.out.println("The number " + inputNumber + " is converted to " + positiveNumber);			
		}
		else {
			System.out.println("The number " + inputNumber + " is already a positive number");			
		}
		
	}
	
	public static void main(String[] args) {
		
		ConvertNegativeNumber convertNegativeNumber = new ConvertNegativeNumber();
		convertNegativeNumber.convertNegativeToPositive(convertNegativeNumber.negativeNumber);
		
	}

}
