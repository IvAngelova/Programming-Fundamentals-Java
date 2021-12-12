package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        double totalMoneyInserted = 0.0;
        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);
            if (coins == 2 || coins == 1 || coins == 0.5 || coins == 0.2 || coins == 0.1) {
                totalMoneyInserted += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            command = scan.nextLine();
        }
        String command2 = scan.nextLine();
        while (!command2.equals("End")) {
            String product = command2;
            double price = 0.0;
            boolean isInvalid = false;
            switch (product) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    isInvalid = true;
                    break;
            }
            if (!isInvalid) {
                if (totalMoneyInserted >= price) {
                    totalMoneyInserted -= price;
                    System.out.printf("Purchased %s%n", product);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }

            command2 = scan.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoneyInserted);

    }
}
