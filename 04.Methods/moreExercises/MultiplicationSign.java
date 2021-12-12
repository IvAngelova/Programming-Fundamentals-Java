package T4Methods.moreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int countSigns = PositiveNegative(num1, num2, num3);
        if (countSigns == -1)
            System.out.println("zero");
        else if (countSigns % 2 == 0)
            System.out.println("negative");
        else if (countSigns % 2 != 0)
            System.out.println("positive");

    }

    private static int PositiveNegative(int num1, int num2, int num3) {
        int count = 0;
        //if numbers are negative
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            count = -1;
            return count;
        }
        //count of positive
        if (num1 > 0) {
            count++;
        }
        if (num2 > 0) {
            count++;
        }
        if (num3 > 0) {
            count++;
        }
        return count;
    }
}

