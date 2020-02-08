package arrayExamples;

import java.util.*;
import java.lang.*;
import java.io.*;

public class arrayRotationDeletion {

	public static void main (String[] args)
	 {
    	 //code
    	 Scanner in = new Scanner(System.in);
    	 int[][] array = new int[in.nextInt()][];
    	 for(int[] arr : array){
    	     arr = new int[in.nextInt()];
    	     for(int i=0; i<arr.length; i++){
	            arr[i] = in.nextInt();
	         }
    	     System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" "+arr[5]);
    	     findResult(arr);
    	 }
	 }
	 
	 public static void findResult(int[] arr){
	     int size = arr.length;
	     for(int i=1; i<=size-1; i++){
	         arr = rotateRight(arr);
	         System.out.println("roatate "+ arr[0]);
	         arr = deleteLast(arr, i);
	         //System.out.println("delete :" + arr[-1]);
	     }
	     System.out.println(arr[0]);
	 }
	 
	 public static int[] rotateRight(int[] arr){
	     int temp = arr[0];
	     arr[0] = arr[arr.length-1];
	     arr[arr.length-1] = temp;
	     return arr;
	 }
	 
	 public static int[] deleteLast(int[] arr, int k){
	     int[] newArray = new int[arr.length-1];
	     k = (0 < arr.length-k+1) ? k : 0;
	     for(int i=0; i<newArray.length; i++){
	    	 newArray[i] = arr[i];
	     }
	     return newArray;
	 }
}