package T8TextProcessing.lab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : array) {
            for (int i = 0; i < word.length(); i++) {
                result.append(word);
            }
        }
        System.out.println(result.toString());
    }
}
