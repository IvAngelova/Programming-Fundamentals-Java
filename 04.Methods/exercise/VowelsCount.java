package T4Methods.exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        printVowelsCount(text);
    }

    private static void printVowelsCount(String text) {
        int count = 0;
        for (int i = 0; i <= text.length() - 1; i++) {
            char letter = text.charAt(i);
            switch (Character.toLowerCase(letter)) {
                case 'a':
                case 'o':
                case 'u':
                case 'e':
                case 'i':
                    count++;
            }

        }
        System.out.println(count);
    }
}
