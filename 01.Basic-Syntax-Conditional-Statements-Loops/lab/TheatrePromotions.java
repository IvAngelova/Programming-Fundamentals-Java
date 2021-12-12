package T1BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String day = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        int price = 0;
        if (day.equals("Weekday")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 12;
            } else if (18 < age && age <= 64) {
                price = 18;
            }
        } else if (day.equals("Weekend")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 15;
            } else if (18 < age && age <= 64) {
                price = 20;
            }
        } else if (day.equals("Holiday")) {
            if (0 <= age && age <= 18) {
                price = 5;
            } else if (18 < age && age <= 64) {
                price = 12;
            } else if (64 < age && age <= 122) {
                price = 10;
            }
        }
        if (price == 0) {
            System.out.println("Error!");
        } else {
            System.out.println(price + "$");
        }
    }
}
