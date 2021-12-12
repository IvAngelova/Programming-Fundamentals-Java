package T5Lists.moreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String text = scan.nextLine();
        String output = "";
        for (int i = 0; i <= numbers.size() - 1; i++) {
            int currentNumber = numbers.get(i);
            int sumOfDigits = 0;
            while (currentNumber > 0) {
                sumOfDigits += currentNumber % 10;
                currentNumber /= 10;
            }
            int index = sumOfDigits;
            if (index > text.length() - 1) {
                index -= text.length();
            }
            char symbol = text.charAt(index);
            output += symbol;

            text = text.substring(0, index) + text.substring(index + 1);
        }
        System.out.println(output);
    }
}
