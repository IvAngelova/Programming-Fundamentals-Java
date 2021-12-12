package T8TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] elements = input.split("\\s+");
        double totalSum = 0;
        for (String element : elements) {
            double currentSum = getCurrentElementSum(element);
            totalSum += currentSum;
        }
        System.out.printf("%.2f", totalSum);

    }

    private static double getCurrentElementSum(String element) {
        char firstLetter = element.charAt(0);
        char secondLetter = element.charAt(element.length() - 1);
        double number = Double.parseDouble(element.substring(1, element.length() - 1));

        if (Character.isUpperCase(firstLetter)) {
            number /= firstLetter - 64;
        } else if (Character.isLowerCase(firstLetter)) {
            number *= firstLetter - 96;
        }
        if (Character.isUpperCase(secondLetter)) {
            number -= secondLetter - 64;
        } else if (Character.isLowerCase(secondLetter)) {
            number += secondLetter - 96;
        }

        return number;
    }
}
