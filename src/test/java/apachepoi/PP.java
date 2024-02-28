package apachepoi;

import java.util.Scanner;

public class PP {
	
	

	public void display(String str) {
	
	int vowels=0,consonanats=0;
	str=str.toLowerCase();
	
	for(int i=0;i<str.length();i++) {
		char ch=str.charAt(i);
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
			vowels++;
		}else
			consonanats++;
	}
	
	System.out.println("Print the vowels count"+vowels);
	System.out.println("Print the consonanats count"+consonanats);
	}	
	
	public static void main(String [] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String str=sc.nextLine();
		sc.close();
		PP p=new PP();
		p.display(str);
		
	}
	
}













