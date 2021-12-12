package T7AssociativeArrays.moreExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();
        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] inputParts = input.split(" -> ");
                String player = inputParts[0];
                String position = inputParts[1];
                int skill = Integer.parseInt(inputParts[2]);
                if (!players.containsKey(player)) {
                    players.put(player, new HashMap<>());
                    players.get(player).put(position, skill);
                } else {
                    if (players.get(player).containsKey(position)) {
                        int currentPositionSkill = players.get(player).get(position);
                        if (currentPositionSkill < skill) {
                            players.get(player).put(position, skill);
                        }
                    } else {
                        players.get(player).put(position, skill);
                    }
                }
            } else {
                String[] tokens = input.split(" vs ");
                String player1 = tokens[0];
                String player2 = tokens[1];
                if (players.containsKey(player1) && players.containsKey(player2)) {
                    boolean commonPositionIsFound = false;
                    String commonPosition = "";
                    label:
                    for (String currentPositionPl1 : players.get(player1).keySet()) {
                        for (String currentPositionPl2 : players.get(player2).keySet()) {
                            if (currentPositionPl1.equals(currentPositionPl2)) {
                                commonPositionIsFound = true;
                                commonPosition = currentPositionPl1;
                                break label;
                            }
                        }
                    }
                    if (commonPositionIsFound) {
                        if (players.get(player1).get(commonPosition) < players.get(player2).get(commonPosition)) {
                            players.remove(player1);
                        } else if (players.get(player1).get(commonPosition) > players.get(player2).get(commonPosition)) {
                            players.remove(player2);
                        }
                    }
                }
            }
            input = scan.nextLine();
        }

        Map<String, Integer> playersTotalSkill = new LinkedHashMap<>();
        players.entrySet().forEach(e -> {
            int sum = e.getValue().values().stream().mapToInt(x -> x).sum();
            playersTotalSkill.put(e.getKey(), sum);
        });
        playersTotalSkill.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());
                    players.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                            .forEach(e -> System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue()));
                });
    }
}
