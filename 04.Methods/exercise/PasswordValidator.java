package T4Methods.exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        if (!countOfCharactersCheck(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!checkPasswordContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!checkCountOfDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (countOfCharactersCheck(password) && checkPasswordContent(password) && checkCountOfDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean checkCountOfDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                count++;
            }
        }
        return (count >= 2);
    }

    private static boolean checkPasswordContent(String password) {
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (!(currentSymbol >= 48 && currentSymbol <= 57) && !(currentSymbol >= 65 && currentSymbol <= 90)
                    && !(currentSymbol >= 97 && currentSymbol <= 122)) {
                return false;
            }
        }
        return true;
    }

    private static boolean countOfCharactersCheck(String password) {
        return (password.length() >= 6 && password.length() <= 10);
    }
}
