import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repeatedchar {
	public static void main(String[] args) {

		// Creating a HashMap to store characters and their occurrences
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string ");
		
		String str=sc.nextLine();
		HashMap<Character, Integer> charMap=new HashMap();

		char[] charArray=str.toLowerCase().toCharArray();



		for(char ch : charArray) {

			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			}else {

				{
					// If the character is encountered for the first time, add it to the HashMap
					charMap.put(ch, 1);
				}

			}
		}

		System.out.println("Print the repeated characters and there count"+str);

		  for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
	            if (entry.getValue() > 1) {
	                System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
	            }
	        }
	}
}
