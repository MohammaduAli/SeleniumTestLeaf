package week3.day2;

public class Palindrome {

	public String reverseString(String inputString) {
		String rev ="";
		for (int i = inputString.length()-1; i >= 0 ; i--) {
			rev = rev + inputString.charAt(i);
		}
		return rev;
	}
	
	public boolean compareTwoStrings(String inputString1, String inputString2) {
		if (inputString1.equals(inputString2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		
//	* a) Declare A String value as"madam"
		String firstString = "madam";
		
//	* b) Declare another String rev value as ""
		String rev = "";
		
//	* c) Iterate over the String in reverse order
//		* d) Add the char into rev
		rev = palindrome.reverseString(firstString);		
		
//	* e) Compare the original String with the reversed String, if it is same then print palinDrome
		if (palindrome.compareTwoStrings(firstString, rev)) {
			System.out.println("The given string '" + firstString + "' is a palindrome");
		} else {
			System.out.println("The given string '" + firstString + "' is not a palindrome");
		}
	}

}
