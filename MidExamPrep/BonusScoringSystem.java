package MidExamPrep;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfStudents = Integer.parseInt(scan.nextLine());
        int countOfLectures = Integer.parseInt(scan.nextLine());
        int initialBonus = Integer.parseInt(scan.nextLine());
        //Ако countOfStudents или countOfLectures са 0, maxBonus и printAttendance също трябва да са 0
        double maxBonus = 0;
        int printAttendance = 0;
        for (int i = 0; i < countOfStudents; i++) {
            if (countOfLectures == 0) {
                break;
            }
            int currentAttendances = Integer.parseInt(scan.nextLine());
            //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
            double totalBonus = currentAttendances * 1.0 / countOfLectures * (5 + initialBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                printAttendance = currentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", printAttendance);
    }
}
