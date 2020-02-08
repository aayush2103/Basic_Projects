package hackerRank;

import java.io.*;
import java.util.*;

public class BitSetDemo {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan=new Scanner(System.in);
		int n = scan.nextInt();
		BitSet b1=new BitSet(n);
		BitSet b2=new BitSet(n);
		BitSet[] arr= {b1, b2};
		int m=scan.nextInt();
		for(int i=0;i<m;i++) {
			switch(scan.next()) {
				case "AND":
					arr[scan.nextInt()-1].and(arr[scan.nextInt()-1]);
					break;
				case "OR":
					arr[scan.nextInt()-1].or(arr[scan.nextInt()-1]);
					break;
				case "XOR":
					arr[scan.nextInt()-1].xor(arr[scan.nextInt()-1]);
					break;
				case "FLIP":
					arr[scan.nextInt()-1].flip(scan.nextInt());
					break;
				case "SET":
					arr[scan.nextInt()-1].set(scan.nextInt());
			}
			System.out.println(b1.cardinality()+" "+b2.cardinality());
		}
		scan.close();
	}
}

