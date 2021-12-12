package T7AssociativeArrays.moreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputData = scan.nextLine();
        Map<String, String> contests = new HashMap<>();
        while (!inputData.equals("end of contests")) {

            String contest = inputData.split(":")[0];
            String contestPassword = inputData.split(":")[1];
            contests.put(contest, contestPassword);
            inputData = scan.nextLine();
        }
        String input = scan.nextLine();

        Map<String, Map<String, Integer>> userRanking = new HashMap<>();
        //<username, <contest(s), points>
        while (!input.equals("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (contests.containsKey(contest) && password.equals(contests.get(contest))) {
                if (!userRanking.containsKey(username)) {
                    userRanking.put(username, new HashMap<String, Integer>());
                }
                if (!userRanking.get(username).containsKey(contest)) {
                    userRanking.get(username).put(contest, points);
                } else {
                    int currentPoints = userRanking.get(username).get(contest);
                    if (currentPoints < points) {
                        userRanking.get(username).put(contest, points);
                    }
                }
            }
            input = scan.nextLine();
        }

        int bestPoints = 0;
        String bestCandidate = "";
        for (Map.Entry<String, Map<String, Integer>> entry : userRanking.entrySet()) {
            int currentPointsSum = entry.getValue().values().stream().mapToInt(e -> e).sum();
            if (currentPointsSum > bestPoints) {
                bestPoints = currentPointsSum;
                bestCandidate = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        System.out.println("Ranking: ");
        userRanking.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach((entry) -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
                });
    }
}
