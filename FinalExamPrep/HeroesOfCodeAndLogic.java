package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> heroHitPoints = new LinkedHashMap<>();
        Map<String, Integer> heroManaPoints = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String heroName = input.split(" ")[0];
            int hp = Integer.parseInt(input.split(" ")[1]);
            int mp = Integer.parseInt(input.split(" ")[2]);
            heroHitPoints.put(heroName, hp);
            heroManaPoints.put(heroName, mp);
        }
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String typeOfCommand = tokens[0];
            String heroName = tokens[1];
            switch (typeOfCommand) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spell = tokens[3];
                    if (heroManaPoints.get(heroName) >= mpNeeded) {
                        heroManaPoints.put(heroName, heroManaPoints.get(heroName) - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spell, heroManaPoints.get(heroName));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    heroHitPoints.put(heroName, heroHitPoints.get(heroName) - damage);
                    if (heroHitPoints.get(heroName) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, heroHitPoints.get(heroName));
                    } else {
                        heroHitPoints.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    if (heroManaPoints.get(heroName) + amount <= 200) {
                        heroManaPoints.put(heroName, heroManaPoints.get(heroName) + amount);
                        System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    } else {
                        int amountRecovered = 200 - heroManaPoints.get(heroName);
                        heroManaPoints.put(heroName, 200);
                        System.out.printf("%s recharged for %d MP!%n", heroName, amountRecovered);
                    }
                    break;
                case "Heal":
                    int amountHeal = Integer.parseInt(tokens[2]);
                    if (heroHitPoints.get(heroName) + amountHeal <= 100) {
                        heroHitPoints.put(heroName, heroHitPoints.get(heroName) + amountHeal);
                        System.out.printf("%s healed for %d HP!%n", heroName, amountHeal);
                    } else {
                        int amountRecovered = 100 - heroHitPoints.get(heroName);
                        heroHitPoints.put(heroName, 100);
                        System.out.printf("%s healed for %d HP!%n", heroName, amountRecovered);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        heroHitPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    System.out.println("  HP: " + entry.getValue());
                    System.out.println("  MP: " + heroManaPoints.get(entry.getKey()));
                });
    }
}
