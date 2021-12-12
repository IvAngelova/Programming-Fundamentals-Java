package T5Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Contains":
                    int numberToContains = Integer.parseInt(tokens[1]);
                    boolean containsTheNumber = numbers.contains(numberToContains);
                    if (containsTheNumber) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        printEvenNumbers(numbers);
                    } else if (tokens[1].equals("odd")) {
                        printOddNumbers(numbers);
                    }
                    break;
                case "Get":
                    printSumOfElements(numbers);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int numberToFilter = Integer.parseInt(tokens[2]);
                    printFilteredListElements(numbers, condition, numberToFilter);
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void printFilteredListElements(List<Integer> numbers, String condition, int numberToFilter) {

        if (condition.equals(">")) {
            for (Integer number : numbers) {
                if (number > numberToFilter) {
                    System.out.print(number + " ");
                }
            }
        } else if (condition.equals("<")) {
            for (Integer number : numbers) {
                if (number < numberToFilter) {
                    System.out.print(number + " ");
                }
            }
        } else if (condition.equals(">=")) {
            for (Integer number : numbers) {
                if (number >= numberToFilter) {
                    System.out.print(number + " ");
                }
            }
        } else if (condition.equals("<=")) {
            for (Integer number : numbers) {
                if (number <= numberToFilter) {
                    System.out.print(number + " ");
                }
            }
        }
        System.out.println();
    }

    private static void printSumOfElements(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    private static void printOddNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printEvenNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }


}
