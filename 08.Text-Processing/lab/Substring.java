package T8TextProcessing.lab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wordToRemove = scan.nextLine();
        String text = scan.nextLine();
        while (text.contains(wordToRemove)) {
            text = text.replace(wordToRemove, "");
        }
        System.out.println(text);
    }
}
