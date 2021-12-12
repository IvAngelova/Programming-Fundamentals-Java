package T4Methods.moreExercises;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        printClosestCenterPoint(x1, y1, x2, y2);
    }

    private static void printClosestCenterPoint(double x1, double y1, double x2, double y2) {
        // Питагорова теорема за (x1, y1):
        double result1 = Math.pow(x1, 2) + Math.pow(y1, 2);
        // Питагорова теорема за (x2, y2):
        double result2 = Math.pow(x2, 2) + Math.pow(y2, 2);
        if (result1 <= result2) {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        } else {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }
    }
}
