package week3.day2;

public class CharOccurance {
	
	void getOccuranceCount(char letterToFind) {
	
		String str = "welcome to chennai";
	
		// declare and initialize a variable count to store the number of occurrences
		int count = 0;
		
		// convert the string into char array
		char[] charArray = str.toCharArray();
			
		//get the length of the array
		int arrLength = charArray.length;
			
		// traverse from 0 till the array length 
		for (int i = 0; i < arrLength; i++) {
	
			// Check the char array has the particular char in it 
			if(charArray[i] == letterToFind) {
				// if is has increment the count
				count++;
			}
			
		}
		
		// print the count out of the loop	 
		System.out.println("No of occurance of the letter '" + letterToFind + "' inside the word '" + str + "' is " + count);

	}
	
	public static void main(String[] args) {
		// Check number of occurrences of a char (eg 'e') in a String
		char letterToFind = 'c';
		
		CharOccurance charOccurance = new CharOccurance();
		charOccurance.getOccuranceCount(letterToFind);
	}

}
