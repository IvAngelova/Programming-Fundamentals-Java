package T5Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> player1cards = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2cards = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < Math.min(player1cards.size(), player2cards.size()); i++) {
            int currentCardPlayer1 = player1cards.get(i);
            int currentCardPlayer2 = player2cards.get(i);
            if (currentCardPlayer1 == currentCardPlayer2) {
                player1cards.remove(i);
                player2cards.remove(i);

            } else if (currentCardPlayer1 > currentCardPlayer2) {
                player1cards.add(player1cards.get(i));
                player1cards.add(player2cards.get(i));
                player1cards.remove(i);
                player2cards.remove(i);

            } else if (currentCardPlayer2 > currentCardPlayer1) {
                player2cards.add(player2cards.get(i));
                player2cards.add(player1cards.get(i));
                player2cards.remove(i);
                player1cards.remove(i);

            }
            i = -1;
        }
        int sum = 0;
        if (player1cards.isEmpty()) {
            for (Integer player2card : player2cards) {
                sum += player2card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else if (player2cards.isEmpty()) {
            for (Integer player1card : player1cards) {
                sum += player1card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }

}

