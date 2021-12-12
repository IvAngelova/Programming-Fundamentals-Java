package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfSnowballs = Integer.parseInt(scan.nextLine());
        double max = Double.NEGATIVE_INFINITY;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;
        for (int i = 0; i < numberOfSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);
            if (snowballValue > max) {
                max = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, max, maxQuality);
        //не използваме кастване (int), губи се точност, затова остава double и %.0f
        //този начин закръгля, а не маха всичко след десет. запетя
    }
}
