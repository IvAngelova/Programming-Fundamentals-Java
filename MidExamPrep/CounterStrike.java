package MidExamPrep;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int wonBattles = 0;
        boolean isLost = false;
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (energy - distance >= 0) {
                energy -= distance;
                wonBattles++;
            } else {
                isLost = true;
                System.out.printf("Not enough energy!" +
                        " Game ends with %d won battles and %d energy%n", wonBattles, energy);
                break;
            }
            if (wonBattles % 3 == 0) {
                energy += wonBattles;
            }
            input = scan.nextLine();
        }
        if (!isLost) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}
