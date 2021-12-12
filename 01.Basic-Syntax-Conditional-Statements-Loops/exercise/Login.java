package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = username.length() - 1; i >= 0; i--) {
            char symbol = username.charAt(i);
            passwordBuilder.append(symbol);
        }
        String password = passwordBuilder.toString();
        String input = scan.nextLine();
        int count = 0;
        boolean isBlocked = false;
        while (!input.equals(password)) {
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                isBlocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scan.nextLine();
        }
        if (!isBlocked) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
