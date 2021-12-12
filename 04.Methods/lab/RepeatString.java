package T4Methods.lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        String repeatedString = repeatString(input, count);
        System.out.println(repeatedString);
    }

    private static String repeatString(String input, int count) {
        StringBuilder resultAsStringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resultAsStringBuilder.append(input);
        }
        String result = resultAsStringBuilder.toString();
        return result;
    }
}
