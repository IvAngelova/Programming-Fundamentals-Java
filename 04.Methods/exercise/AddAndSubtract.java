package T4Methods.exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());
        int sum = getSum(n1, n2);
        int result = subtract(sum, n3);
        System.out.println(result);
    }

    private static int subtract(int sum, int n3) {
        return sum - n3;
    }

    private static int getSum(int n1, int n2) {
        return n1 + n2;
    }
}
