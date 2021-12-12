package T4Methods.exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        printMiddleCharacters(text);
    }

    private static void printMiddleCharacters(String text) {
        if (text.length() % 2 == 1) {
            System.out.printf("%c", text.charAt(text.length() / 2));
        } else {
            System.out.printf("%c%c", text.charAt(text.length() / 2 - 1), text.charAt(text.length() / 2));
        }
    }
}
