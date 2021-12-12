package T4Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String number = command;
            System.out.println(PalindromeOrNot(number));
            command = scan.nextLine();
        }
    }

    private static boolean PalindromeOrNot(String number) {
        StringBuilder reversedNumber = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            char currentDigit = number.charAt(i);
            reversedNumber.append(currentDigit);
        }
        String reversedNumAsString = reversedNumber.toString();
        return reversedNumAsString.equals(number);
    }
}
