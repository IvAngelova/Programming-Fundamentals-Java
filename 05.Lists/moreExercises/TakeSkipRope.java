package T5Lists.moreExercises;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<String> nonNumbers = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                char digit = text.charAt(i);
                numbers.add(Integer.parseInt(Character.toString(digit)));
            } else {
                // nonNumbers.add(Character.toString(text.charAt(i)));
                nonNumbers.add("" + text.charAt(i));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 0; i < takeList.size(); i++) {
            int take = takeList.get(i);
            int skip = skipList.get(i);

            if (index + take > nonNumbers.size()) {
                take = nonNumbers.size() - index;
            }

            for (int j = 0; j < take; j++) {
                result.append(nonNumbers.get(index + j));
            }

            index += take + skip;
        }

        System.out.println(result.toString());
    }
}
