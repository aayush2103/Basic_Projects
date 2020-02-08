package bankaccountapp;

import java.util.Random;
import java.util.Scanner;

public class CheckingsAccount extends Account {
	// Checking Account Properties
	private int debitCardNumber;
	private int debitCardPin;
	
	// Constructor
	public CheckingsAccount(String firstName, String lastName, int ssn, double initialDeposit) {
		super(firstName, lastName, ssn, initialDeposit);
		
		// Generate debit card no. and pin
		generateDebitCardDetails();
	}
	
	private void generateDebitCardDetails() {
		Random random = new Random();
		this.debitCardNumber = random.nextInt((int)Math.pow(10, 12));
		this.debitCardPin = random.nextInt(10000);
	}
	
	public int getDebitCardNumber() {
		return this.debitCardNumber;
	}
	
	public int getDebitCardPin() {
		return this.debitCardPin;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Debit Card Details are as follows : " +
				"\nDebit Card Number : " + this.debitCardNumber + 
				"\nDebit Card PIN : " + this.debitCardPin);
	}
}
