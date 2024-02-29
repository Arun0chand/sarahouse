package apachepoi;

import java.util.Scanner;

public class VowelsAndConso {
	
	
	public void count(String str) {
		int vowels=0,consonanats=0;
		 str=str.toLowerCase().replace(" ", "");
		 for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				vowels++;
			}else {
				consonanats++;
			}
		 }
		 System.out.println("vowels count"+vowels);
		 System.out.println("Conso count"+consonanats);
	}
	
	public static void main(String args[]) {
		
		VowelsAndConso vs=new VowelsAndConso();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();
		System.out.println(str);
		//sc.close();
		vs.count(str);
		
		
	}

}
