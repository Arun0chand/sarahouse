package Testingpack;

import java.util.Arrays;

public class testdemo {

	
	public static void main(String[] args) {
		
		String str="madamerr";
		
		String rev="";
		
		for(int i=str.length()-1;i>=0;i--) {
			
			char ch=str.charAt(i);
			rev=rev+ch;
		}
		System.out.println(rev);
		if(str.equals(rev)) {
			
			System.out.println("Palindrome");
		}else {
			
			System.out.println("Not a plaindrome");
		}
}
}