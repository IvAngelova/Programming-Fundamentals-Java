package MidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        double averageValue = sum * 1.0 / numbers.size();
        List<Integer> topNumbers = new ArrayList<>();
        for (int i = 0; i <= numbers.size() - 1; i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > averageValue) {
                topNumbers.add(currentNumber);
            }
        }
        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);
        if (topNumbers.isEmpty()) {
            System.out.println("No");
        } else if (topNumbers.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        } else {
            for (Integer topNumber : topNumbers) {
                System.out.print(topNumber + " ");
            }
        }
    }
}
