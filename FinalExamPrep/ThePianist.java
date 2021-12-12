package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> piecesComposer = new LinkedHashMap<>();
        Map<String, String> piecesKeys = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            piecesComposer.put(piece, composer);
            piecesKeys.put(piece, key);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split("\\|")[0];
            String piece = input.split("\\|")[1];
            switch (command) {
                case "Add":
                    String composer = input.split("\\|")[2];
                    String key = input.split("\\|")[3];
                    if (!piecesComposer.containsKey(piece)) {
                        piecesComposer.put(piece, composer);
                        piecesKeys.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    if (piecesComposer.containsKey(piece)) {
                        piecesComposer.remove(piece);
                        piecesKeys.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = input.split("\\|")[2];
                    if (piecesKeys.containsKey(piece)) {
                        piecesKeys.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        piecesComposer.entrySet().stream()
                .sorted((e1, e2) -> {
                    int result = e1.getKey().compareTo(e2.getKey());
                    if (result == 0) {
                        result = e1.getValue().compareTo(e2.getValue());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        e.getKey(), e.getValue(), piecesKeys.get(e.getKey())));
    }
}
