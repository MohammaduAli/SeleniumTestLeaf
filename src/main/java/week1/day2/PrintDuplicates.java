package week1.day2;

import java.util.Arrays;

public class PrintDuplicates {
	
//	Compare one element with all remaining elements in the array
//	Array elements remain in the same order/position
	public void printDuplicatesWithoutSorting(int[] inputArray) {
		int arrLength = inputArray.length;
		int count;
		
		System.out.print("\nDuplicates found for the numbers ");
		for (int i = 0; i < arrLength; i++) {
			count = 0;
			for (int j = i+1; j < arrLength; j++) {
				if(inputArray[i] == inputArray[j]) {
					count++;
				}
			}
			if(count>0) {
				System.out.print(inputArray[i] + " ");
			}
		}
				
	}

//	Sort the array and then compare with adjacent values for duplicates
//	Array element position changes due to sorting
	public void printDuplicatesWithSorting(int[] inputArray) {
		Arrays.sort(inputArray);
		
		System.out.print("\nDuplicates found for the numbers ");

		for (int i = 0; i < inputArray.length-1; i++) {
			if(inputArray[i]==inputArray[i+1]) {
				System.out.print(inputArray[i] + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		PrintDuplicates printDuplicates = new PrintDuplicates();
		
		int[] inputArray = {14,12,13,11,15,14,18,16,17,19,18,17,20,17};
		
		printDuplicates.printDuplicatesWithoutSorting(inputArray);
		printDuplicates.printDuplicatesWithSorting(inputArray);

	}

}
