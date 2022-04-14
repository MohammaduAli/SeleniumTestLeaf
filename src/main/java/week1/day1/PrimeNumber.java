package week1.day1;

public class PrimeNumber {

	public void printPrimeOrNot(int inputNumber) {
//		The prime number is a number which is divisible by only two number: 1 and itself
		boolean flagPrime = true;
		if(inputNumber==0 || inputNumber==1) {
			flagPrime = false;
			System.out.println(inputNumber + " is not a Prime number");
		}
		else {
			for (int i=2; i<=inputNumber/2; i++) {
				if(inputNumber%i==0) {
					System.out.println(inputNumber + " is not a Prime number");
					flagPrime = false;
					break;
				}
			}
		}
		
		if(flagPrime) {
			System.out.println(inputNumber + " is a Prime number");
		}
	}
	
	public static void main(String[] args) {
		PrimeNumber primeNumber = new PrimeNumber();
		
		int inputNumber = 0;
		primeNumber.printPrimeOrNot(inputNumber);
		
		inputNumber = 1;
		primeNumber.printPrimeOrNot(inputNumber);

		inputNumber = 14;
		primeNumber.printPrimeOrNot(inputNumber);
		
		inputNumber = 17;
		primeNumber.printPrimeOrNot(inputNumber);
		
		inputNumber = 3;
		primeNumber.printPrimeOrNot(inputNumber);
	}

}
