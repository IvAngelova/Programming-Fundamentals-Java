package T9RegEx.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(",\\s*");
        Map<String, Integer> demonHealth = new LinkedHashMap<>();
        Map<String, Double> demonDamage = new LinkedHashMap<>();

        String regexHealth = "[^\\d+\\-\\/*.]";
        Pattern patternHealth = Pattern.compile(regexHealth);
        String regexDamage = "[0-9.\\-]+";
        Pattern patternDamage = Pattern.compile(regexDamage);
        String regexCountMultiplyingAndDividing = "[*\\/]";
        Pattern patternCountMultiplyingAndDividing = Pattern.compile(regexCountMultiplyingAndDividing);

        for (int i = 0; i < names.length; i++) {
            String currentName = names[i].replaceAll(" ", "");
            int health = 0;
            Matcher matcherHealth = patternHealth.matcher(currentName);
            while (matcherHealth.find()) {
                char currSymbol = matcherHealth.group().charAt(0);
                health += currSymbol;
            }
            double damage = 0;
            Matcher matcherDamage = patternDamage.matcher(currentName);
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }
            Matcher matcherCountMultiplyingAndDividing = patternCountMultiplyingAndDividing.matcher(currentName);

            while (matcherCountMultiplyingAndDividing.find()) {
                if (matcherCountMultiplyingAndDividing.group().equals("*")) {
                    damage *= 2;
                } else if (matcherCountMultiplyingAndDividing.group().equals("/")) {
                    damage /= 2;
                }
            }
            demonHealth.put(currentName, health);
            demonDamage.put(currentName, damage);
        }
        demonHealth.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s - %d health, %.2f damage%n", e.getKey(),
                        e.getValue(), demonDamage.get(e.getKey())));
    }
}
