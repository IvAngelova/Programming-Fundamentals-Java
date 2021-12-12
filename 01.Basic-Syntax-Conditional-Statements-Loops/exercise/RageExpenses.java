package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double priceHeadset = Double.parseDouble(scan.nextLine());
        double priceMouse = Double.parseDouble(scan.nextLine());
        double priceKeyboard = Double.parseDouble(scan.nextLine());
        double priceDisplay = Double.parseDouble(scan.nextLine());
        int trashedHeadset = lostGames / 2;
        int trashedMouse = lostGames / 3;
        int trashedKeyboard = lostGames / 6;
        int trashedDisplay = lostGames / 12;
        double totalExpenses = priceHeadset * trashedHeadset + priceMouse * trashedMouse
                + priceKeyboard * trashedKeyboard + priceDisplay * trashedDisplay;
        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
