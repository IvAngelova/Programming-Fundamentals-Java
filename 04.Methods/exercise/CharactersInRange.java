package T4Methods.exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);
        printCharsInRangeSymbol1Symbol2(symbol1, symbol2);
    }

    private static void printCharsInRangeSymbol1Symbol2(char symbol1, char symbol2) {
        if (symbol1 < symbol2) {
            for (int i = symbol1 + 1; i < symbol2; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = symbol2 + 1; i < symbol1; i++) {
                System.out.printf("%c ", i);
            }

        }
    }
}
