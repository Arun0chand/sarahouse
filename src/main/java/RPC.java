import java.util.HashMap;
import java.util.Map;

public class RPC {
    public static void main(String[] args) {
     
    	String str="Hello ";
    	str=str.toLowerCase();
    	
    	int [] charcount=new int[256];
    	
    	for(int i=0;i<str.length();i++) {
    		
    	char ch=str.charAt(i);
    	
    	if(ch!=' ') {
    		charcount[ch]++;
    	}
    	}
    	System.out.println();
    	System.out.println("Repeated characters and there count");
    	
    	for(int i=0;i<charcount.length;i++) {
    		
    		if(charcount[i]>1) {
    			
    			System.out.println("'" +(char)i+ "'"+"repeated--"+charcount[i]+"times");
    		}
    	}
    }
}
