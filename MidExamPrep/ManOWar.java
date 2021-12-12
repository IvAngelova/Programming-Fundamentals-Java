package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxHealthCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        boolean isWon = false;
        boolean isLost = false;
        label:
        while (!input.equals("Retire")) {
            String command = input.split("\\s+")[0];
            switch (command) {
                case "Fire":
                    int indexFire = Integer.parseInt(input.split("\\s+")[1]);
                    int damage = Integer.parseInt(input.split("\\s+")[2]);
                    if (isValidIndex(indexFire, warShip.size())) {
                        warShip.set(indexFire, warShip.get(indexFire) - damage);
                        if (warShip.get(indexFire) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isWon = true;
                            break label;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int endIndex = Integer.parseInt(input.split("\\s+")[2]);
                    int damageDefend = Integer.parseInt(input.split("\\s+")[3]);
                    if (isValidIndex(startIndex, pirateShip.size()) &&
                            isValidIndex(endIndex, pirateShip.size())) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip.set(i, pirateShip.get(i) - damageDefend);
                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isLost = true;
                                break label;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(input.split("\\s+")[1]);
                    int health = Integer.parseInt(input.split("\\s+")[2]);
                    if (isValidIndex(indexRepair, pirateShip.size())) {
                        pirateShip.set(indexRepair, pirateShip.get(indexRepair) + health);
                        if (pirateShip.get(indexRepair) > maxHealthCapacity) {
                            pirateShip.set(indexRepair, maxHealthCapacity);
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        if (pirateShip.get(i) < (0.2 * maxHealthCapacity)) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }

            input = scan.nextLine();
        }
        if (!isLost && !isWon) {
            int pirateShipSum = 0;
            int warShipSum = 0;
            for (Integer section : warShip) {
                warShipSum += section;
            }
            for (Integer section : pirateShip) {
                pirateShipSum += section;
            }
            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d", warShipSum);
        }

    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
