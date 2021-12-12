package T3Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        String[] splittedInput = inputLine.split(" ");
        int[] arrayNumbers = Arrays.stream(splittedInput).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumEven = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] % 2 == 0) {
                sumEven += arrayNumbers[i];
            }
        }
        System.out.println(sumEven);
    }
}
