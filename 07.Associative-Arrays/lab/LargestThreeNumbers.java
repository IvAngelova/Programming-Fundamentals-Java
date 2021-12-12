package T7AssociativeArrays.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((e1, e2) -> e2.compareTo(e1))
                .limit(3)
                .collect(Collectors.toList());

        numbers.forEach(e -> System.out.print(e + " "));
    }
}
