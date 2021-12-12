package T7AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> symbolsInText = new LinkedHashMap<>();
        for (int i = 0; i <= input.length() - 1; i++) {
            char currentLetter = input.charAt(i);
            if (currentLetter == ' ') {
                continue;
            }
            if (!symbolsInText.containsKey(currentLetter)) {
                symbolsInText.put(currentLetter, 1);
            } else {
                symbolsInText.put(currentLetter, symbolsInText.get(currentLetter) + 1);
            }
        }
        symbolsInText.forEach((k, v) -> System.out.println(k + " -> " + v));

        /*for (Map.Entry<Character, Integer> entry : symbolsInText.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }*/
    }
}
