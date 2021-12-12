package T3Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        boolean isFound = false;
        for (int index = 0; index <= numbers.length - 1; index++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < index; j++) {
                leftSum += numbers[j];
            }
            for (int i = index + 1; i <= numbers.length - 1; i++) {
                rightSum += numbers[i];
            }
            if (leftSum == rightSum) {
                isFound = true;
                System.out.println(index);
            }
        }
        if (!isFound) {
            System.out.println("no");
        }
    }
}
