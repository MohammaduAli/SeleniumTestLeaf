package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionMissingElementInAnArray {

	void printMissingElement() {
//		 Here is the input
		Integer[] arr = {1,2,3,4,7,6,8};
		List<Integer> listValues = new ArrayList<Integer>(Arrays.asList(arr));
		List<Integer> listMissingValues = new ArrayList<Integer>();
		
		// Sort the array	
		Collections.sort(listValues);

		// loop through the array (start i from arr[0] till the length of the array)
		for (int i = 0; i < listValues.size(); i++) {
			// check if the iterator variable is not equal to the array values respectively
			if ((i+1)!=listValues.get(i)) {
				// print the number
				System.out.println("Missing value is " + (i+1));

				// once printed break the iteration
				break;
			}
		}			
				
	}
	
	public static void main(String[] args) {

		CollectionMissingElementInAnArray printMissingElementInAnArray = new CollectionMissingElementInAnArray();
		printMissingElementInAnArray.printMissingElement();
		
	}

}
