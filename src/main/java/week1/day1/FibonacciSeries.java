package week1.day1;

public class FibonacciSeries {

	public void findFibonacciSeriesUsingFor(int inputRange) {
//		0, 1, 1, 2, 3, 5, 8, 13
		int firstNumber, secondNumber, sum;
		sum = 0;
		firstNumber = 0;
		secondNumber = 1;
		
		if(inputRange == 0 || inputRange == 1) {
			System.out.print("\n" + firstNumber);	//To avoid iterations
		}else{
			System.out.print("\n" + firstNumber + " " + secondNumber);
		}

		for(int i=2; i<inputRange; i++) {
//			System.out.println("First Number: " + firstNumber + " Second Number: " + secondNumber);
			sum = firstNumber+secondNumber;
			firstNumber = secondNumber;
			secondNumber=sum;
			System.out.print(" " + sum);
		}
	}

	public void findFibonacciSeriesUsingWhile(int inputRange) {
//		0, 1, 1, 2, 3, 5, 8, 13
		int firstNumber, secondNumber, sum;
		int counter = 2;
		sum = 0;
		firstNumber = 0;
		secondNumber = 1;
		
		if(inputRange == 0 || inputRange == 1) {
			System.out.print("\n" + firstNumber);	//To avoid iterations
		}else{
			System.out.print("\n" + firstNumber + " " + secondNumber);
		}
		
		while(counter<inputRange) {
			sum = firstNumber+secondNumber;
			firstNumber = secondNumber;
			secondNumber=sum;
			System.out.print(" " + sum);
			counter++;
		}
	}
	
	public static void main(String[] args) {

		FibonacciSeries fibonacciSeries = new FibonacciSeries();
		
		int inputRange = 4;
		
		fibonacciSeries.findFibonacciSeriesUsingFor(inputRange);

		fibonacciSeries.findFibonacciSeriesUsingWhile(inputRange);
	}

}
