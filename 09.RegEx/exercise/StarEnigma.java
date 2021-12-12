package T9RegEx.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String encryptedMessage = scan.nextLine();
            int countSpecialLetters = getSpecialLetters(encryptedMessage);
            String decryptedMessage = getReducedMessage(countSpecialLetters, encryptedMessage);

            String regex = "@(?<planet>[A-Za-z]+)[^!:>@-]*:(?<population>\\d+)[^!:>@-]*!(?<attack>[AD])![^!:>@-]*->(?<count>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String planet = matcher.group("planet");
                String attackType = matcher.group("attack");
                if (attackType.equals("D")) {
                    destroyedPlanets.add(planet);
                } else if (attackType.equals("A")) {
                    attackedPlanets.add(planet);
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        if (!attackedPlanets.isEmpty()) {
            attackedPlanets.forEach(planet -> System.out.println("-> " + planet));
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
        }
    }


    private static String getReducedMessage(int reducedValue, String encryptedMessage) {
        StringBuilder reducedMessage = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentSymbol = encryptedMessage.charAt(i);
            reducedMessage.append((char) (currentSymbol - reducedValue));
        }
        return reducedMessage.toString();
    }

    private static int getSpecialLetters(String encryptedMessage) {
        int count = 0;
        String regexSpecialLetters = "[SsTtAaRr]";
        Pattern pattern = Pattern.compile(regexSpecialLetters);
        Matcher matcher = pattern.matcher(encryptedMessage);

        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
