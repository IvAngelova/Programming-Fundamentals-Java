package T8TextProcessing.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regexName = "@(?<name>[A-Za-z]+)\\|";
        String regexAge = "#(?<age>[0-9]+)\\*";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternAge = Pattern.compile(regexAge);
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherAge = patternAge.matcher(input);
            if (matcherAge.find() && matcherName.find()) {
                System.out.printf("%s is %d years old.%n",
                        matcherName.group("name"), Integer.parseInt(matcherAge.group("age")));
            }
        }
    }
}
