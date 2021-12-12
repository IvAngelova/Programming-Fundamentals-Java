package FinalExamPrep;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i <= text.length() - 1; i += 2) {
                        char symbol = text.charAt(i);
                        sb.append(symbol);
                    }
                    text = sb.toString();
                    System.out.println(text);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    text = text.substring(0, index) + text.substring(index + length);
                    System.out.println(text);
                    /*
                    int start = Integer.parseInt(commands[1]);
                int end = start + Integer.parseInt(commands[2]);
                password = new StringBuilder(password)
                        .delete(start, end).toString();
                System.out.println(password);
                     */
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (text.contains(substring)) {
                        text = text.replace(substring, substitute);
                        System.out.println(text);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }


            input = scan.nextLine();
        }
        System.out.println("Your password is: " + text);
    }
}
