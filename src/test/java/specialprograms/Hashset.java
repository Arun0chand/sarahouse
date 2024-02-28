package specialprograms;

import java.util.Arrays;
import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
		int [] arr= {1,13,13,23,54,56,54,12,12};
		Arrays.sort(arr);
		int temp[]=new int[arr.length];
		int j=0;
		
		for(int i=0;i<arr.length-1;i++) {
			
			if(arr[i]!=arr[i+1]) {
				temp[j]=arr[i];
				j++;
			}
		}
		temp[j++]=arr[arr.length-1];
		int result[]=new int[j];
		for(int k=0;k<j;k++) {
			result[k]=temp[k];
		}
		System.out.println(Arrays.toString(result));
	}

}


