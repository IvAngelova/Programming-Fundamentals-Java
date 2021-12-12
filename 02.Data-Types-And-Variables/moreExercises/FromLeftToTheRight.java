package T2DataTypesAndVariables.moreExercises;


import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            long[] array = new long[input.length];
            for (int j = 0; j < input.length; j++) {
                array[j] = Long.parseLong(input[j]);
            }
            long leftNum = array[0];
            long rightNum = array[1];
            int leftSum = 0;
            int rightSum = 0;
            if (leftNum > rightNum) {
                while (leftNum != 0) {
                    leftSum += leftNum % 10;
                    leftNum /= 10;
                }
            } else {
                while (rightNum != 0) {
                    rightSum += rightNum % 10;
                    rightNum /= 10;
                }
            }
            if (array[0] > array[1]) {
                System.out.println(Math.abs(leftSum));
            } else {
                System.out.println(Math.abs(rightSum));
            }
        }
    }

}


