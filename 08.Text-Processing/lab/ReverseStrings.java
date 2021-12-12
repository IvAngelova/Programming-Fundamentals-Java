package T8TextProcessing.lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        while (!word.equals("end")) {
            StringBuilder reversed = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                char symbol = word.charAt(i);
                reversed.append(symbol);
            }
            System.out.println(word + " = " + reversed);
            word = scan.nextLine();
        }
    }
}
