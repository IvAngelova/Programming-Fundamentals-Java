package T5Lists.moreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        List<Integer> initialDrumSet = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumSet = new ArrayList<>();
        for (int i = 0; i <= initialDrumSet.size() - 1; i++) {
            drumSet.add(initialDrumSet.get(i));
        }

        String input = scan.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i <= drumSet.size() - 1; i++) {
                int currentDrum = drumSet.get(i);
                currentDrum -= hitPower;
                if (currentDrum <= 0) {
                    if (money >= initialDrumSet.get(i) * 3) {
                        money -= initialDrumSet.get(i) * 3;
                        currentDrum = initialDrumSet.get(i);
                        drumSet.set(i, currentDrum);
                    } else {
                        drumSet.remove(i);
                        initialDrumSet.remove(i);
                        // !!!!!
                        if (i <= drumSet.size() - 1) {
                            i = i - 1;
                        }
                    }
                } else {
                    drumSet.set(i, currentDrum);
                }
            }
            input = scan.nextLine();
        }
        for (Integer drum : drumSet) {
            System.out.print(drum + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", money);
    }
}
