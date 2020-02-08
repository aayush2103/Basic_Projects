package hackerRank;

import java.util.Scanner;

public class Subarray {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[] arr=new int[scan.nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i]=scan.nextInt();
		}
		scan.close();
		
		int count=0;
		for(int n=1;n<=arr.length;n++) {
			for(int i=0;i<arr.length;i++) {
				int a=0,sum=0;
				while(a<n && (i+a)<arr.length && i<=arr.length-n) {
					sum+=arr[i+a];
					a++;
				}
				if(sum<0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
