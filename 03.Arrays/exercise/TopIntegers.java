package T3Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt((e -> Integer.parseInt(e))).toArray();
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentInt = numbers[index];
            boolean isBigger = true;
            for (int i = index + 1; i <= numbers.length - 1; i++) {
                if (currentInt <= numbers[index + 1]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(currentInt + " ");
            }
        }
    }
}
