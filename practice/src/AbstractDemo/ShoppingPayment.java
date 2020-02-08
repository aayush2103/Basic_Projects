package AbstractDemo;

public class ShoppingPayment extends RRPaymentServices{
	private static int counter=1000;
	private String paymentId;

	public ShoppingPayment(double balance, int customerId) {
		super(balance, customerId);
	}
	public String getPaymentId() {
		return this.paymentId;
	}
	public void payBill(double amount) {
		if(amount<this.getBalance()) {
			System.out.println("Insufficient amount entered. Please try again.");
		}
		else if(amount>this.getBalance())
			System.out.println("Excess amount entered. Please try again.");
		else {
			counter++;
			this.paymentId="S"+counter;
			System.out.println("Congratulations!! Your payment of Rs."+amount+" is successfull! With payment id "
					+this.paymentId);
			this.setBalance(0);
		}
	}
}
