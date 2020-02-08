package demo;

interface AfterSale{
	public abstract double chargeOnDelivery();
	public default double discount() {
		return 0.0;
	}
	public static void issueGift() {
		//impl
	}
}
abstract class Customer1 implements AfterSale{
	public double calculatePurchaseAmount() {
		discount();
		return 0.0;
	}
}
class RegularCustomer extends Customer1{
	@Override
	public double chargeOnDelivery() {
		AfterSale.issueGift();
		return 0.0;
	}
}
class PriviledgedCustomer extends Customer1{
	@Override
	public double chargeOnDelivery(){
		AfterSale.issueGift();
		return 0.0;
	}
	public double discount() {
		System.out.println("inside priviledged customer");
		return 1.0;
	}
}
public class DefaultDemo {

}
