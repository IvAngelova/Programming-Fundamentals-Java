package T5Lists.moreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int size = Math.min(firstList.size(), secondList.size());
        List<Integer> mixedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            mixedList.add(i * 2, firstList.get(i));
            mixedList.add((i * 2) + 1, secondList.get((secondList.size() - 1) - i));
        }
        int range1 = 0;
        int range2 = 0;
        if (firstList.size() > secondList.size()) {
            range1 = firstList.get(size);
            range2 = firstList.get(size + 1);
        } else {
            range1 = secondList.get(1);
            range2 = secondList.get(0);
        }
        int start = Math.min(range1, range2);
        int end = Math.max(range1, range2);
        List<Integer> filteredList = new ArrayList<>();
        for (int i = 0; i < mixedList.size(); i++) {
            if (start < mixedList.get(i) && mixedList.get(i) < end) {
                filteredList.add(mixedList.get(i));
            }
        }
        Collections.sort(filteredList);
        filteredList.forEach(e -> System.out.print(e + " "));
    }
}
