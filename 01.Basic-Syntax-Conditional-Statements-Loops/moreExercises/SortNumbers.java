package T1BasicSyntaxConditionalStatementsAndLoops.moreExercises;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());
        int largest = Math.max(Math.max(n1, n2), n3);
        if (largest == n3) {
            System.out.println(n3);
            System.out.println(Math.max(n1, n2));
            System.out.println(Math.min(n1, n2));
        } else if (largest == n2) {
            System.out.println(n2);
            System.out.println(Math.max(n1, n3));
            System.out.println(Math.min(n1, n3));
        } else {
            System.out.println(n1);
            System.out.println(Math.max(n2, n3));
            System.out.println(Math.min(n2, n3));
        }
    }
}
