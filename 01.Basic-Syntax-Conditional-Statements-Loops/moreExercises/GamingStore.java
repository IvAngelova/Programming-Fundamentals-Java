package T1BasicSyntaxConditionalStatementsAndLoops.moreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scan.nextLine());
        double balanceAtBeginning = currentBalance;
        String input = scan.nextLine();
        double price = 0.0;
        while (!input.equals("Game Time")) {
            String gameName = input;
            switch (gameName) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    input = scan.nextLine();
                    continue;
            }
            if (price > currentBalance) {
                System.out.println("Too Expensive");
                input = scan.nextLine();
                continue;
            } else {
                System.out.printf("Bought %s%n", gameName);
                currentBalance -= price;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            input = scan.nextLine();
        }
        if (input.equals("Game Time")) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", balanceAtBeginning - currentBalance, currentBalance);
        }

    }
}
