package FinalExamPrep;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> ratings = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plants.put(plant, rarity);
            ratings.putIfAbsent(plant, new ArrayList<>());
        }

        String input = scan.nextLine();
        while (!input.equals("Exhibition")) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String[] elements = tokens[1].split(" - ");
            String namePlant = elements[0];

            if (!plants.containsKey(namePlant)) {
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(elements[1]);
                    ratings.get(namePlant).add(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(elements[1]);
                    plants.put(namePlant, newRarity);
                    break;
                case "Reset":
                    ratings.get(namePlant).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scan.nextLine();
        }
        //sorting:
        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparingDouble(entry ->
                        ratings.get(entry.getKey()).stream().mapToDouble(x -> x).average().orElse(0.0)).reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                        ratings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

    }
}
