package T7AssociativeArrays.lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            if (!synonymDictionary.containsKey(word)) {
                List<String> synonyms = new ArrayList<>();
                synonyms.add(synonym);
                synonymDictionary.put(word, synonyms);
            } else {
                synonymDictionary.get(word).add(synonym);
            }
        }
        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
