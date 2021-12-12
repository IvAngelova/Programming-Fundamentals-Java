package T7AssociativeArrays.lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Map<String, Integer> words = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            String currentWord = input[i].toLowerCase();
            if (!words.containsKey(currentWord)) {
                words.put(currentWord, 0);
            }
            words.put(currentWord, words.get(currentWord) + 1);
        }
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                output.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", output));
    }
}
