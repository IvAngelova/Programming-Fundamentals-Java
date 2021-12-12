package T1BasicSyntaxConditionalStatementsAndLoops.moreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder textReversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            char letter = text.charAt(i);
            textReversed.append(letter);
        }
        String textReversedAsString = textReversed.toString();
        System.out.println(textReversedAsString);
    }
}
