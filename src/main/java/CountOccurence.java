
public class CountOccurence {

	public static void main(String[] args) {


		String str="Java is a Programing Language Arun";
		str=str.toLowerCase();

		int result=str.length()-str.replace("p", "").length();
		System.out.println("Number of the repeated count of a is:="+result);
	}

}
