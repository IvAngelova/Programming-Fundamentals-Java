package T4Methods.lab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
            case "int":
                int firstNum = Integer.parseInt(scan.nextLine());
                int secondNum = Integer.parseInt(scan.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;
            case "char":
                char first = scan.nextLine().charAt(0);
                char second = scan.nextLine().charAt(0);
                System.out.println(getMax(first, second));
                break;
            case "string":
                String firstStr = scan.nextLine();
                String secondStr = scan.nextLine();
                System.out.println(getMax(firstStr, secondStr));
                break;
        }
    }

    private static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
    }

    private static String getMax(String firstStr, String secondStr) {
        if (firstStr.compareTo(secondStr) > 0) {
            return firstStr;
        } else {
            return secondStr;
        }

    }

    private static char getMax(char first, char second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
}
