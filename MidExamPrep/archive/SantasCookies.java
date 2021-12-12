package MidExamPrep.archive;

import java.util.Scanner;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amountOfBatches = Integer.parseInt(scan.nextLine());
        int singleCookieInGrams = 25;
        int cup = 140;
        int smallSpoon = 10;
        int bigSpoon = 20;
        int cookiesPerBox = 5;

        int totalBoxes = 0;
        for (int i = 0; i < amountOfBatches; i++) {
            int flourInGrams = Integer.parseInt(scan.nextLine());
            int sugarInGrams = Integer.parseInt(scan.nextLine());
            int cocoaInGrams = Integer.parseInt(scan.nextLine());

            int flourCups = flourInGrams / cup;
            int sugarSpoons = sugarInGrams / bigSpoon;
            int cocoaSpoons = cocoaInGrams / smallSpoon;
            int total = Math.min(flourCups, sugarSpoons);

            if (flourCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
                continue;
            } else {
                double totalCookiesPerBake =
                        Math.floor(((cup + smallSpoon + bigSpoon) *
                                Math.min(total, cocoaSpoons)) * 1.0 /
                                singleCookieInGrams);
                double boxesPerBatch = Math.floor(totalCookiesPerBake / cookiesPerBox);
                totalBoxes += boxesPerBatch;

                System.out.printf("Boxes of cookies: %.0f%n", boxesPerBatch);
            }
        }
        System.out.printf("Total boxes: %d", totalBoxes);
    }

}


