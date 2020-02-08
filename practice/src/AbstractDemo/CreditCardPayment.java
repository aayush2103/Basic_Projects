package AbstractDemo;

public class CreditCardPayment extends RRPaymentServices{
	private static int counter=1000;
	private String paymentId;
	private double cashBack;
	private double balanceDue;
	
	public CreditCardPayment(double balance, int customerId) {
		super(balance, customerId);
		this.balanceDue=balance;
	}
	public void payBill(double amount) {
		counter++;
		this.paymentId="C"+counter;
		
		if (amount>this.balanceDue) {
			this.cashBack=amount-this.balanceDue;
			this.balanceDue=0;
		}
		else if(amount<this.getBalance()) {
			this.balanceDue-=amount;
		}
		System.out.println("Congratulations!! You have successfully made a payment of Rs."+amount+" .Payment"
				+ " details are-");
		System.out.println("************************************************************************************");
		System.out.println("Customer Id                   :"+this.getCustomerId());
		System.out.println("payment Id                    :"+this.getPaymentId());
		System.out.println("previous due                  :Rs."+this.getBalance());
		System.out.println("Remaining Due                 :Rs."+this.balanceDue);
		System.out.println("Cashback wallet balance       :Rs."+this.cashBack);
	}
	public static int getCounter() {
		return counter;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public double getCashBack() {
		return cashBack;
	}
	public double getBalanceDue() {
		return balanceDue;
	}
	
}
