package bankaccountapp;

import java.util.Scanner;

public class BankService {
	private Scanner scan = new Scanner(System.in);
	
	public void action(Account acct) {
		try {
			System.out.print("Enter action to perform : ");
			String action = scan.nextLine();
			
			if(acct instanceof CheckingsAccount) {
				if(action.toLowerCase().contains("deposit"))
					checkingsDeposit((CheckingsAccount)acct);
				else if(action.toLowerCase().contains("withdraw"))
					checkingsWithdrawal((CheckingsAccount)acct);
				else if(action.toLowerCase().contains("transfer")) 
					transferTo((CheckingsAccount)acct);
				else
					throw new Exception("Invalid action. !!");
			}
			else if(acct instanceof SavingsAccount) {
				if(action.toLowerCase().contains("deposit"))
					savingsDeposit((SavingsAccount)acct);
				else if (action.toLowerCase().contains("withdraw"))
					savingsWithdrawal((SavingsAccount)acct);
				else if(action.toLowerCase().contains("transfer")) 
					transferTo((SavingsAccount)acct);
				else
					throw new Exception("Invalid action. !!");
			}
			else
				throw new Exception("Please enter valid account type!!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void checkingsDeposit(CheckingsAccount acct) throws Exception{
			validateDebitDetails(acct);
			
			System.out.print("Please enter amount to deposit : $");
			acct.deposit(scan.nextInt());
	}
	
	private void savingsDeposit(SavingsAccount acct)throws Exception {			
			validateSecurityBoxDetails(acct);
			
			System.out.print("Please enter amount to deposit : $");
			acct.deposit(scan.nextInt());
	}
	
	private void validateDebitDetails(CheckingsAccount acct) throws Exception {
		System.out.print("Please enter your DEBIT CARD details :"
				+ "\n Number : " );
		int cardNo = scan.nextInt();
		System.out.print(" PIN :");
		int pin = scan.nextInt();
		
		
		if(acct.getDebitCardNumber() != cardNo) {
			throw new Exception("Invalid DebitCard No. !!");
		}
		else if(acct.getDebitCardPin() != pin) {
			throw new Exception("Invalid PIN !!");
		}
		else {}
	}
	
	private void validateSecurityBoxDetails(SavingsAccount acct) throws Exception {
		System.out.print("Please enter your SECURITY DEPOSIT BOX details :"
				+ "\n NUMBER : " );
		int boxNo = scan.nextInt();
		System.out.print(" KEY :");
		int key = scan.nextInt();
		
		if(acct.getSafetyDepositBoxNumber() != boxNo) {
			throw new Exception("INVALID Box no. !!");
		}
		else if(acct.getSafetyDepositBoxKey() != key) {
			throw new Exception("INVALID key !!");
		}
		else {}
	}
	
	private void checkingsWithdrawal(CheckingsAccount acct) throws Exception {
		validateDebitDetails(acct);
		
		System.out.print("Enter amount to Withdraw : ");
		acct.withdraw(scan.nextInt());
	}
	
	private void savingsWithdrawal(SavingsAccount acct) throws Exception {
		validateSecurityBoxDetails(acct);
		
		System.out.println("Enter amount to Withdraw : ");
		acct.withdraw(scan.nextInt());
	}
	
	public boolean validateMasterDetails() {
		boolean login;
		try {
			String username, password;
			System.out.print("Welcome Back Master !! \n Please enter your Login details : "+
						"\n  USERNAME : ");
			username = scan.nextLine();
			System.out.print("  PASSWORD : ");
			password = scan.nextLine();
			
			if(!username.equals("kumaaay"))
				throw new Exception("INVALID username");
			else if(!password.equals("kumaaay"))
				throw new Exception("INVALID Password");
			
			login = true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			login = false;
		}
		return login;
	}
	
	private void transferTo(Account acct) throws Exception {
		System.out.println("Whom would you like to transfer the amount to ?");
		String str = scan.nextLine();
		Account to = BankAccountApp.getUser(str);
		if(to == null) {
			throw new Exception("User does not exist !!");
		}
		else {
			System.out.print("Enter the amount to transfer : ");
			acct.transfer(to, scan.nextInt());
		}
	}
	
}
