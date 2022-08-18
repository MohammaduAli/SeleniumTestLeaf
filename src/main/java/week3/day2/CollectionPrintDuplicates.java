package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionPrintDuplicates {
	
	void printDuplicatesWithoutSorting() {
		Integer[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,17,20};
		List<Integer> listNumbers = new ArrayList<Integer>(Arrays.asList(arr));
		List<Integer> listDuplicateNumbers = new ArrayList<Integer>();
		int count;
		
		for (int i = 0; i < listNumbers.size(); i++) {
			count = 0;
			for (int j = i+1; j < listNumbers.size(); j++) {
				if (listNumbers.get(i)==listNumbers.get(j)) {
					count++;
				}
			}
			if (! listDuplicateNumbers.contains(listNumbers.get(i))) {
				
				listDuplicateNumbers.add(listNumbers.get(i));
				if (count>0) {
					System.out.println("Number "+ listNumbers.get(i) + " duplicated " + count + " times");					
				}

			}
		}
	}
	
	void printDuplicatesAfterSorting() {

		Integer[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		List<Integer> listNumbers = new ArrayList<Integer>(Arrays.asList(arr));
		Collections.sort(listNumbers);
		
		for (int i = 0; i < listNumbers.size()-1; i++) {
			if(listNumbers.get(i)==listNumbers.get(i+1)) {
				if ((i>0) && (listNumbers.get(i-1)==listNumbers.get(i))) {
										
				}
				else {
					System.out.println(listNumbers.get(i));
				}				
			}
		}
	}
	
	public static void main(String[] args) {

		CollectionPrintDuplicates collectionPrintDuplicates = new CollectionPrintDuplicates();
		
		System.out.println("\nDuplicates without sorting");
		collectionPrintDuplicates.printDuplicatesWithoutSorting();

		System.out.println("\nDuplicates after sorting");
		collectionPrintDuplicates.printDuplicatesAfterSorting();
	}

}
