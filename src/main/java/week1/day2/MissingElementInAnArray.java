package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {
	
	public void findMissingElementInAnArray(int[] inputArray) {
		Arrays.sort(inputArray);		
		
		int arrLength = inputArray.length;
		int sum = ((arrLength+1)*(arrLength+2))/2;
		for (int i = 0; i < inputArray.length; i++) {
			sum-= inputArray[i];
		}
		System.out.println(sum);
	}

	public void findMissingElementInAnArrayusingLoop(int[] inputArray) {
		Arrays.sort(inputArray);
		
		int arrLength = inputArray.length;
		for (int i = 0; i < inputArray.length; i++) {
			if (i+1 != inputArray[i]) {
				System.out.println(i+1);
				break;
			}
		}
	}
	public static void main(String[] args) {
		
		MissingElementInAnArray missingElementInAnArray = new MissingElementInAnArray();
		
		int[] inputArray = {1, 2 ,3 ,4 ,7 ,6 ,8};
		
		missingElementInAnArray.findMissingElementInAnArray(inputArray);
		
		missingElementInAnArray.findMissingElementInAnArrayusingLoop(inputArray);
		
	}
}
