package T8TextProcessing.lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] wordsToBan = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String word : wordsToBan) {
            StringBuilder newWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                newWord.append("*");
            }
            text = text.replace(word, newWord);
        }
        System.out.println(text);
    }
}
