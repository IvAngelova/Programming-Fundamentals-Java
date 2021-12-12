package MidExamPrep;

import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumPeoplePerHour = 0;
        for (int i = 1; i <= 3; i++) {
            int currentEmployeeEfficiency = Integer.parseInt(scan.nextLine());
            sumPeoplePerHour += currentEmployeeEfficiency;
        }
        int peopleCount = Integer.parseInt(scan.nextLine());
        int hours = 0;
        while (peopleCount > 0) {
            hours++;
            if (hours % 4 == 0) {
                continue;
            }
            peopleCount = peopleCount - sumPeoplePerHour;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
