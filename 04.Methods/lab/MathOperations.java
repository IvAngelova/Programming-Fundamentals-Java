package T4Methods.lab;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int number2 = Integer.parseInt(scan.nextLine());
        System.out.printf("%.0f", calculate(number1, operator, number2));
    }

    private static double calculate(int number1, String operator, int number2) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = Math.abs(number1 - number2);
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 * 1.00 / number2;
                break;
        }
        return result;
    }
}
