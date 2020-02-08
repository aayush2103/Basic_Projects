package comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tester {
	
	public static void main(String[] args) {
		
		List<Student> list1=new ArrayList<>();
		
		list1.add(new Student(120, "Aayush"));
		list1.add(new Student(110, "Patel"));
		list1.add(new Student(121, "Shantam"));
		list1.add(new Student(115, "Harsh"));
		list1.add(new Student(105, "Yash"));
		
		Collections.sort(list1);
		System.out.println(list1);
		
		//Collections.so
		//System.out.println(list1);
	}
	
}
