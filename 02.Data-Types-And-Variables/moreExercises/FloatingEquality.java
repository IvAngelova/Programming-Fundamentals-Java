package T2DataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());
        double eps = 0.000001;
        double diff = Math.abs(a - b);
        if (diff >= eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
