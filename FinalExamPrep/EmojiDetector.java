package FinalExamPrep;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regexCoolThreshold = "\\d";
        Pattern patternThreshold = Pattern.compile(regexCoolThreshold);
        Matcher matcherThreshold = patternThreshold.matcher(input);
        long threshold = 1;
        while (matcherThreshold.find()) {
            threshold *= Integer.parseInt(matcherThreshold.group());
        }
        String regexEmoji = "([:*])\\1[A-Z][a-z]{2,}\\1{2}";
        Pattern patternEmoji = Pattern.compile(regexEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(input);
        int counter = 0;
        List<String> coolEmojis = new ArrayList<>();
        while (matcherEmoji.find()) {
            counter++;
            long coolness = 0;
            String currentEmoji = matcherEmoji.group();
            for (int i = 2; i <= currentEmoji.length() - 3; i++) {
                char currentSymbol = currentEmoji.charAt(i);
                coolness += currentSymbol;
            }
            if (coolness >= threshold) {
                coolEmojis.add(currentEmoji);
            }
        }
        System.out.println("Cool threshold: " + threshold);
        System.out.println(counter + " emojis found in the text. The cool ones are:");
        if (!coolEmojis.isEmpty()) {
            coolEmojis.forEach(emoji -> System.out.println(emoji));
        }
    }
}
