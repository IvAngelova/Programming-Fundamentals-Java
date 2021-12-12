package T2DataTypesAndVariables.moreExercises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int openingBracketsCounter = 0;
        int closingBracketsCounter = 0;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            if (input.equals("(")) {
                openingBracketsCounter++;
            } else if (input.equals(")")) {
                closingBracketsCounter++;
                if (openingBracketsCounter - closingBracketsCounter != 0) {
                    break;
                }
            }
        }
        if (openingBracketsCounter == closingBracketsCounter) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
