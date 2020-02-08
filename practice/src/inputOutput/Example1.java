package inputOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;

public class Example1 {
	
	public static void main(String[] args) throws IOException{
		
		//read marks data from files term1 and term2 and add and write it in result file
		
		Reader inFile=null;
		Writer outFile=null;
		HashMap<String,Integer> mapp=new HashMap<>(); 
		
		try {
			String files[]= {"term1.txt", "term2.txt"};
			for(String i: files) {
				//read operation
				inFile=new FileReader(i);
				int val =inFile.read();
				StringBuilder sb=new StringBuilder("");
				boolean flag=true;
				while(flag) {
					//for continuous line
					if(val!='\n' && val!=-1) {
						sb.append((char)val);
						val=inFile.read();
					}
					//before newline
					else {
						//stop reading
						if(val==-1)
							flag=false;
						String str=sb.toString();
						//store subject name and marks in array
						String str1[]=str.split(":");
						Integer t;
						//trim to remove newline character
						str1[1]=str1[1].trim();
						//add if present before
						if((t=mapp.get(str1[0]))!=null)
							mapp.put(str1[0],t+Integer.parseInt(str1[1]));
						else
							mapp.put(str1[0],Integer.parseInt(str1[1]));
						//clear sb
						sb=new StringBuilder("");
						val=inFile.read();
					}
				}
			}
			//write operation
			outFile=new FileWriter("result.txt");
			for(String str: mapp.keySet()) {
				outFile.write(str+":");
				String val=String.valueOf(mapp.get(str));
				outFile.write(val);
				String newLine=System.getProperty("line.separator");
				outFile.write(newLine);
			}
		}
		catch(IOException io) {
			System.out.println("some error occured");
		}
		finally {
			if(inFile!=null)	inFile.close();
			if(outFile!=null)	outFile.close();
		}
		
	}
	
}
