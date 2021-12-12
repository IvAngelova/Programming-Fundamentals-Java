package MidExamPrep;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int bitcoins = 0;
        int initialHealth = 100;
        boolean isDead = false;
        label:
        for (int indexRoom = 0; indexRoom <= rooms.length - 1; indexRoom++) {
            String[] currentRoom = rooms[indexRoom].split("\\s+");
            String command = currentRoom[0];
            int number = Integer.parseInt(currentRoom[1]);
            switch (command) {
                case "potion":
                    if (number + initialHealth <= 100) {
                        initialHealth += number;
                    } else {
                        number = 100 - initialHealth;
                        initialHealth = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", initialHealth);
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n", number);
                    bitcoins += number;
                    break;
                default:
                    initialHealth -= number;
                    if (initialHealth <= 0) {
                        isDead = true;
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.println("Best room: " + (indexRoom + 1));
                        break label;
                    } else {
                        System.out.printf("You slayed %s.%n", command);
                    }
                    break;
            }
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", initialHealth);
        }
    }
}
