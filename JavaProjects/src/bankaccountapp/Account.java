package bankaccountapp;

import java.util.Random;

public abstract class Account implements IBaseRate {
	//Common properties
	private static int id = 12345;
	private String firstName;
	private String lastName;
	private int ssn;
	private String accountNo;
	private double balance;
	
	// Constructor
	public Account(String firstName, String lastName, int ssn, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.balance = balance;
		
		// Generate AccountNumber
		generateAccountNumber();
	}
	
	private void generateAccountNumber() {
		StringBuilder accntNo = new StringBuilder();
		
		// First digit based on savings or checking
		if(this instanceof CheckingsAccount) { accntNo.append("2");	}
		else if(this instanceof SavingsAccount) { accntNo.append("1");}
		
		// Next 2 digits , last 2 digits of ssn
		accntNo.append(ssn%100);
		
		// Unique 5 digit no.
		id++;
		accntNo.append(id);
		
		// Random 3 digit no.
		Random random = new Random();
		accntNo.append(random.nextInt(1000));
		
		// set account number
		this.accountNo = accntNo.toString();
	}
	
	//Common methods
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("An amount of $" + amount + "has been deposited successfully.");
		System.out.println("The updated balance is : $" + this.balance);
	}
	
	public void withdraw(double amount) {
		try {
			if(this.balance < amount) {throw new Exception("Not enough Balance!!");}
			else {
				this.balance -= amount;
				System.out.println("Withdrawal successfull!!");
				System.out.println("The updated balance is : $" + this.balance);
			}
		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
	}
	
	public void transfer(Account acc, double amount) {
		try {
			if(amount > this.balance) {
				throw new Exception("Not enough money!!");
			}
			else {
				acc.balance += amount;
				this.balance -= amount;
				System.out.println("$" + amount + "transfered to account " + acc.accountNo + " successfully!!");
				System.out.println("Your balance is $" + this.balance);
			}
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
		
	}
	
	public void showInfo() {
		System.out.println("\nCUSTOMER DETAILS :" +
				"\nName : " + this.firstName + " " + this.lastName +
				"\nSocial Security Number : " + this.ssn +
				"\nAccount Number : " + this.accountNo +
				"\nBalance : " + this.balance);
	}
	
	public String getFirstName() { return this.firstName;}
	
	public String getLastName() { return this.lastName;}
	
	public int getSsnNumber() {	return this.ssn;}
	
	public double getBalance() { return this.balance;}
}
