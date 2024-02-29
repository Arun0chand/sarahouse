package apachepoi;

import java.util.Arrays;

public class RemoveDuplicateNumbers {
	public static void main(String[] args) {
		
		
	int[]arr= {1,2,2,3,3,4,5,6,7,6};
	Arrays.sort(arr);
	int len=arr.length;
	int temp[]=new int[arr.length];
	int j=0;
	
	for(int i=0;i<len-1;i++) {
		if(arr[i]!=arr[i+1]) {
			temp[j++]=arr[i];
		}
	}
	temp[j++]=arr[len-1];
	//int[] result = new int[j];
	/*
	 * for (int k = 0; k < j; k++) { //System.out.println(temp[k]);
	 * result[k]=temp[k]; }
	 */
	
	int [] unique=Arrays.copyOf(temp, j);
	System.out.println(Arrays.toString(unique));
	}

}
