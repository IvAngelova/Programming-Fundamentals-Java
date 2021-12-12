package MidExamPrep;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double totalPriceWithoutTax = 0.0;
        while (!(input.equals("special") || input.equals("regular"))) {
            double priceWithoutTax = Double.parseDouble(input);
            if (priceWithoutTax <= 0) {
                System.out.println("Invalid price!");
                input = scan.nextLine();
                continue;
            }
            totalPriceWithoutTax += priceWithoutTax;
            input = scan.nextLine();
        }
        if (totalPriceWithoutTax == 0) {
            System.out.println("Invalid order!");
            return;
        }
        double taxes = 0.2 * totalPriceWithoutTax;
        double finalPrice = taxes + totalPriceWithoutTax;
        if (input.equals("special")) {
            finalPrice *= 0.9;
        }
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTax);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", finalPrice);
    }
}
