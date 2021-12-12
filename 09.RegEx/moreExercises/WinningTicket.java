package T9RegEx.moreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tickets = input.split(", ");

        for (String ticket : tickets) {
            ticket = ticket.trim();
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String leftHalf = ticket.substring(0, 10);
                String rightHalf = ticket.substring(10);

                String firstResult = getResult(leftHalf);
                String secondResult = getResult(rightHalf);
                if (firstResult.length() == 0 || secondResult.length() == 0) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                } else {
                    if ((firstResult.length() == 10) && (secondResult.length() == 10)) {
                        System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, firstResult.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n", ticket, Math.min(firstResult.length(), secondResult.length()), firstResult.charAt(0));
                    }
                }
            }
        }
    }

    private static String getResult(String half) {
        String regex = "[@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(half);
        String result = "";
        if (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }

}



