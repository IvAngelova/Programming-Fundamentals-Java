package MidExamPrep.archive;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> houses = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int currentPositionIndex = 0;
        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(" ");
            String typeOfCommand = command[0];
            switch (typeOfCommand) {
                case "Forward":
                    int numberStepsForward = Integer.parseInt(command[1]);
                    if (isValidIndex(currentPositionIndex + numberStepsForward, houses.size())) {
                        currentPositionIndex += numberStepsForward;
                        houses.remove(currentPositionIndex);
                    }
                    break;
                case "Back":
                    int numberStepsBack = Integer.parseInt(command[1]);
                    if (isValidIndex(currentPositionIndex - numberStepsBack, houses.size())) {
                        currentPositionIndex -= numberStepsBack;
                        houses.remove(currentPositionIndex);
                    }
                    break;
                case "Gift":
                    int index = Integer.parseInt(command[1]);
                    if (isValidIndex(index, houses.size())) {
                        int houseNumber = Integer.parseInt(command[2]);
                        houses.add(index, houseNumber);
                        currentPositionIndex = index;
                    }
                    break;
                case "Swap":
                    int houseNumber1 = Integer.parseInt(command[1]);
                    int houseNumber2 = Integer.parseInt(command[2]);
                    int indexFirstHouse = houses.indexOf(houseNumber1);
                    int indexSecondHouse = houses.indexOf(houseNumber2);
                    if (isValidIndex(indexFirstHouse, houses.size()) && isValidIndex(indexSecondHouse, houses.size())) {
                        houses.set(indexFirstHouse, houseNumber2);
                        houses.set(indexSecondHouse, houseNumber1);
                    }
                    break;
            }
        }
        System.out.println("Position: " + currentPositionIndex);
        for (int i = 0; i <= houses.size() - 1; i++) {
            if (i == houses.size() - 1) {
                System.out.print(houses.get(i));
            } else {
                System.out.print(houses.get(i) + ", ");
            }
        }

    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
