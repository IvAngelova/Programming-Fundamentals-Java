package T5Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scan.nextLine().split("\\s+");
        int bombNumber = Integer.parseInt(input[0]);
        int power = Integer.parseInt(input[1]);
        while (numbers.contains(bombNumber)) {
            int indexBombNumber = numbers.indexOf(bombNumber);
            int left = Math.max(0, indexBombNumber - power);
            int right = Math.min(numbers.size() - 1, indexBombNumber + power);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
