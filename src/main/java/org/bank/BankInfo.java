package org.bank;

public class BankInfo {

	public void saving() {

		System.out.println("Saving method is called from the class name " + this.getClass().toString());
		
	}
	
	public void fixed() {

		System.out.println("Fixed method is called from the class name " + this.getClass().toString());
		
	}
	
	public void deposit() {

		System.out.println("Deposit method is called from the class name " + this.getClass().toString());
		
	}
}
