package demo;

public class premiumCustomer extends customer{
	
	int i = 34;   // instance variable
	static int z; // class variable

	static {
	   z = 10;
	   System.out.println("inside static block: " + z);
	}

	  void test() {
	    int k = 200;  // local variable
	    System.out.println("local variable: " + (k + i));
	  }

	  public static void main(String[] args) {
	    premiumCustomer obj = new premiumCustomer();
	    obj.test();
	    System.out.println(obj.i);
	  }

}
