package T4Methods.lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        totalPriceOfOrder(product, quantity);
    }

    private static void totalPriceOfOrder(String product, double quantity) {
        double price = 0;
        switch (product) {
            case "coke":
                price = 1.40;
                break;
            case "water":
                price = 1.00;
                break;
            case "snacks":
                price = 2.0;
                break;
            case "coffee":
                price = 1.50;
                break;
        }
        System.out.printf("%.2f", price * quantity);
    }
}
