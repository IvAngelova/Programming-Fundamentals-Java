package T8TextProcessing.lab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (Character.isDigit(symbol)) {
                digits.append(symbol);
            } else if (Character.isAlphabetic(symbol)) {
                letters.append(symbol);
            } else {
                other.append(symbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
