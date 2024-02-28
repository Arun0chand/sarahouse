package Testingpack;



public class StarP1 {
public static void main(String[] args) 
 {
  for(int i=1;i<=4;i++) {//i=2;                                              
	  
	  
	  for(int j=1;j<=i;j++) {
		  for(int s=3;s>=j;s--)
		  {
		   System.out.print(" ");
		  }
		  System.out.print("*");
	  }
	  System.out.println();
	  
  }
 }
}
