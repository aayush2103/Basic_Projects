package inputOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileStreamTester {
	public static void main(String[] args) throws IOException{
		Reader inFile=null;
		Writer outFile=null;
		try {
			inFile=new FileReader("demo1.txt");
			outFile=new FileWriter("demo2.txt");
			
			int i= inFile.read();
			
			while(i!=-1) {
				outFile.write((char)i);
				i=inFile.read();
			}
		}
		catch(IOException io) {
			System.out.println("Some error occured");
		}
		finally {
			if (inFile!=null)	inFile.close();
			if (outFile!=null)	outFile.close();
		}
	}
}
