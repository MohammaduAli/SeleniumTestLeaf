package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionRemoveDuplicateWords {
	
	void removeDuplicateWordsAndPrint(String inputString) {

//		 * Pseudo code 
//		 
//		 * a) Use the declared String text as input	
//		 * b) Initialize an integer variable as count
			
//		 * c) Split the String into array and iterate over it
			String[] arrayWords = inputString.split(" ");
			List<String> listWords = new ArrayList <String> (Arrays.asList(arrayWords));
			int wordCount = listWords.size();
			
			for (int i = 0; i <= wordCount-1; i++) {	  
				int count = 0;
//				 * d) Initialize another loop to check whether the word is there in the array
				for (int j = 0; j <= wordCount-1; j++) {
//					 * e) if it is available then increase and count by 1.
					if (listWords.get(i).equals(listWords.get(j))) {
//						 * f) if the count > 1 then replace the word as "" 
						count++;
						if (count>1) {
							listWords.remove(j);
							wordCount--;
						}
					}
				}
				
			}
			
//			 * g) Displaying the String without duplicate words	
			System.out.println("String without duplicate words : " + listWords.toString().replace(",", ""));

	}

	public static void main(String[] args) {

		String inputString = "We learn java basics as part of java sessions in java week1";	
		
		CollectionRemoveDuplicateWords removeDuplicateWords = new CollectionRemoveDuplicateWords();
		removeDuplicateWords.removeDuplicateWordsAndPrint(inputString);
	}

}
