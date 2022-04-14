package week1.day2;

public class FindIntersection {

	public void printIntersection(int[] inputArray1, int[] inputArray2) {
		System.out.println("Below are the intersection values from both the arrays");
		
		for (int i = 0; i < inputArray1.length; i++) {
			for (int j = 0; j < inputArray2.length; j++) {
				if (inputArray1[i] == inputArray2[j]) {
					System.out.println(inputArray1[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) {

		FindIntersection findIntersection = new FindIntersection();
		
		int[] inputArray1 = {3,2,11,4,6,7};
		int[] inputArray2 = {1,2,8,4,9,7};
		findIntersection.printIntersection(inputArray1, inputArray2);

	}

}
