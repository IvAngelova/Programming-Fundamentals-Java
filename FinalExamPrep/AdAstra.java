package FinalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "([|#])(?<itemName>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        List<String> items = new ArrayList<>();

        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            String item = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d",
                    item, expirationDate, calories));
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        if (!items.isEmpty()) {
            items.forEach(e -> System.out.println(e));
        }
    }
}
