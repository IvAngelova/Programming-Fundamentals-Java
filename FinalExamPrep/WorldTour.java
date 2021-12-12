package FinalExamPrep;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("Travel")) {
            String command = input.split(":")[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split(":")[1]);
                    String string = input.split(":")[2];
                    if (isValidIndex(index, text.length())) {
                        text.insert(index, string);
                    }
                    System.out.println(text.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split(":")[1]);
                    int endIndex = Integer.parseInt(input.split(":")[2]);
                    if (isValidIndex(startIndex, text.length()) && isValidIndex(endIndex, text.length())) {
                        text.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(text.toString());
                    break;
                case "Switch":
                    String oldString = input.split(":")[1];
                    String newString = input.split(":")[2];
                    if (text.indexOf(oldString) != -1) {
                        String result = text.toString().replace(oldString, newString);
                        text = new StringBuilder(result);
                    }
                    System.out.println(text.toString());
                    break;

            }
            input = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + text.toString());
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
