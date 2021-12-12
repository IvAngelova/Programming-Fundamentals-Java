package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int rows = 1; rows <= n; rows++) {
            for (int count = 1; count <= rows; count++) {
                System.out.print(rows + " ");
            }
            System.out.println();
        }
    }
}
