package MidExamPrep;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());
        double sumPlunder = 0;
        for (int i = 1; i <= days; i++) {
            sumPlunder += dailyPlunder;
            if (i % 3 == 0) {
                sumPlunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                sumPlunder *= 0.7;
            }
        }
        if (sumPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", sumPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", sumPlunder / expectedPlunder * 100);
        }
    }
}
