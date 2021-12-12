package T3Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //създаване на първи масив от интове
        int[] array1 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        //създаване на втори масив от интове
        String[] input = scan.nextLine().split(" ");
        int[] array2 = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array2[i] = Integer.parseInt(input[i]);
        }
        int sum = 0;
        boolean areIdentical = true;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                areIdentical = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
            sum += array1[i];
        }
        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
