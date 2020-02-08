package bankaccountapp;

import java.util.Random;

public class SavingsAccount extends Account {
	// Savings Account properties
	private int safetyDepositBox;
	private int safetyDepositBoxKey;
	
	// Constructor
	public SavingsAccount(String firstName, String lastName, int ssn, double initialDeposit) {
		super(firstName, lastName, ssn, initialDeposit);
		
		// Generate safety deposit box
		generateSafetyDepositBoxDetails();
	}
	
	private void generateSafetyDepositBoxDetails() {
		Random random = new Random();
		this.safetyDepositBox = random.nextInt(1000);
		this.safetyDepositBoxKey = random.nextInt(10000);
	}
	
	public int getSafetyDepositBoxNumber() {
		return this.safetyDepositBox;
	}
	
	public int getSafetyDepositBoxKey() {
		return this.safetyDepositBoxKey;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Safety Deposit Box Details are : " +
				"\nSafetyDepositBox Number : " + this.safetyDepositBox + 
				"\nSafetyDepositBoxKEY : " + this.safetyDepositBoxKey);
	}
}
