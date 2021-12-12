package T4Methods.lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        number = Math.abs(number);
        System.out.println(getMultipleOfEvensAndOdds(number));

    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int evenSum = getSumOfEvenDigits(number);
        int oddSum = getSumOfOddDigits(number);
        return evenSum * oddSum;
    }

    private static int getSumOfEvenDigits(int number) {
        int evenSum = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number /= 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int number) {
        int oddSum = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 1) {
                oddSum += digit;
            }
            number /= 10;
        }
        return oddSum;
    }
}
