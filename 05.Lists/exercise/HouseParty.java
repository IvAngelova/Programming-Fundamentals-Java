package T5Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfCommands = Integer.parseInt(scan.nextLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < countOfCommands; i++) {
            String[] command = scan.nextLine().split("\\s+");
            String name = command[0];
            if (command[2].equals("going!")) {
                if (names.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    names.add(name);
                }
            } else if (command[2].equals("not")) {
                if (names.contains(name)) {
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }

    }
}
