package StarPatternPrograms;

public class PrintProgram {
    public static void main(String[] args) {
        for(int i = 1; i <= 1000; i++) {
            if(i % 3 == 0) {
                System.out.print("hi ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
