package emailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength=10;
	private String department;
	private int mailboxCapacity = 500;
	private String email;
	private String alternateEmail;
	
	//Constructor to receive last and first name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created for new worker : " + this.firstName + " " +this.lastName);
		
		//Call method to set department name
		this.department = setDepartment();
		System.out.println("Department : " + this.department);
		
		//Call method to generate Random Password
		this.password = setRandomPassword(this.defaultPasswordLength);
		System.out.println("Password is : " + this.password);
		
		//Generate Email Address
		this.email = this.firstName.toLowerCase() + "." +this.lastName.toLowerCase() + "@" + this.department + ".abccompany.com";
		System.out.println("Email : " + this.email);
	}
	
	//Ask for the department
	private String setDepartment() {
		Scanner in = new Scanner(System.in);
		System.out.print("Department codes :\n1 for sales\n2 for dev\n3 for accounting\n0 for none\nDepartment Code : ");
		int deptCode = in.nextInt();
		in.close();
		
		if(deptCode == 1) { return "sales"; }
		else if (deptCode == 2) { return "dev"; }
		else if (deptCode == 3) { return "acnt"; }
		else { return ""; }
	}
	
	//Generate a random password
	private String setRandomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$&_-";
		char[] password = new char[length];
		for(int i =0; i<length; i++) {
			int index = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(index);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int length) {
		this.mailboxCapacity = length;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	public void setPassword(String password) {
		this.password = password;
	}
	
	//GetEmail
	public String getEmail() {
		return this.email;
	}
	
	//get alternate email
	public String getAlternateEmail() {
		return this.alternateEmail;
	}
	
	//get mailbox capacity
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}
	
	//Display info
	public void showInfo() {
		System.out.println();
		System.out.println("Employee details - ");
		System.out.println("FirstName : " + this.firstName);
		System.out.println("LastName : " + this.lastName);
		System.out.println("Department : " + this.department);
		System.out.println("EmailAddress : " + this.email);
		
	}
}
