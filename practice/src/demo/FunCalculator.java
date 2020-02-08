package demo;

public class FunCalculator {
	
	public static String isArmstrong(int a) {
		int result=0;
		int val=a;
		while(val!=0) {
			result +=Math.pow(val%10,3);
			val/=10;
		}
		if(result==a)
			return "The number "+a+" is an Armstrong number";
		return "The number "+a+" is not an Armstrong number";
	}
	
	public static String isLucky(int a) {
		int result=0;
		int val=a;
		while(val!=0) {
			result+=Math.pow(val%10,2);
			val/=100;
		}
		if(result%9==0)
			return "The number "+a+" is a Lucky number";
		return "The number "+a+" is not a Lucky number";
	}
	
	public static void main(String[] args) {
		int a=1623;
		int choice=3;
		System.out.println("1. Calculate Armstrong \n2. Calculate Lucky Number");
		String str=null;
		switch(choice) {
		case 1:
			System.out.println("Your Choice is "+choice);
			str=FunCalculator.isArmstrong(a);
			break;
		case 2:
			System.out.println("Your Choice is "+choice);
			str=FunCalculator.isLucky(a);
			break;
		default:
			System.out.println("Oops! Invalid Choice!");
		}
		if(str!=null)
			System.out.println(str);
	}
}
