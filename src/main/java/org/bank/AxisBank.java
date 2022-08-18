package org.bank;

public class AxisBank extends BankInfo{

	public void deposit() {

		System.out.println("Deposit method is overridden in the class name " + this.getClass().toString());
		
	}
	
	public static void main(String[] args) {

		AxisBank axisBank = new AxisBank();
		axisBank.saving();
		axisBank.fixed();
		axisBank.deposit();
	}


}
