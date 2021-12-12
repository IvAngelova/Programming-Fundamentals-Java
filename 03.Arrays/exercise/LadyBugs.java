package T3Arrays.exercise;

import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] field = new int[fieldSize];
        String[] indexesWithLadyBugs = scan.nextLine().split(" ");
        for (int i = 0; i <= indexesWithLadyBugs.length - 1; i++) {
            int bugIndex = Integer.parseInt(indexesWithLadyBugs[i]);
            if (bugIndex >= 0 && bugIndex < fieldSize) {
                field[bugIndex] = 1;
            }
        }
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] directionCommand = command.split(" ");
            int index = Integer.parseInt(directionCommand[0]);
            String direction = directionCommand[1];
            int length = Integer.parseInt(directionCommand[2]);
            if (index < 0 || index >= fieldSize || field[index] == 0) {
                command = scan.nextLine();
                continue;
            }
            field[index] = 0;
            if (direction.equals("right")) {
                index += length;
                //flight
                while (index < fieldSize && field[index] == 1) {
                    index += length;
                }
                if (index < fieldSize) {
                    field[index] = 1;
                }
            } else {
                index -= length;
                while (index >= 0 && field[index] == 1) {
                    index -= length;
                }
                if (index >= 0) {
                    field[index] = 1;
                }
            }
            command = scan.nextLine();
        }
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(field[i] + " ");
        }
    }
}
