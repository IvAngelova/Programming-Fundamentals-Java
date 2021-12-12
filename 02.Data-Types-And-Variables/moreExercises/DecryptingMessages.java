package T2DataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder messageAsStringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char symbol = scan.nextLine().charAt(0);
            char newSymbol = (char) (symbol + key);
            messageAsStringBuilder.append(newSymbol);
        }
        String message = messageAsStringBuilder.toString();
        System.out.println(message);
    }
}
