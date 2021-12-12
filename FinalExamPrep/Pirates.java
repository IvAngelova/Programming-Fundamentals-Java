package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> townsAndPopulation = new LinkedHashMap<>();
        Map<String, Integer> townsAndGold = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            String town = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);
            if (!townsAndPopulation.containsKey(town) && !townsAndGold.containsKey(town)) {
                townsAndPopulation.put(town, 0);
                townsAndGold.put(town, 0);
            }
            townsAndPopulation.put(town, townsAndPopulation.get(town) + population);
            townsAndGold.put(town, townsAndGold.get(town) + gold);

            input = scan.nextLine();
        }
        String events = scan.nextLine();
        while (!events.equals("End")) {
            String[] tokens = events.split("=>");
            String event = tokens[0];
            String town = tokens[1];
            if (event.equals("Plunder")) {
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);
                townsAndPopulation.put(town, townsAndPopulation.get(town) - people);
                townsAndGold.put(town, townsAndGold.get(town) - gold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                if (townsAndPopulation.get(town) <= 0 || townsAndGold.get(town) <= 0) {
                    townsAndPopulation.remove(town);
                    townsAndGold.remove(town);
                    System.out.println(town + " has been wiped off the map!");
                }
            } else if (event.equals("Prosper")) {
                int gold = Integer.parseInt(tokens[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    townsAndGold.put(town, townsAndGold.get(town) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, townsAndGold.get(town));
                }
            }
            events = scan.nextLine();
        }
        if (townsAndGold.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townsAndGold.size());
            townsAndGold.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            entry.getKey(), townsAndPopulation.get(entry.getKey()), entry.getValue()));
        }
    }
}
