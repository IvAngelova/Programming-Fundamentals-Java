package T4Methods.exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        long fact1 = calculateFactorial(n1);
        long fact2 = calculateFactorial(n2);
        double result = fact1 * 1.0 / fact2;
        System.out.printf("%.2f", result);
    }

    private static long calculateFactorial(int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
