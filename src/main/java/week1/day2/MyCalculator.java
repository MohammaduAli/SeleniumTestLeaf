package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		System.out.println("Addition : " + calculator.add(10, 20, 30));
		System.out.println("Subtraction : " + calculator.subtract(10, 20));
		System.out.println("Multiplication : " + calculator.multiply(10, 20));
		System.out.println("Division : " + calculator.divide(100, 20));
	}

}
