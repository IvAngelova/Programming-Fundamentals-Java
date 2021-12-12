package FinalExamPrep;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String text = encryptedMessage.substring(0, numberOfLetters);
                    encryptedMessage.delete(0, numberOfLetters);
                    encryptedMessage.append(text);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    encryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    String result = encryptedMessage.toString().replace(substring, replacement);
                    encryptedMessage = new StringBuilder(result);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage.toString());
    }
}
