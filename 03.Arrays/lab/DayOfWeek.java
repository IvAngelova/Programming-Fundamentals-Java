package T3Arrays.lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dayNumber = Integer.parseInt(scan.nextLine());
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println(days[dayNumber - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
