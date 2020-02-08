package hackerRank;

import java.math.BigDecimal;
import java.util.*;

public class bigdecimal {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, 0, n, new Comparator<String>() {
        	@Override
        	public int compare(String a1, String b1) {
        		//converting to BigDecimal inside compare method to preserve the string value in code
        		BigDecimal a=new BigDecimal(a1);
        		BigDecimal b=new BigDecimal(b1);
        		//descending order
        		return b.compareTo(a);
        	}
        });
        
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}