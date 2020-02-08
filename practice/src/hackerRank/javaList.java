package hackerRank;

import java.util.*;

public class javaList {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan=new Scanner(System.in);
		List<Integer> list=new ArrayList<>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			list.add(scan.nextInt());
		}
		int x,y;
		String op;
		int q=scan.nextInt();
		for(int i=0;i<q;i++) {
			//scan.nextLine();
			op=scan.next();//op=scan.nextLine();
			if(op.equals("Insert")) {
				x=scan.nextInt();
				y=scan.nextInt();
				list.add(x,y);
			}
			else if(op.equals("Delete")) {
				x=scan.nextInt();
				list.remove(x);
			}
		}
		for(Integer i : list) {
			System.out.print(i+" ");
		}
		scan.close();
	}

}

