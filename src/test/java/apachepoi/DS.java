package apachepoi;

import java.util.Arrays;

public class DS {
	
	public static void main(String[] args) {
		
	
	
		String [] arr= {"arun","Arun","sachin","Sachin","Daku","Chachu"};
		int len=arr.length;
		String [] result=new String[len];
		int k=0;
		boolean isDisplayed;
		
		for(int i=0;i<len;i++) {
			isDisplayed=false;
			for(int j=0;j<k;j++) {
				if(arr[i].toLowerCase().equals(result[j])) {
					isDisplayed=true;
					break;
				}
			}
			if(!isDisplayed) {
				result[k++]=arr[i].toLowerCase();
			}
		}
		String[] uniqestring=Arrays.copyOf(result, k);
		System.out.println(Arrays.toString(uniqestring));
		
		
	}

}
