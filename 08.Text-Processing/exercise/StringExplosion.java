package T8TextProcessing.exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scan.nextLine());
        int strengthOfExplosion = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '>') {
                strengthOfExplosion += Integer.parseInt(Character.toString(sb.charAt(i + 1)));
                //strengthOfExplosion += Character.getNumericValue(sb.charAt(i + 1));
            } else if (strengthOfExplosion > 0 && sb.charAt(i) != '>') {
                sb.deleteCharAt(i);
                i--;
                strengthOfExplosion--;
            }
        }
        System.out.println(sb.toString());

        /*
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder(scan.nextLine());
        int power = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                sb.append(">");
            } else if (power == 0) {
                sb.append(currentChar);
            } else {
                power--;
            }
        }
        System.out.println(sb);
        */
    }
}
