package filedemo;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) throws Exception{
		File file=new File("H:\\java workspace\\practice\\filedemo1.txt");
		Boolean isCreated=file.createNewFile();
		System.out.println("File created: "+isCreated);
		System.out.println("File name: "+file.getName());
		System.out.println("Path of the file: "+file.getPath());
		System.out.println("is directory: "+file.isDirectory());
		System.out.println("list: "+file.list());
	}
}
