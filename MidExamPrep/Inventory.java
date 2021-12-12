package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("Craft!")) {
            String typeOfCommand = command.split(" - ")[0];
            String item = command.split(" - ")[1];
            switch (typeOfCommand) {
                case "Collect":
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    if (items.contains(item)) {
                        items.remove(item);
                    }
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (items.contains(oldItem)) {
                        int indexOldItem = items.indexOf(oldItem);
                        items.add(indexOldItem + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(String.join(", ", items));

    }
}
