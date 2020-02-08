package hackerRank;

//java-string-tokens-English.pdf
import java.io.*;
import java.util.*;

public class tokens {
	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String str = scan.nextLine();
	        // Write your code here.
	        scan.close();
	        str=str.trim();
	        if(str.equals(""))
	        	System.out.println(0);
	        else {
	        	String[] tokens=str.split("[ ?!.,'_@]+");
	        	System.out.println(tokens.length);
	        	for(String s:tokens)
	        		System.out.println(s);
	        }
	    }
}



