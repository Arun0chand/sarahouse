package Testingpack;

import java.util.Scanner;

public class RemoveVowels {
 public static void main(String[] args) {
	
	 
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the String");
	 RemoveVowels rm=new RemoveVowels();
	 String str=sc.nextLine();
	 rm.rVowels(str);
 }
	 public void rVowels(String str) {
		 str=str.toLowerCase() ;
		 String str1="";
		  for(int i=0;i<str.length();i++) {
			  
			  char ch=str.charAt(i);
			  if(!(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')){
				  
				 str1=(str1+ch); 
			  }
		  }
		  
		 
		  System.out.println(str1); 
	 }
	 
}

