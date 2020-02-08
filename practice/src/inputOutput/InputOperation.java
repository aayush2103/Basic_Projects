package inputOutput;

import java.io.FileInputStream;
import java.io.IOException;

public class InputOperation {
	
	public static void main(String[] args) throws IOException{
		
		FileInputStream inFile=new FileInputStream("demo1.txt");
		int i =inFile.read();
		while(i!=-1) {
			System.out.print((char)i);
			i=inFile.read();
		}
		//System.out.println(i);
		inFile.close();
		
	}
	
}
