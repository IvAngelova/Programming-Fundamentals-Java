package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        int countBlacklistedNames = 0;
        int countLostNames = 0;
        while (!input.equals("Report")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Blacklist":
                    String name = tokens[1];
                    if (names.contains(name)) {
                        int indexName = names.indexOf(name);
                        names.set(indexName, "Blacklisted");
                        countBlacklistedNames++;
                        System.out.printf("%s was blacklisted.%n", name);
                    } else {
                        System.out.printf("%s was not found.%n", name);
                    }
                    break;
                case "Error":
                    int indexError = Integer.parseInt(tokens[1]);
                    if (isValidIndex(indexError, names.size())) {
                        if (!(names.get(indexError).equals("Blacklisted")) &&
                                !(names.get(indexError).equals("Lost"))) {
                            String oldName = names.get(indexError);
                            names.set(indexError, "Lost");
                            countLostNames++;
                            System.out.printf("%s was lost due to an error.%n", oldName);
                        }
                    }
                    break;
                case "Change":
                    int indexChange = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];
                    if (isValidIndex(indexChange, names.size())) {
                        String currentName = names.get(indexChange);
                        names.set(indexChange, newName);
                        System.out.printf("%s changed his username to %s.%n", currentName, newName);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", countBlacklistedNames);
        System.out.printf("Lost names: %d%n", countLostNames);
        System.out.println(String.join(" ", names));
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
