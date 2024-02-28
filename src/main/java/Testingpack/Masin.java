package Testingpack;

public class Masin {
    public static void main(String[] args) {
        String str = "Hello world";

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean isDuplicate = false;

            // Check if the character is encountered more than once
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    isDuplicate = true;
                    break;
                }
            }
            
            // Check if the character is already printed as a duplicate
            for (int k = 0; k < i; k++) {
                if (str.charAt(k) == ch) {
                    isDuplicate = false;  // Corrected from `isDuplicate = true`
                    break;
                }
            }

            // Print the character if it's a duplicate
            if (isDuplicate) {
                System.out.print(ch + " ")	;
            }
        }
    }
}
