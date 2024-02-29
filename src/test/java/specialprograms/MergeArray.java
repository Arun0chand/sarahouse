package specialprograms;

import java.util.Arrays;

public class MergeArray {
	public static void main(String[] args) {


		int []a= {1,2,3,4,5,6};
		int b[]= {7,8,9,10,11};
        int j=0;

		int a_len=a.length;
		int b_len=b.length;
		int c_len=a_len+b_len;
		int sum[]=new int[c_len];

		for(int i=0;i<a_len;i++) {
			sum[i]=a[i];
		}
		for(int i=0;i<b_len;i++) {
			sum[(a.length+i)]=b[i];
		}
	
     System.out.println(Arrays.toString(sum));
	}

}
