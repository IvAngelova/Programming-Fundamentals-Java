package T7AssociativeArrays.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> userPoints = new HashMap<>();
        Map<String, Integer> languageCount = new HashMap<>();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String username = tokens[0];
            if (tokens.length == 3) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                if (!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if (currentPoints < points) {
                        userPoints.put(username, points);
                    }
                }
                if (!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    languageCount.put(language, languageCount.get(language) + 1);
                }
            } else {
                userPoints.remove(username);
            }
            input = scan.nextLine();
        }
        System.out.println("Results:");
        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
        System.out.println("Submissions:");
        languageCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
