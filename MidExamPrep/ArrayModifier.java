package MidExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            String typeOfCommand = command[0];
            switch (typeOfCommand) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    int temp = array[index1];
                    array[index1] = array[index2];
                    array[index2] = temp;
                    break;
                case "multiply":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    array[firstIndex] = array[firstIndex] * array[secondIndex];
                    break;
                case "decrease":
                    for (int i = 0; i <= array.length - 1; i++) {
                        array[i] = array[i] - 1;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}
