package demo;

class CustomerDetail{
	public static boolean validateCustomer(int customerId){
		//implementation for validating 
		return false;
	}
	//@Deprecated
	public static boolean validateCustomer(String name){
		//implementation for validating 
		return false;
	}
}

public class DeprecatedDemo {

	public static void main(String[] args){
		String custName = "John Taylor";
		boolean value = CustomerDetail.validateCustomer(custName); //line 1
		if(value){
			System.out.println("John Taylor is a valid customer");
		}else{
			System.out.println("John Taylor is an invalid customer");
		}
	}
}