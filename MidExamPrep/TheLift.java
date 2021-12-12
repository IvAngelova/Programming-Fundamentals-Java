package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int[] wagons = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int maxCapacityWagon = 4;
        boolean noMorePeopleInTheQueue = false;
        int counterFullWagons = 0;
        boolean allWagonsAreFull = false;

        for (int i = 0; i <= wagons.length - 1; i++) {
            if (wagons[i] < maxCapacityWagon) {
                int freeSeats = maxCapacityWagon - wagons[i];
                if (people >= freeSeats) {
                    people -= freeSeats;
                    wagons[i] += freeSeats;
                    if (people == 0) {
                        noMorePeopleInTheQueue = true;
                        break;
                    }
                } else {
                    wagons[i] += people;
                    people = 0;
                    noMorePeopleInTheQueue = true;
                    break;
                }
            }
        }
        for (int i = 0; i <= wagons.length - 1; i++) {
            if (wagons[i] == maxCapacityWagon) {
                counterFullWagons++;
            }
        }
        if (counterFullWagons == wagons.length) {
            allWagonsAreFull = true;
        }


        if (noMorePeopleInTheQueue && !allWagonsAreFull) {
            System.out.println("The lift has empty spots!");
            printWagons(wagons);
        } else if (!noMorePeopleInTheQueue && allWagonsAreFull) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            printWagons(wagons);
        } else if (noMorePeopleInTheQueue && allWagonsAreFull) {
            printWagons(wagons);
        }

    }

    private static void printWagons(int[] wagons) {
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
