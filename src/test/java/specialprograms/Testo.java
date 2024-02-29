package specialprograms;



import java.util.Arrays;

public class Testo {
	
	 public static void main(String[] args) {

        String[] arr = {"arun", "Somesh", "oops", "somesh", "opps", "oops"};
       int len=arr.length;
        String [] result=new String[len];
        int k=0;
        boolean isDuplicate;
        
        
        for(int i=0;i<len;i++) {
        	isDuplicate=false;
        	for(int j=0;j<k;j++) {
        		if(arr[i].toLowerCase().equals(result[j])) {
        			isDuplicate=true;
        			break;
        		}
        		
        		}
        	 if(!isDuplicate) {
        		 result[k++] = arr[i].toLowerCase();
        	}
       
        	
        }
        String[] uniqueStrings = Arrays.copyOf(result, k);
        System.out.println(Arrays.toString(uniqueStrings));
    }
}

