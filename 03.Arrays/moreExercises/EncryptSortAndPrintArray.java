package T3Arrays.moreExercises;

import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int totalNameSum = 0;
            for (int nameIndex = 0; nameIndex <= name.length() - 1; nameIndex++) {
                char letter = name.charAt(nameIndex);
                int currentIndexSum = 0;
                if (letter == 'a' || letter == 'o' || letter == 'u' || letter == 'e' || letter == 'i'
                        || letter == 'A' || letter == 'O' || letter == 'U'
                        || letter == 'E' || letter == 'I') {
                    currentIndexSum = letter * name.length();
                } else {
                    currentIndexSum = letter / name.length();
                }
                totalNameSum += currentIndexSum;
            }
            array[i] = totalNameSum;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
