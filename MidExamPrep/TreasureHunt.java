package MidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> items = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i <= tokens.length - 1; i++) {
                        String currentItem = tokens[i];
                        if (!items.contains(currentItem)) {
                            items.add(0, currentItem);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= items.size() - 1) {
                        String item = items.get(index);
                        items.remove(index);
                        items.add(item);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    if (items.size() < count) {
                        count = items.size();
                    }
                    List<String> stealItems = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        stealItems.add(items.get(items.size() - 1));
                        items.remove(items.get(items.size() - 1));
                    }
                    Collections.reverse(stealItems);
                    System.out.println(String.join(", ", stealItems));
                    break;
            }
            input = scan.nextLine();
        }
        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sumLengthItems = 0.0;
            for (int i = 0; i < items.size(); i++) {
                sumLengthItems += items.get(i).length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", sumLengthItems / items.size());
        }
    }
}
