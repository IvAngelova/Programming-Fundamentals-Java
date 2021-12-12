package T7AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scan.nextLine());
        Map<String, String> parkingLot = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String username = tokens[1];
            if (command.equals("register")) {
                String carNumber = tokens[2];
                if (!parkingLot.containsKey(username)) {
                    parkingLot.put(username, carNumber);
                    System.out.printf("%s registered %s successfully%n", username, carNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", parkingLot.get(username));
                }
            } else if (command.equals("unregister")) {
                if (!parkingLot.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    parkingLot.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }
        parkingLot.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
