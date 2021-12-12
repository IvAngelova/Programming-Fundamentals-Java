package T7AssociativeArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Arrays.stream(input).
                filter(e -> e.length() % 2 == 0).
                forEach(System.out::println);
        // String [] words = Arrays.stream(sc.nextLine().split(" "))
        //              .filter(w -> w.length() % 2 == 0)
        //              .toArray(String[]::new);
        //  for (String word : words) {
        //  System.out.println(word);
        // }
    }
}
