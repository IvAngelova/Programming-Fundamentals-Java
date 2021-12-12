package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startNum = Integer.parseInt(scan.nextLine());
        int endNum = Integer.parseInt(scan.nextLine());
        for (int i = startNum; i <= endNum; i++) {
            System.out.printf("%c ", i);
        }

    }
}
