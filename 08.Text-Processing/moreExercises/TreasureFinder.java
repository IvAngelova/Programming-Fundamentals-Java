package T8TextProcessing.moreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] key = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("find")) {
            int indexKey = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                currentSymbol -= key[indexKey];
                indexKey++;
                if (indexKey > key.length - 1) {
                    indexKey = 0;
                }
                sb.append(currentSymbol);
            }
            int startIndexType = sb.indexOf("&");
            int endIndexType = sb.lastIndexOf("&");
            String type = sb.substring(startIndexType + 1, endIndexType);
            int startIndexCoordinates = sb.indexOf("<");
            int endIndexCoordinates = sb.indexOf(">");
            String coordinates = sb.substring(startIndexCoordinates + 1, endIndexCoordinates);
            System.out.printf("Found %s at %s%n", type, coordinates);

            input = scan.nextLine();
        }
    }
}
