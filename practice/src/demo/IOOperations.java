package demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class IOOperations {

	public static void main(String[] args) throws IOException{
		
		Reader ifile=new FileReader("demo1.txt");
		Writer ofile=new FileWriter("demo2.txt");
		int i =ifile.read();
		StringBuilder sb=new StringBuilder("");
		while(i!='\n') {
			sb.append((char)i);
			i=ifile.read();
		}
		String str=sb.toString();
		String[] str1=str.split(":");
		System.out.println(sb);
		sb.delete(0,sb.length()-1);
		System.out.println();
		//System.out.println(sb);
		System.out.println(str1[1].trim()+str1[0]);
		ifile.close();
		ofile.close();
		
	}
	
}
