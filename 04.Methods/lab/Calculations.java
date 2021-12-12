package T4Methods.lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        if (command.equals("add")) {
            add(number1, number2);
        } else if (command.equals("multiply")) {
            multiply(number1, number2);
        } else if (command.equals("divide")) {
            divide(number1, number2);
        } else if (command.equals("subtract")) {
            subtract(number1, number2);
        }
    }

    private static void divide(int number1, int number2) {
        System.out.println(number1 / number2);
    }

    private static void subtract(int number1, int number2) {
        System.out.println(Math.abs(number1 - number2));
    }

    private static void multiply(int number1, int number2) {
        System.out.println(number1 * number2);
    }

    private static void add(int number1, int number2) {
        System.out.println(number1 + number2);
    }
}
