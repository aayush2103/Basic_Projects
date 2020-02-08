package hackerRank;

import java.util.*;

public class javaStack {
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> list=new LinkedList<>();
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
			if(input.length()%2!=0) {
				System.out.println("false");
				continue;
			}
			list.add(input.charAt(0));
			for(int i=1;i<input.length();i++) {
				if(list.isEmpty()) {
					//System.out.println("adding ");
					list.add(input.charAt(i++));
				}
				char c=list.get(0);
				char c1=input.charAt(i);
				//System.out.print("c : "+c+" c1 : "+c1);
				if((c=='{' && c1=='}') || (c=='(' && c1==')') || (c=='[' && c1==']')) { 
					//System.out.print(" match ");
					list.pop();
				}
				else {
					//System.out.println(" no match ");
					list.addFirst(c1);
				}
			}
			if(list.isEmpty())
				System.out.println("true");
			else {
				list.clear();
				System.out.println("false");
			}
		}
		sc.close();
	}
}
