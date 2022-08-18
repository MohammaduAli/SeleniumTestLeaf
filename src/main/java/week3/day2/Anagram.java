package week3.day2;

public class Anagram {
	
	public char[] sortArray(char[] inputArray) {
		
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if (inputArray[i]>inputArray[j]) {
					char temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		printArray(inputArray);
		System.out.println("");
		return inputArray;
	}
	
	public void printArray(char[] inputArray) {
		// Printing array
	    for (char c : inputArray) {
	        System.out.print(c);
	    }
	}
	
	public boolean checkBothArraysAreEqual(char[] array1, char[] array2) {
		boolean flag = true;
		
		for (int i = 0; i < array2.length; i++) {
			if(array1[i]!=array2[i]) {
				flag = false;
				break;
			}			
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		
//		 *Declare a String 
			String text1 = "stops";
			
//		 *Declare another String
			String text2 = "potsq";
			
//		 * a) Check length of the strings are same then (Use A Condition)
			if (text1.length() == text2.length()) {

//				 * b) Convert both Strings in to characters
				char[] array1 = text1.toCharArray();
				char[] array2 = text2.toCharArray();
				
//				 * c) Sort Both the arrays
				char[] sortedArray1 = anagram.sortArray(array1);
				char[] sortedArray2 = anagram.sortArray(array2);
				
				String sortedChars1 = String.valueOf(sortedArray2);
				String sortedChars2 = String.valueOf(sortedArray2);
				
//				 * d) Check both the arrays has same value
				if (anagram.checkBothArraysAreEqual(sortedArray1, sortedArray2)) {
					
					System.out.println("Both the words form an anagram");
					System.out.println("Given words: " + text1 + " & " + text2);
					System.out.println("After sorting characters: " + sortedChars1 + " " + sortedChars2);
					
				} else {
					
					System.out.println("Both the words do not form an anagram");
					System.out.println("Given words: " + text1 + " " + text2);
					System.out.println("After sorting characters: " + sortedChars1 + " & " + sortedChars2);

				}
				
			} else {
				System.out.println("The given strings do not form anagram");
			}
	}

}
