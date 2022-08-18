package week3.day2;

public class ReverseEvenWords {

	void reverseAndPrintEvenWords() {

//		Pseudo Code:
//		 
//		 * Declare the input as Follow
  		String inputString = "I am a software tester";
  		String outputString = "";
  		
//		a) split the words and have it in an array
  		String[] words = inputString.split(" ");
  		
//		b) Traverse through each word (using loop)
  		for (int i = 0; i < words.length; i++) {
//  			c) find the odd index within the loop (use mod operator)
//  			d)split the words and have it in an array
//  			e)print the even position words in reverse order using another loop (nested loop)
//  			f) Convert words to character array if the position is even else print the word as it is(concatenate space at the end).		 

			if ((i+1)%2==0) {
				outputString = outputString + " " + reverseString(words[i]);
			}else {

				outputString = outputString + " " + words[i];
			}
		}
  		
  		System.out.println(outputString);
  		
	}

	public String reverseString(String inputString) {
		String rev ="";
		for (int i = inputString.length()-1; i >= 0 ; i--) {
			rev = rev + inputString.charAt(i);
		}
		return rev;
	}
	
	public static void main(String[] args) {
		//Build a logic to reverse the even position words (output: I ma a erawtfos tester)

		ReverseEvenWords reverseEvenWords = new ReverseEvenWords();
		reverseEvenWords.reverseAndPrintEvenWords();
	}

}
