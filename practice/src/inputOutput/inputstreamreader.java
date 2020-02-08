package inputOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputstreamreader {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=null;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream("osw.txt")));
			int data=br.read();
			while(data!=-1) {
				System.out.print((char)data);
				data=br.read();
			}
		}
		catch(IOException io) {
			System.err.println("Error: "+io.getMessage());
		}
		finally {
			if(br!=null)	br.close();
		}
	}
	
}
