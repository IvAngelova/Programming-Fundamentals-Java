package FinalExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String barcode = scan.nextLine();
            String regexBarcode = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
            Pattern patternBarcode = Pattern.compile(regexBarcode);
            Matcher matcherBarcode = patternBarcode.matcher(barcode);
            if (matcherBarcode.find()) {
                String regexDigits = "\\d";
                Pattern patternDigits = Pattern.compile(regexDigits);
                Matcher matcherDigits = patternDigits.matcher(matcherBarcode.group());
                StringBuilder group = new StringBuilder();
                while (matcherDigits.find()) {
                    group.append(matcherDigits.group());
                }
                if (group.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", group.toString());
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
