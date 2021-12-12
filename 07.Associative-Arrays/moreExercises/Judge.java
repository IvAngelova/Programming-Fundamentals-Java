package T7AssociativeArrays.moreExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        // <contest, <username, points>
        while (!input.equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (!contests.containsKey(contest)) {
                contests.put(contest, new HashMap<>());
            }
            if (!contests.get(contest).containsKey(username)) {
                contests.get(contest).put(username, points);
            } else {
                int currentPoints = contests.get(contest).get(username);
                if (currentPoints < points) {
                    contests.get(contest).put(username, points);
                }
            }
            input = scan.nextLine();
        }
        Map<String, Integer> individualStatistics = new HashMap<>();
        //<username, totalPoints from all participated contests>
        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {
            entry.getValue().entrySet().stream().forEach(e -> {
                if (!individualStatistics.containsKey(e.getKey())) {
                    individualStatistics.put(e.getKey(), e.getValue());
                } else {
                    individualStatistics.put(e.getKey(), individualStatistics.get(e.getKey()) + e.getValue());
                }
            });
        }

        contests.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %d participants%n", e.getKey(), e.getValue().size());
            final int[] count = {0};
            e.getValue().entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> {
                        count[0] += 1;
                        System.out.printf("%d. %s <::> %d%n", count[0], entry.getKey(), entry.getValue());
                    });
        });

        System.out.println("Individual standings:");
        final int[] count = {0};
        individualStatistics.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    count[0] += 1;
                    System.out.printf("%d. %s -> %d%n", count[0], e.getKey(), e.getValue());
                });


    }
}
