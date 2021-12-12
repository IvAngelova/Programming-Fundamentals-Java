package T5Lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> firstList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        List<String> secondList = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int size = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < size; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }
        printTheRest(size, firstList);
        printTheRest(size, secondList);
    }

    public static void printTheRest(int size, List<String> currentList) {
        for (int i = size; i < currentList.size(); i++) {
            System.out.print(currentList.get(i) + " ");
        }
    }
}
