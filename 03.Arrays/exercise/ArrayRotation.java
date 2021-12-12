package T3Arrays.exercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String firstElement = array[0];
            for (int j = 0; j <= (array.length - 1) - 1; j++) { //стойността на последния елемент не трябва да се променя
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", array));
    }
}
