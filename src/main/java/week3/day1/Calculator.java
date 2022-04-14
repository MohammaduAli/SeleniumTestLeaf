package week3.day1;


public class Calculator {
	
	public int add(int num1, int num2) {
		System.out.println("Adding two integers: " + num1 + " " + num2);
		return num1+num2;
	}

	public int add(int num1, int num2, int num3) {
		System.out.println("Adding three integers: " + num1 + " " + num2 + " " + num3);
		return num1+num2+num3;
	}

	public int multiply(int num1, int num2) {
		System.out.println("Multiplying two integers: " + num1 + " " + num2);
		return num1*num2;
	}

	public double multiply(int num1, double num2) {
		System.out.println("Multiplying one integer and one double: " + num1 + " " + num2);
		return num1*num2;
	}

	public int subtract(int num1, int num2) {
		System.out.println("Subtracting two integers: " + num1 + " " + num2);
		return num1-num2;
	}

	public double subtract(double num1, double num2) {
		System.out.println("Subtracting two doubles: " + num1 + " " + num2);
		return num1-num2;
	}

	public int divide(int num1, int num2) {
		System.out.println("Dividing two integers: " + num1 + " " + num2);
		return num1/num2;
	}

	public double divide(double num1, double num2) {
		System.out.println("Dividing two doubles: " + num1 + " " + num2);
		return num1/num2;
	}

	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		double num4 = 23232222.55;
		double num5= 12454543.122;
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.add(num1, num2, num3));
		
		System.out.println(calc.multiply(num1, num2));
		System.out.println(calc.multiply(num1, num4));
		
		System.out.println(calc.subtract(num1, num2));
		System.out.println(calc.subtract(num5, num4));
		
		System.out.println(calc.divide(num2, num1));
		System.out.println(calc.divide(num4, num5));
	}

}
