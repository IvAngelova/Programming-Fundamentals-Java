package FinalExamPrep;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.indexOf(substring) == -1) {
                        System.out.println("Substring not found!");
                    } else {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    }
                    break;
                case "Flip":
                    String typeOfCommand = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    StringBuilder replacement = new StringBuilder();
                    if (typeOfCommand.equals("Lower")) {
                        for (int i = startIndex; i < endIndex; i++) {
                            char symbol = Character.toLowerCase(activationKey.charAt(i));
                            replacement.append(symbol);
                        }
                    } else if (typeOfCommand.equals("Upper")) {
                        for (int i = startIndex; i < endIndex; i++) {
                            char symbol = Character.toUpperCase(activationKey.charAt(i));
                            replacement.append(symbol);
                        }
                    }
                    activationKey.replace(startIndex, endIndex, replacement.toString());
                    System.out.println(activationKey.toString());
                    break;
                case "Slice":
                    int startIndexSlice = Integer.parseInt(tokens[1]);
                    int endIndexSlice = Integer.parseInt(tokens[2]);
                    activationKey.delete(startIndexSlice, endIndexSlice);
                    System.out.println(activationKey.toString());
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey.toString());
    }
}
