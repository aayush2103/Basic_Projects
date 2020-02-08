package hackerRank;

import java.util.*;

public class javaMap {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Map<String, Integer> dir=new HashMap<>();
		int n=in.nextInt();
		for(int i=0;i<n;i++)
		{
			in.nextLine();
			dir.put(in.nextLine(), in.nextInt());
		}
		String s="";
		in.nextLine();
		while(in.hasNext())
		{
			s=in.nextLine();
			Integer num=dir.get(s);
			if(num!=null) 
				System.out.println(s+"="+num);
			else
				System.out.println("Not found");
		}
		in.close();
	}

}