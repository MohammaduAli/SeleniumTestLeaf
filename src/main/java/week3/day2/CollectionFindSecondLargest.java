package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionFindSecondLargest {
	
	void findAndPrintSecondLargest(List<Integer> inputList){
		Collections.sort(inputList);
		if (inputList.size()>1) {

			System.out.println(inputList.get(inputList.size()-2));
			
		} else {

			System.out.println(inputList.get(0));
		}
	}
	

	public static void main(String[] args) {
		Integer[] data = {3,2,11,4,6,7};
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(data)) ;

		CollectionFindSecondLargest collectionFindSecondLargest = new CollectionFindSecondLargest();
		collectionFindSecondLargest.findAndPrintSecondLargest(inputList);

	}

}
