package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] neighbourhood = Arrays.stream(scan.nextLine().split("@"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        int index = 0;
        while (!input.equals("Love!")) {
            String[] tokens = input.split("\\s+");
            int length = Integer.parseInt(tokens[1]);
            index += length;
            if (index > neighbourhood.length - 1) {
                index = 0;
            }
            neighbourhood[index] = neighbourhood[index] - 2;

            if (neighbourhood[index] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", index);
            } else if (neighbourhood[index] < 0) {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            }

            input = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", index);
        int houseCount = 0;
        for (int house : neighbourhood) {
            if (house > 0) {
                houseCount++;
            }
        }
        if (houseCount == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", houseCount);
        }
    }
}
