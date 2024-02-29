package Testingpack;

public class RemoveDuplicate {
    public static void main(String[] args) {

        String str = "Hello Hello World";

      str=str.toLowerCase().replace(" ", "");
      
      String result="";
      
      for(int i=0;i<str.length();i++) {
    	  
    	  char ch=str.charAt(i);
    	  boolean duplicate=false;
    	  
    	 for(int j=i+1;j<str.length();j++) {
    		
    		 if(str.charAt(j)==ch) {
    			 duplicate=true;
    			 break;
    		 }
    	 }
    	 for(int k=0;k<i;k++) {
    		 
    		 if(str.charAt(k)==ch) {
    			 duplicate=false;
    			 break;
    		 }
    	 }
    	 
    	 if(duplicate) {
    		 
    		 System.out.print(ch+" ");
    	 }
    }
}
}

