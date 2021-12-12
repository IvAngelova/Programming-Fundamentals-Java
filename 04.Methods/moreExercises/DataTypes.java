package T4Methods.moreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
            case "int":
                int number = Integer.parseInt(scan.nextLine());
                printResult(number);
                break;
            case "real":
                double num = Double.parseDouble(scan.nextLine());
                printResult(num);
                break;
            case "string":
                String text = scan.nextLine();
                printResult(text);
                break;
        }
    }

    private static void printResult(int number) {
        System.out.println(number * 2);
    }

    private static void printResult(double number) {
        System.out.printf("%.2f", number * 1.5);
    }

    private static void printResult(String text) {
        System.out.printf("$%s$", text);
    }

}
