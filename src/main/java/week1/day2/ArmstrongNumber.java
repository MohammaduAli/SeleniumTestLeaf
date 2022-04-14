package week1.day2;

public class ArmstrongNumber {
// Pseudo Code link -> https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week1/day1/assignments/ArmstrongNumber.java
	
	public int findArmstrongNumber(int inputNumber) {
		int sum = 0;
		
		while(inputNumber>0) {
			int quotient = inputNumber/10;
			int reminder = inputNumber%10;
			sum = sum + (reminder*reminder*reminder);
			inputNumber = quotient;
		}
		
		return sum;
	}
	
	public void printArmstrongNumberOrNot(int inputNumber) {
		int Outputnumber = findArmstrongNumber(inputNumber);
		
		if(inputNumber == Outputnumber) {
			System.out.println("The given number " + inputNumber + " is an Armstrong Number");
		}
		else {
			System.out.println("The given number " + inputNumber + " is not an Armstrong Number");
		}	
	}
	
	public static void main(String[] args) {
		
		ArmstrongNumber armstrongNumber = new ArmstrongNumber();		

		int inputNumber = 153;
		armstrongNumber.printArmstrongNumberOrNot(inputNumber);
		
		inputNumber = 351;
		armstrongNumber.printArmstrongNumberOrNot(inputNumber);
	}

}
