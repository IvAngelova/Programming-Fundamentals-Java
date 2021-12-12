package T5Lists.moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] carRace = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        double timeLeftRacer = 0.0;
        double timeRightRacer = 0.0;
        int finishIndex = carRace.length / 2;
        for (int indexLeft = 0; indexLeft < finishIndex; indexLeft++) {
            timeLeftRacer += carRace[indexLeft];
            if (carRace[indexLeft] == 0) {
                timeLeftRacer *= 0.8;
            }
        }
        for (int indexRight = carRace.length - 1; indexRight > finishIndex; indexRight--) {
            timeRightRacer += carRace[indexRight];
            if (carRace[indexRight] == 0) {
                timeRightRacer *= 0.8;
            }
        }
        if (timeLeftRacer < timeRightRacer) {
            System.out.printf("The winner is left with total time: %.1f", timeLeftRacer);
        } else if (timeRightRacer < timeLeftRacer) {
            System.out.printf("The winner is right with total time: %.1f", timeRightRacer);
        }
    }
}
