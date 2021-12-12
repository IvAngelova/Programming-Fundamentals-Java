package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String typeOfCommand = tokens[0];
            String item = tokens[1];
            switch (typeOfCommand) {
                case "Urgent":
                    if (!list.contains(item)) {
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(item)) {
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    if (list.contains(item)) {
                        int indexOldItem = list.indexOf(item);
                        list.set(indexOldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)) {
                        list.remove(item);
                        list.add(item);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ", list));
    }
}
