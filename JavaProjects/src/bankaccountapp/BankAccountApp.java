package bankaccountapp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankAccountApp {

	private static List<Account> users = new LinkedList<Account>();
	private static String file = "H:\\java workspace\\JavaProjects\\src\\NewBankAccounts.csv";
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BankService service = new BankService();
		if(service.validateMasterDetails()) {
		
			users.add(new CheckingsAccount("Aayush", "Kumar", 444555223, 1500));		
			users.add(new SavingsAccount("Yash", "Raj", 444555224, 2000));
			loadCustomers();
			
			//chk1.showInfo();
			//sav1.showInfo();
			
			/*chk1.deposit(2000);
			chk1.withdraw(3000);
			sav1.withdraw(3000);
			
			sav1.transfer(chk1, 3000);
			System.out.println(chk1.getBalance());
			
			//service.deposit(chk1);*/
			
			Account acct = users.get(0);
			System.out.println("\nHi Aayush" + ", what would you like to do ?");
			String str;
			while(true) {
				str = scan.nextLine();
				if(str.contains("quit") || str.contains("no")) {
					System.out.println("Thankyou for visiting us." +
							"\nHave a great day !! :)");
					break;
				}
				else if(str.toLowerCase().contains("new user"))
					addNewUser();
				else if(str.toLowerCase().contains("login")) {
					acct = getUser(str);
					if(acct != null) {
						System.out.println("Logged in as " + acct.getFirstName());
					}
					else
						System.out.println("INVALID USER !!");
				}
				else if(str.toLowerCase().contains("show details"))
					acct.showInfo();
				else if(str.toLowerCase().contains("user list"))
					getAllUsers();
				else if(str.contains("action"))
					service.action(acct);
				else
					System.out.println("Sorry, did not get u !");
					
				System.out.println("\nWould you like me to help you out with anything else ?");
			}
		}
		else
			System.out.println("TRY AGAIN !!");
		scan.close();
	}
	
	private static void addNewUser() {
		Scanner scan = new Scanner(System.in);
		String firstName, lastName, accountType;
		int ssn;
		double initialDeposit;
		Account acct;
		
		System.out.print("\nEnter Details : \n FirstName : ");
		firstName = scan.nextLine();
		System.out.print(" LastName : ");
		lastName = scan.nextLine();
		System.out.print(" Account Type : ");
		accountType = scan.nextLine();
		System.out.print(" SSN : ");
		ssn = scan.nextInt();
		System.out.print(" InitialDeposit : ");
		initialDeposit = scan.nextDouble();
		System.out.println("\nNew user successfully created. !!");
		
		if(accountType.toLowerCase().equals("checkings")) {
			acct = new CheckingsAccount(firstName, lastName, ssn, initialDeposit);
			acct.showInfo();
			users.add(acct);
		}
		else if (accountType.toLowerCase().equals("savings")) {
			acct = new SavingsAccount(firstName, lastName, ssn, initialDeposit);
			acct.showInfo();
			users.add(acct);
		}
		else
			System.out.println("INVALID ACCOUNT TYPE." +
					"\n Please try again.");
	}
	
	public static Account getUser(String str) {
		Account acct = null;
		String name;
		for(Account acnt : users) {
			name = acnt.getFirstName().toLowerCase() + " " +
					acnt.getLastName().toLowerCase();
			if(str.toLowerCase().contains(name)) {
				acct = acnt;
				break;
			}
		}
		return acct;
	}
	
	private static void getAllUsers() {
		for(Account acct : users) {
			System.out.println(acct.getFirstName() + " " + acct.getLastName());
		}
	}
	
	private static void loadCustomers() {
		List<String[]> newAccountHolders = CSVReader.read(file);
		String name[], firstName, lastName, ssn, accountType, initialdeposit;
		
		for(String[] accountHolder : newAccountHolders) {
			name = accountHolder[0].split(" ");
			firstName = name[0];
			lastName = name[1];
			ssn = accountHolder[1];
			accountType = accountHolder[2];
			initialdeposit = accountHolder[3];
			
			if(accountType.toLowerCase().equals("checking"))
				users.add(new CheckingsAccount(firstName, lastName, Integer.parseInt(ssn),
						Double.parseDouble(initialdeposit)));
			else if(accountType.toLowerCase().equals("savings"))
				users.add(new SavingsAccount(firstName, lastName, Integer.parseInt(ssn),
						Double.parseDouble(initialdeposit)));
			
			System.out.println(name);
		}
		
		System.out.println("ALL CUSTOMERS LOADED !!");
	}
}
