package apachepoi;

import java.util.Scanner;

public class CapitalAndSmall {

	public void display(String str) {
		int vowels=0,consonants=0;
		 str=str.toLowerCase().replace(" ", "");
		 for(int i=0;i<str.length();i++) {
			 
			 char ch=str.charAt(i);
			 if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				 vowels++;
			 }else
				 consonants++;
		 }
		 
		 System.out.println("Vowels count"+vowels);
		 System.out.println("Consonanats count"+consonants);
		 
	}	
		
	
	
	public static void main(String []args) {
		CapitalAndSmall cs=new CapitalAndSmall();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.nextLine();
		
		cs.display(str);
	}

}


