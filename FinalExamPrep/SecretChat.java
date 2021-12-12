package FinalExamPrep;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    concealedMessage.insert(index, " ");
                    System.out.println(concealedMessage.toString());
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (concealedMessage.indexOf(substring) != -1) {
                        int start = concealedMessage.indexOf(substring);
                        int end = concealedMessage.indexOf(substring) + substring.length();
                        concealedMessage.delete(start, end);
                        StringBuilder reversedSubstring = new StringBuilder(substring);
                        reversedSubstring.reverse();
                        for (int i = 0; i < reversedSubstring.length(); i++) {
                            char symbol = reversedSubstring.charAt(i);
                            concealedMessage.append(symbol);
                        }
                        System.out.println(concealedMessage.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substringChange = tokens[1];
                    String replacement = tokens[2];
                    String result = concealedMessage.toString().replace(substringChange, replacement);
                    concealedMessage = new StringBuilder(result);
                    System.out.println(concealedMessage.toString());
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("You have a new text message: " + concealedMessage.toString());
    }
}
