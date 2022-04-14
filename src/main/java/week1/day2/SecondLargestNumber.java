package week1.day2;

import java.util.Arrays;

public class SecondLargestNumber {

	public void printSecondLargestNumber(int[] inputArray) {
		
		Arrays.sort(inputArray);
		int arrLength = inputArray.length;
		if(arrLength>1) {
			System.out.println(inputArray[arrLength-2]);
		}
		else {	// To avoid arrayException
			System.out.println(inputArray[arrLength-1]);
		}
		
	}
	

	
	public static void main(String[] args) {
		int[] inputArray = {5,6,1,10,35,44,2,4};
//		int[] inputArray = {7};

		SecondLargestNumber secondLargestNumber = new SecondLargestNumber();
		secondLargestNumber.printSecondLargestNumber(inputArray);
	}

}
