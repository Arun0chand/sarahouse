package Testingpack;

public class DisplayDuplicateCharacters {
	
	public static void main(String[] args) {
		
		String str = "Hello Hello world";
		
		str = str.toLowerCase().replace(" ", "");
		
		System.out.println("Duplicate characters:");
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			boolean duplicate = false;
			
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == ch ) {
					duplicate = true;
					break;
				}
			}
			
			if (duplicate) {
				System.out.print(ch + " ");
			}
		}
	}
}
