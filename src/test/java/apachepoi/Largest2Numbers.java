package apachepoi;

import java.util.Scanner;

public class Largest2Numbers {
	
	public static void main(String[] args) {
		int temp,small;
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter the first number");
		int a=sc.nextInt();
		System.out.println("Enter the 2 number");
		int b=sc.nextInt();
		System.out.println("Enter the 3rd number");
		int c=sc.nextInt();
		
		temp=a<b?a:b;
		small=temp<c?temp:c;
		System.out.println("Print the largest number"+small);
		
		
	}
}
