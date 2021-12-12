package T2DataTypesAndVariables.lab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);
        char symbol3 = scan.nextLine().charAt(0);
        System.out.printf("%c %c %c", symbol3, symbol2, symbol1);
    }
}
