package T3Arrays.exercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array1 = scan.nextLine().split(" ");
        String[] array2 = scan.nextLine().split(" ");
        for (int i = 0; i <= array2.length - 1; i++) {
            for (int j = 0; j <= array1.length - 1; j++) {
                if (array2[i].equals(array1[j])) {
                    System.out.print(array2[i] + " ");
                }
            }

        }
    }
}
