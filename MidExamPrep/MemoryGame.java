package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        int counterMoves = 0;
        boolean isEmpty = false;
        while (!input.equals("end")) {
            int[] indexes = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int index1 = indexes[0];
            int index2 = indexes[1];
            counterMoves++;
            if (index1 == index2) {
                sequence.add(sequence.size() / 2, "-" + counterMoves + "a");
                sequence.add((sequence.size() / 2) + 1, "-" + counterMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            if (isValidIndex(index1, sequence.size()) &&
                    isValidIndex(index2, sequence.size())) {
                if (sequence.get(index1).equals(sequence.get(index2))) {
                    String equalElement = sequence.get(index1);
                    System.out.printf("Congrats! You have found matching " +
                            "elements - %s!%n", equalElement);
                    sequence.removeAll(Arrays.asList(equalElement));
                    if (sequence.isEmpty()) {
                        isEmpty = true;
                        break;
                    }
                } else {
                    System.out.println("Try again!");
                    input = scan.nextLine();
                    continue;
                }
            } else {
                sequence.add(sequence.size() / 2, "-" + counterMoves + "a");
                sequence.add((sequence.size() / 2) + 1, "-" + counterMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }


            input = scan.nextLine();
        }
        if (isEmpty) {
            System.out.printf("You have won in %d turns!", counterMoves);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequence));
        }
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
