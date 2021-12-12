package T7AssociativeArrays.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbers = new TreeMap<>();

        for (double number : input) {
            if (!numbers.containsKey(number)) {
                numbers.put(number, 1);
            } else {
                int occurrences = numbers.get(number);
                occurrences++;
                numbers.put(number, occurrences);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());

        }

    }
}
