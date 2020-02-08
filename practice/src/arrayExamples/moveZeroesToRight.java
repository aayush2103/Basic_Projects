package arrayExamples;

import java.util.Arrays;
import java.util.Scanner;

public class moveZeroesToRight {
//	public static void main(String[] args) {
//		int[] array = new int[]{1,2,0,4,3,0,5,0};
//		int[] newArray = new int[array.length];
//		int j = 0;
//		for(int i=0; i<array.length; i++) {
//			if(array[i] != 0) {
//				newArray[j++] = array[i];
//			}
//		}
//		System.out.println(Arrays.toString(newArray));
//	}
	public static void main (String[] args)
	{
	    //code
	    Scanner in = new Scanner(System.in);
	    int[][] arrays = new int[in.nextInt()][];
	    System.out.println(arrays.length);
	    for(int j=0; j<arrays.length; j++){
	        arrays[j] = new int[in.nextInt()];
	        for(int i=0; i<arrays[j].length; i++){
	            arrays[j][i] = in.nextInt();
	        }
	    }
	    
	    for(int[] arr : arrays){
	        arrangeArray(arr);
	        System.out.println(Arrays.toString(arr));
	    }
	    in.close();
	}
	
	public static void arrangeArray(int[] arr){
	    int i=0;
	    int[] newArr = new int[arr.length];
	    for(int j=0; j<arr.length; j++){
	        if(arr[j] != 0){
	            newArr[i++] = arr[j];
	        }
	    }
	    arr = newArr;
	}
}
