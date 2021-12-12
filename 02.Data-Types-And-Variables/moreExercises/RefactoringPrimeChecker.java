package T2DataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int num = 2; num <= n; num++) {
            boolean isPrime = true;
            for (int divider = 2; divider < num; divider++) {
                if (num % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", num, isPrime);
        }
    }
}
