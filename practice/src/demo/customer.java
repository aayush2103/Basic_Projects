package demo;

public class customer{
	private double balance;
	static int b=90;
	
	public double getBalance(int accntId){
		return balance;
	}
	
	public static void main(String args[]){
		customer acc=new customer();
		customer cu=new customer();
		Integer a=null;
		System.out.println("The balance is: "+cu.b);
	}
}
