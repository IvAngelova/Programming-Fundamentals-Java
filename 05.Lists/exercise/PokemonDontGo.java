package T5Lists.exercise;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int sumRemovedElements = 0;
        while (!distances.isEmpty()) {
            int currentIndex = Integer.parseInt(scan.nextLine());
            int elementToRemove = 0;
            if (currentIndex >= 0 && currentIndex <= distances.size() - 1) {
                elementToRemove = distances.get(currentIndex);
                distances.remove(currentIndex);
                for (int i = 0; i <= distances.size() - 1; i++) {
                    if (distances.get(i) <= elementToRemove) {
                        distances.set(i, distances.get(i) + elementToRemove);
                    } else {
                        distances.set(i, distances.get(i) - elementToRemove);
                    }
                }
            } else if (currentIndex < 0) {
                elementToRemove = distances.get(0);
                distances.remove(0);
                distances.add(0, distances.get(distances.size() - 1));
                for (int i = 0; i <= distances.size() - 1; i++) {
                    if (distances.get(i) <= elementToRemove) {
                        distances.set(i, distances.get(i) + elementToRemove);
                    } else {
                        distances.set(i, distances.get(i) - elementToRemove);
                    }
                }

            } else if (currentIndex > distances.size() - 1) {
                elementToRemove = distances.get(distances.size() - 1);
                distances.remove(distances.size() - 1);
                distances.add(distances.get(0));
                for (int i = 0; i <= distances.size() - 1; i++) {
                    if (distances.get(i) <= elementToRemove) {
                        distances.set(i, distances.get(i) + elementToRemove);
                    } else {
                        distances.set(i, distances.get(i) - elementToRemove);
                    }
                }
            }
            sumRemovedElements += elementToRemove;
        }
        System.out.println(sumRemovedElements);
    }
}
