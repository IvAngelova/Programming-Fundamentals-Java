package T5Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Add")) {
                int wagonToAdd = Integer.parseInt(tokens[1]);
                wagons.add(wagonToAdd);
            } else {
                int passengersToAdd = Integer.parseInt(tokens[0]);
                for (int i = 0; i <= wagons.size() - 1; i++) {
                    int currentWagon = wagons.get(i);
                    if (currentWagon + passengersToAdd <= maxCapacity) {
                        wagons.set(i, currentWagon + passengersToAdd);
                        break;
                    }
                }
            }
            input = scan.nextLine();
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
