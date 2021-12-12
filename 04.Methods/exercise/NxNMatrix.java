package T4Methods.exercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        printNxNMatrix(number);
    }

    private static void printNxNMatrix(int number) {
        for (int rowsCount = 0; rowsCount < number; rowsCount++) {
            for (int rowContent = 0; rowContent < number; rowContent++) {
                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }
}
