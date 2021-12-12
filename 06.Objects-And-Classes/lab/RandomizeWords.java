package T6ObjectsAndClasses.lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        Random rnd = new Random();
        int rndNumber = rnd.nextInt(words.length);
        for (int i = 0; i <= words.length - 1; i++) {
            String temp = words[i];
            words[i] = words[rndNumber];
            words[rndNumber] = temp;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
