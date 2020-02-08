package demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Map_Demo {
	
	public static void main(String[] args){
		
		Map<Integer, String> map1=new HashMap<>();
		map1.put(1, "Aayush");
		map1.put(2, "Kumar");
		map1.put(3, "Patel");
		map1.put(4, "Shantam");
		map1.put(1, "Satyam");
		
		System.out.println(map1);
		
		for(Integer i: map1.keySet()) {
			System.out.println("Key: "+i+" value: "+map1.get(i));
		}
		
		Set set1=new TreeSet<>();
		set1.add("f");
		set1.add("b");
		set1.add("e");
		set1.add("Z");
		set1.add("d");
		set1.add("E");
		
		System.out.println(set1);
	}
}
