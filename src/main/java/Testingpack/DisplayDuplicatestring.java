package Testingpack;

import java.util.Arrays;

public class DisplayDuplicatestring
{
	public static void main(String[]args)
	{
		String str="Hello Hello world";
         
		str=str.toLowerCase().replace(" ", "");
		
		boolean duplicate=false;
		System.out.println("Display the duplicate characters");
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			
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
				
				System.out.print(ch);
			}
		}
	}
}
















