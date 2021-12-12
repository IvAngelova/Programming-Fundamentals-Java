package T4Methods.moreExercises;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            if (i == 0 || i == 1) {
                array[i] = 1;
            }
            if (i == 2) {
                array[i] = 2;
            }
            if (i > 2) {
                array[i] = array[i - 3] + array[i - 2] + array[i - 1];
            }
        }
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
