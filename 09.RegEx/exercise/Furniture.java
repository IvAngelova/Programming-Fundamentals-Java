package T9RegEx.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;
        List<String> boughtFurniture = new ArrayList<>();
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
                boughtFurniture.add(furniture);
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        boughtFurniture.forEach(e -> System.out.println(e));
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
