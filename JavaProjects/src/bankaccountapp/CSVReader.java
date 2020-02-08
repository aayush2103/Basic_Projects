package bankaccountapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVReader {
	
	public static List<String[]> read(String file){
		List<String[]> data = new LinkedList<>();
		BufferedReader buffer;
		String dataLine;
		try {
			buffer = new BufferedReader(new FileReader(file));
			while((dataLine = buffer.readLine()) != null) {
				data.add(dataLine.split(","));
			}
		}catch(FileNotFoundException e1) {
			System.out.println("COULD NOT LOAD FILE");
			e1.printStackTrace();			
		}catch(IOException e2) {
			System.out.println("COULD NOT READ FILE");
			e2.printStackTrace();
		}
		return data;
	}
	
}
