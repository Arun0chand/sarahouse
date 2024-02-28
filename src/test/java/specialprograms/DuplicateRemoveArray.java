package specialprograms;

import java.util.Arrays;

public class DuplicateRemoveArray {
	
	public static void main(String[] args) {
		
		
		int arr[]= {2,2,23,3,3,4,4,4,288,288,99,1,1};
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
