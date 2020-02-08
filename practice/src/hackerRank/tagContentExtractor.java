package hackerRank;

//tag-content-extractor.pdf

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class tagContentExtractor {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
			
			//recurse(line);
			boolean flag=false;
			Pattern p=Pattern.compile("<(.+)>([^<]+)</\\1>");
			Matcher m=p.matcher(line);
			
			while(m.find()) {
				System.out.println(m.group(2));
				flag=true;
			}
			if(!flag) {
				System.out.println("None");
			}
			testCases--;
		}
		in.close();
	}
//	public static int recurse(String str) {
//		int a=0;
//		String str1="",str2="",str3="";
//		for(int i=0;i<str.length();i++) {
//			if(str.charAt(i)=='<') {
//				int j=++i;
//				while(str.charAt(i)!='>') {
//					i++;
//				}
//				str1=str.substring(j,i);
//				if(str.charAt(++i)=='<')
//					i=i+recurse(str.substring(i,str.length()));
//				j=++i;
//				while(str.charAt(i)!='<' && str.charAt(i+1)!='/') {
//					i++;
//				}
//				str2=str.substring(j,i);
//				i=i+2;
//				j=i;
//				while(str.charAt(i)!='>')
//					++i;
//				str3=str.substring(j,i);
//				System.out.println("str : "+ str);
//				System.out.println("str1 : "+str1);
//				if(str1.equals(str3) && !str2.isEmpty())
//					System.out.println(str2);
//				else if(!str2.isEmpty())
//					System.out.println("None");
//				a=i;
//			}	
//			break;
//		}
//		return a;
//	}
}