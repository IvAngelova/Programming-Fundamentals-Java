package T1BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class MultiplicationTable02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());
        do {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
            multiplier++;
        } while (multiplier <= 10);
    }
}
