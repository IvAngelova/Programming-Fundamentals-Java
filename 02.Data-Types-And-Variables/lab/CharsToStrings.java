package T2DataTypesAndVariables.lab;

import java.util.Scanner;

public class CharsToStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char symbol1 = scan.nextLine().charAt(0);
        char symbol2 = scan.nextLine().charAt(0);
        char symbol3 = scan.nextLine().charAt(0);
        String result = String.format("%c%c%c", symbol1, symbol2, symbol3);
        System.out.println(result);
    }
}
