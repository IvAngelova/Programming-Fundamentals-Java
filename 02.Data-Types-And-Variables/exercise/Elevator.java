package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());
        double courses = people * 1.0 / capacity;
        System.out.println((int) Math.ceil(courses));
    }
}
