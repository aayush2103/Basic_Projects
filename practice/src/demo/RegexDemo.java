package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	
	public static void main(String[] args) {
		
		boolean b=validate("Tom*Jerry");
		System.out.println(b);
		
	}
	
	public static boolean validate(String mobileNumber) {
		
		Pattern regex=Pattern.compile("[A-Za-z1-9]+[_.]?[A-Za-z1-9]+@[a-z]+[.](com|co.in)");
		Matcher mobileMatcher=regex.matcher(mobileNumber);
		return mobileMatcher.matches();
		
//		return mobileNumber.matches("\\d{3}-\\d{3}-\\d{4}");
		
	}
	
}
