package T9RegEx.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "(?<text>[^\\d]+)(?<number>\\d{1,2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder output = new StringBuilder();
        StringBuilder uniqueSymbols = new StringBuilder();
        while (matcher.find()) {
            String symbolsToRepeat = matcher.group("text").toUpperCase();
            int repeatNumber = Integer.parseInt(matcher.group("number"));

            for (int i = 0; i < repeatNumber; i++) {
                output.append(symbolsToRepeat);
            }
            if (repeatNumber > 0) {
                for (int i = 0; i < symbolsToRepeat.length(); i++) {
                    char currentSymbol = symbolsToRepeat.charAt(i);
                    if (uniqueSymbols.indexOf(Character.toString(currentSymbol)) == -1) {
                        uniqueSymbols.append(currentSymbol);
                    }
                }
            }
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.length());
        System.out.println(output.toString());
    }
}
