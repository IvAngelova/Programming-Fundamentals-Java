package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();
        double price = 0.0;
        switch (day) {
            case "Friday":
                if (groupType.equals("Students")) {
                    price = 8.45;
                } else if (groupType.equals("Business")) {
                    price = 10.90;
                } else if (groupType.equals("Regular")) {
                    price = 15;
                }
                break;
            case "Saturday":
                if (groupType.equals("Students")) {
                    price = 9.80;
                } else if (groupType.equals("Business")) {
                    price = 15.60;
                } else if (groupType.equals("Regular")) {
                    price = 20;
                }
                break;
            case "Sunday":
                if (groupType.equals("Students")) {
                    price = 10.46;
                } else if (groupType.equals("Business")) {
                    price = 16;
                } else if (groupType.equals("Regular")) {
                    price = 22.50;
                }
                break;
        }
        double totalPrice = people * price;
        if (groupType.equals("Students")) {
            if (people >= 30) {
                totalPrice *= 0.85;
            }
        } else if (groupType.equals("Business")) {
            if (people >= 100) {
                totalPrice -= 10 * price;
            }
        } else if (groupType.equals("Regular")) {
            if (people >= 10 && people <= 20) {
                totalPrice *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
