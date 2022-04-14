package week3.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateCharInString {

	public static void main(String[] args) {
		
		String inputText = "Paypal India";
		
		RemoveDuplicateCharInString removeDuplicateCharInString = new RemoveDuplicateCharInString();
		removeDuplicateCharInString.removeDuplicateChars(inputText);
	}
	
	public void removeDuplicateChars(String inputText) {
		
//		1. Remove the duplicate characters in String
//		    String s = "PayPal India"
//		    Output = "Payl Indi"
//		    a. Declare String 
//		    b. convert to char array
//		    c. Declare a set and add all characters to set
//		    d. sort the set
//		    e. iterate and print the set values
		char[] charArray = inputText.toCharArray();
		Set <Character> newSet= new LinkedHashSet<Character>();	//To print in the same order
//		Set <Character> newSet= new TreeSet<Character>();	//To print in the sorted order

		for (char c : charArray) {			
			newSet.add(c);
		}
		
//		Method 1
//		String uniqueChars = newSet.toString();
//		System.out.println(uniqueChars);
		
//		Method 2
		for (Character character : newSet) {
			System.out.print(character);
		}
	}
	
}
