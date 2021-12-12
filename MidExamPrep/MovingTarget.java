package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("End")) {
            String typeOfCommand = command.split("\\s+")[0];
            int index = Integer.parseInt(command.split("\\s+")[1]);
            switch (typeOfCommand) {
                case "Shoot":
                    int power = Integer.parseInt(command.split("\\s+")[2]);
                    if (isIndexValid(targets.size(), index)) {
                        if (targets.get(index) - power > 0) {
                            targets.set(index, targets.get(index) - power);
                        } else {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(command.split("\\s+")[2]);
                    if (isIndexValid(targets.size(), index)) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command.split("\\s+")[2]);
                    if (isIndexValid(targets.size(), index) &&
                            isIndexValid(targets.size(), index + radius)
                            && isIndexValid(targets.size(), index - radius)) {
                        for (int i = index - radius; i <= index + radius; i++) {
                            targets.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }
        }
    }

    private static boolean isIndexValid(int size, int index) {
        return index >= 0 && index <= size - 1;
    }
}
