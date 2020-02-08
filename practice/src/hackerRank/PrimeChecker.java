package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in;
class Prime{
    
    public void checkPrime(int ...n){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n.length;i++){
            if(n[i]==1)
                continue;
            else if(n[i]==2)
                sb.append(n[i]+((i!=n.length-1)?" ":""));
            else {
                int num=2;
                boolean flag=false;
                while(num!=(n[i]/2)+1) {
                    if(n[i]%num==0) {
                        flag=true;
                        break;
                    }
                    num++;
                }
                if(!flag)
                    sb.append(n[i]+((i!=n.length-1)?" ":""));
            }
        }
        System.out.println(sb);
    }
}

public class PrimeChecker {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}