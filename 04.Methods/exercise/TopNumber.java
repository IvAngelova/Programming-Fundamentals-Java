package T4Methods.exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            int currentNum = i;
            if (checkTopNumber(currentNum)) {
                System.out.println(currentNum);
            }
        }
    }

    private static boolean checkTopNumber(int number) {
        return checkIfSumOfDigitsDivisibleBy8(number) && checkAtLeastOneOddDigit(number);
    }

    private static boolean checkAtLeastOneOddDigit(int number) {
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static boolean checkIfSumOfDigitsDivisibleBy8(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }

    }
}
