package T7AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            productsPrice.put(product, price);
            if (!productsQuantity.containsKey(product)) {
                productsQuantity.put(product, quantity);
            } else {
                productsQuantity.put(product, productsQuantity.get(product) + quantity);
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue() * productsPrice.get(entry.getKey()));
        }
    }
}
