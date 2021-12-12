package T1BasicSyntaxConditionalStatementsAndLoops.moreExercises;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String numberAsString = scan.nextLine();
            int length = numberAsString.length();
            int number = Integer.parseInt(numberAsString);
            int mainDigit = number % 10;
            if (mainDigit == 0) {
                System.out.printf("%c", 32);
                continue;
            }
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 9 || mainDigit == 8) {
                offset = offset + 1;
            }
            int letterIndex = (offset + length - 1);
            System.out.printf("%c", 97 + letterIndex);
        }
    }
}
