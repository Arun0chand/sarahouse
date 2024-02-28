package Testingpack;

public class VowelsDisplay {
    public static void main(String[] args) {
        String name = "Anilkumarm";
        String nameLower = name.toLowerCase();
        String[] splitName = nameLower.split("");
        
        for(int i = 0; i < splitName.length; i++) {
            boolean isDuplicate = false;
            for(int j = 0; j < i; j++) {
                if(splitName[i].equals(splitName[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate) {
                System.out.print(splitName[i]);
            }
        }
    }
}