package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = 255;
        int n = Integer.parseInt(scan.nextLine());
        int sumLitersInTank = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scan.nextLine());
            if (capacity >= liters) {
                capacity -= liters;
                sumLitersInTank += liters;
            } else {
                System.out.println("Insufficient capacity!");
                continue;
            }
        }
        System.out.println(sumLitersInTank);
    }
}
