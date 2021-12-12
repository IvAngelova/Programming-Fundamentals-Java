package T5Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListsManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] typeOfCommand = command.split(" ");
            switch (typeOfCommand[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(typeOfCommand[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(typeOfCommand[1]);
                    numbers.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(typeOfCommand[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(typeOfCommand[1]);
                    int indexToInsert = Integer.parseInt(typeOfCommand[2]);
                    numbers.add(indexToInsert, numberToInsert);
                    break;
            }
            command = scan.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

}
