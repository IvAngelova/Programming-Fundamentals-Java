package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        int countShootTargets = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index <= targets.length - 1) {
                int currentValue = targets[index];
                if (currentValue != -1) {
                    targets[index] = -1;
                    countShootTargets++;
                    for (int i = 0; i < index; i++) {
                        if (targets[i] != -1) {
                            if (targets[i] > currentValue) {
                                targets[i] -= currentValue;
                            } else if (targets[i] <= currentValue) {
                                targets[i] += currentValue;
                            }
                        }
                    }
                    for (int i = index + 1; i <= targets.length - 1; i++) {
                        if (targets[i] != -1) {
                            if (targets[i] > currentValue) {
                                targets[i] -= currentValue;
                            } else if (targets[i] <= currentValue) {
                                targets[i] += currentValue;
                            }
                        }
                    }
                }
            }

            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShootTargets);
        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}
