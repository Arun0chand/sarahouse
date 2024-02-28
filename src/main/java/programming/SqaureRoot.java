package programming;

import java.util.Scanner;

public class SqaureRoot {
 public static void main(String[] args) {
	
	 Scanner sc=new Scanner(System.in);
	 
	 System.out.println("Enter the number");
	 int num=sc.nextInt();
	int  count=0;
	 for(int i=0;i*i<=num;i++) {
		 
		 if(i*i==num) {
			 
			  count++;
		 }
			 
			 
			 
		 }
	 if(count==1) {
		 System.out.println("Given number is perfect square"+num);
	 }else {
		 System.out.println("not perfect square");
	 }
	 }
	 }

