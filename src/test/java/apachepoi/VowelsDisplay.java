package apachepoi;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.testng.reporters.jq.Main;

public class VowelsDisplay{

	public static void count(String str) {
		int vowels=0,consonanats=0;
		str=str.toLowerCase().replace(" ", "");
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				vowels++;
			}else {
				consonanats++;
			}
		}
		System.out.println("Vowels count"+vowels);
		System.out.println("Consonanats count"+consonanats);
		
	
	 
	
 }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.nextLine();
		count(str);
	}
}

