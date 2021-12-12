package T8TextProcessing.exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        String firstString = input[0];
        String secondString = input[1];
        int sum = getSumOfCharactersMultiplied(firstString, secondString);
        System.out.println(sum);
    }

    private static int getSumOfCharactersMultiplied(String firstString, String secondString) {
        int sum = 0;
        int size = Math.min(firstString.length(), secondString.length());
        for (int i = 0; i < size; i++) {
            sum += (firstString.charAt(i) * secondString.charAt(i));
        }
        if (firstString.length() > secondString.length()) {
            for (int i = size; i < firstString.length(); i++) {
                sum += firstString.charAt(i);
            }
        } else if (firstString.length() < secondString.length()) {
            for (int i = size; i < secondString.length(); i++) {
                sum += secondString.charAt(i);
            }
        }
        return sum;
    }
}
