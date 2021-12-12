package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine()); // начален добив
        int days = 0;
        int totalAmountOfSpice = 0;
        while (startingYield >= 100) {
            days++;
            int spiceAvailableForMiningCrew = startingYield;
            int spiceLeft = spiceAvailableForMiningCrew - 26;
            totalAmountOfSpice += spiceLeft;
            startingYield -= 10;
        }
        if (totalAmountOfSpice >= 26) {
            totalAmountOfSpice -= 26;
        }
        System.out.println(days);
        System.out.print(totalAmountOfSpice);
    }
}
