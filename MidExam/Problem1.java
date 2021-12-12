package MidExam;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceFlour = Double.parseDouble(scan.nextLine());
        double priceEgg = Double.parseDouble(scan.nextLine());
        double priceApron = Double.parseDouble(scan.nextLine());
        int freePackagesFlour = students / 5;
        double totalSum = priceFlour * (students - freePackagesFlour)
                + priceEgg * 10 * students
                + priceApron * Math.ceil(students * 1.2);
        if (totalSum <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalSum);
        } else {
            System.out.printf("%.2f$ more needed.", totalSum - budget);
        }
    }
}
