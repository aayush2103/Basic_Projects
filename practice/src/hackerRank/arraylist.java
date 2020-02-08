package hackerRank;

//java-arraylist.pdf

import java.util.*;

public class arraylist {
	
	private static final Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.*/
		
		int n=Integer.parseInt(scan.nextLine());
		List<String[]> list=new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			list.add(scan.nextLine().split(" "));
		}
		int q=Integer.parseInt(scan.nextLine());

		for(int i=0;i<q;i++) {
			String[] str=scan.nextLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			try {
				String[] values=list.get(a-1);
				System.out.println(values[b]);
			}
			catch(Exception e) {
				System.out.println("ERROR!");
			}
			
		}
    }
}

//import java.util.*;
//
//public class arraylist {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
//        
//        for (int i = 0; i < n; i++) {
//            int d = in.nextInt();
//            ArrayList<Integer> row = new ArrayList<>();
//            
//            for (int j = 0; j < d; j++) {
//                row.add(in.nextInt());
//            }
//            
//            rows.add(row);
//        }
//        
//        int q = in.nextInt();
//        
//        for (int i = 0; i < q; i++) {
//            int x = in.nextInt();
//            int y = in.nextInt();
//            
//            try {
//                System.out.println(rows.get(x - 1).get(y - 1));
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("ERROR!");
//            }
//        }
//    }
//}
