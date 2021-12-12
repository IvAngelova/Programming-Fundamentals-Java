package T8TextProcessing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char[] charArr = input.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            characterList.add(charArr[i]);
        }

        for (int i = 1; i <= characterList.size() - 1; i++) {
            char previous = characterList.get(i - 1);
            char current = characterList.get(i);

            if (previous == current) {
                characterList.remove(i);
                i--;
            }
        }
        for (Character character : characterList) {
            System.out.print(character);
        }

        /*
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();

        char previousChar = input.charAt(0);
        sb.append(previousChar);

        for (int i = 1; i < input.length() ; i++) {
            char currentChar = input.charAt(i);
            if(previousChar != currentChar){
                sb.append(currentChar);
            }
            previousChar = currentChar;
        }

        System.out.println(sb.toString());

         */
    }
}
