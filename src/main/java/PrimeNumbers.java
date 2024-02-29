
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int result = checkPrimeNotFibonacci(number);
        System.out.println(result);
        scanner.close();
    }

    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    public static boolean isFibonacci(int number) {
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }

    public static int checkPrimeNotFibonacci(int number) {
        if (isPrime(number) && !isFibonacci(number)) {
            return 1;
        } else {
            return 0;
        }
    }
}
