package T8TextProcessing.moreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstSymbol = scan.nextLine().charAt(0);
        char secondSymbol = scan.nextLine().charAt(0);
        String text = scan.nextLine();
        int sum = 0;
        if (firstSymbol < secondSymbol) {
            for (int i = 0; i < text.length(); i++) {
                char currentSymbol = text.charAt(i);
                if (currentSymbol > firstSymbol && currentSymbol < secondSymbol) {
                    sum += currentSymbol;
                }
            }
        } else {
            for (int i = 0; i < text.length(); i++) {
                char currentSymbol = text.charAt(i);
                if (currentSymbol < firstSymbol && currentSymbol > secondSymbol) {
                    sum += currentSymbol;
                }
            }
        }
        System.out.println(sum);
    }
}
