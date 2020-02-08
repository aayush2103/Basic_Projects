package filedemo;

import java.io.RandomAccessFile;

public class RandomaccessfileDemo {
	public static void main(String[] args) throws Exception{
		RandomAccessFile file=new RandomAccessFile("H:\\java workspace\\practice\\randomAccessFile.txt", "rw");
		file.writeUTF("Writing");
		System.out.println("Current position: "+file.getFilePointer());
		file.seek(0);
		System.out.println(file.readUTF());
		System.out.println("Current Position: "+file.getFilePointer());
		file.close();
	}
}
