package T3Arrays.exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] array1 = new String[n];
        String[] array2 = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String firstNum = input[0];
            String secondNum = input[1];
            if (i % 2 == 0) {
                array1[i] = firstNum;
                array2[i] = secondNum;
            } else {
                array1[i] = secondNum;
                array2[i] = firstNum;
            }
        }
        System.out.println(String.join(" ", array1));
        System.out.println(String.join(" ", array2));
    }
}
