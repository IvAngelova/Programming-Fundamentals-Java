package T9RegEx.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        String regexFirstPart = "([#$%*&]{1})(?<capitalLetters>[A-Z]+)\\1";
        Pattern patternFirstPart = Pattern.compile(regexFirstPart);
        String firstPart = input[0];
        Matcher matcherFirstPart = patternFirstPart.matcher(firstPart);
        StringBuilder capitalLetters = new StringBuilder();
        if (matcherFirstPart.find()) {
            capitalLetters.append(matcherFirstPart.group("capitalLetters"));
        }
        String regexSecondPart = "(?<asciiCode>\\d{2}):(?<length>\\d{2})";
        Pattern patternSecondPart = Pattern.compile(regexSecondPart);
        String secondPart = input[1];

        for (int i = 0; i < capitalLetters.length(); i++) {
            char currentLetter = capitalLetters.charAt(i);
            int length = 0;
            //update matcher in the for-loop
            Matcher matcherSecondPart = patternSecondPart.matcher(secondPart);
            while (matcherSecondPart.find()) {
                char letter = (char) (Integer.parseInt(matcherSecondPart.group("asciiCode")));
                if (currentLetter == letter) {
                    length = Integer.parseInt(matcherSecondPart.group("length")) + 1;
                    break;
                }
            }
            String regexThirdPart = Character.toString(currentLetter);
            Pattern patternThirdPart = Pattern.compile(regexThirdPart);
            String thirdPart = input[2];
            String[] partsOfThirdPart = thirdPart.split("\\s+");
            for (int index = 0; index < partsOfThirdPart.length; index++) {
                String currentWord = partsOfThirdPart[index];
                Matcher matcherThirdPart = patternThirdPart.matcher(currentWord);
                if (matcherThirdPart.find()) {
                    if (currentWord.charAt(0) == currentLetter && currentWord.length() == length) {
                        System.out.println(currentWord);
                    }
                }

            }
        }
    }
}




