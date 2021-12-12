package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "([#@])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int countWordPairs = 0;
        Map<String, String> mirrorWords = new LinkedHashMap<>();
        while (matcher.find()) {
            countWordPairs++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            StringBuilder reversedWordOne = new StringBuilder();
            for (int i = wordOne.length() - 1; i >= 0; i--) {
                char letter = wordOne.charAt(i);
                reversedWordOne.append(letter);
            }
            if (reversedWordOne.toString().equals(wordTwo)) {
                mirrorWords.put(wordOne, wordTwo);
            }
        }
        if (countWordPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(countWordPairs + " word pairs found!");
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            int[] counter = {1};
            mirrorWords.entrySet().stream().forEach(entry -> {
                System.out.print(entry.getKey() + " <=> " + entry.getValue());
                if (counter[0] < mirrorWords.size()) {
                    System.out.print(", ");
                }
                counter[0]++;
            });
        }
    }
}
