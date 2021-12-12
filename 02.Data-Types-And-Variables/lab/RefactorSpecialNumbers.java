package T2DataTypesAndVariables.lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int num = 1; num <= n; num++) {
            int currentNum = num;
            int sum = 0;
            while (currentNum > 0) {
                sum += currentNum % 10;
                currentNum = currentNum / 10;
            }
            boolean isSpecialNumber = false;
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                isSpecialNumber = true;
            }
            System.out.printf("%d -> %b%n", num, isSpecialNumber);
        }
    }
}
