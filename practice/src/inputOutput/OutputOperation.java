package inputOutput;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputOperation {
	
	public static void main(String[] args) throws IOException{
		FileOutputStream outFile=new FileOutputStream("demo1.txt");
		String data="aayush kumar shantam satyam shubhayu harsh yash elesh";
		//String data="";
		byte bArray[]=data.getBytes();
		outFile.write(bArray);
		outFile.close();
	}
	
}
