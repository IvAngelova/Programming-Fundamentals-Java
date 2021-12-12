package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int entryPoint = Integer.parseInt(scan.nextLine());
        String typeOfItems = scan.nextLine();
        int sumLeft = 0;
        int sumRight = 0;
        int entryPointItem = array[entryPoint];
        if (typeOfItems.equals("cheap")) {
            for (int i = 0; i < entryPoint; i++) {
                if (array[i] < entryPointItem) {
                    sumLeft += array[i];
                }
            }
            for (int i = entryPoint + 1; i <= array.length - 1; i++) {
                if (array[i] < entryPointItem) {
                    sumRight += array[i];
                }
            }

        } else if (typeOfItems.equals("expensive")) {
            for (int i = 0; i < entryPoint; i++) {
                if (array[i] >= entryPointItem) {
                    sumLeft += array[i];
                }
            }
            for (int i = entryPoint + 1; i <= array.length - 1; i++) {
                if (array[i] >= entryPointItem) {
                    sumRight += array[i];
                }
            }

        }
        if (sumLeft == sumRight) {
            System.out.printf("Left - %d", sumLeft);
        } else if (sumLeft > sumRight) {
            System.out.printf("Left - %d", sumLeft);
        } else if (sumLeft < sumRight) {
            System.out.printf("Right - %d", sumRight);
        }


    }
}
