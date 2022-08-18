package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionFindIntersection {

	public void findAndPrintIntersection() {
//		* Pseudo Code
//		
//		 * a) Declare An array for {3,2,11,4,6,7};	
		Integer[] array1 = {3,2,11,4,6,7};	
		
//		 * b) Declare another array for {1,2,8,4,9,7};
		Integer[] array2 = {1,2,8,4,9,7};

		List<Integer> listArray1 = new ArrayList<Integer> (Arrays.asList(array1));
		List<Integer> listArray2 = new ArrayList<Integer> (Arrays.asList(array2));
		
//		 * c) Declare for loop iterator from 0 to array length
		for (Integer valueList1 : listArray1) {
//			 * d) Declare a nested for another array from 0 to array length
			for (Integer valueList2 : listArray2) {
//				 * e) Compare Both the arrays using a condition statement
				if (valueList1 == valueList2) {
//					 *  f) Print the first array (shoud match item in both arrays)
					System.out.println(valueList1);
				}
			}			
		}	 
	}
	
	public static void main(String[] args) {

		CollectionFindIntersection collectionFindIntersection = new CollectionFindIntersection();
		collectionFindIntersection.findAndPrintIntersection();
		
	}

}
