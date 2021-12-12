package T1BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = Integer.parseInt(scan.nextLine());
        }
        System.out.println("The number is: " + Math.abs(number));
    }
}
