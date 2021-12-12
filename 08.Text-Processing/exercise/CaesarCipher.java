package T8TextProcessing.exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            encryptedText.append((char) (currentSymbol + 3));
        }
        System.out.println(encryptedText.toString());
    }
}
