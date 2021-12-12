package T7AssociativeArrays.exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> forceBook = new HashMap<>();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];
                boolean isExisting = false;
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        isExisting = true;
                        break;
                    }
                }
                if (!isExisting) {
                    if (!forceBook.containsKey(forceSide)) {
                        forceBook.put(forceSide, new ArrayList<>());
                    }
                    if (!forceBook.get(forceSide).contains(forceUser)) {
                        forceBook.get(forceSide).add(forceUser);
                    }
                }
            } else if (input.contains("->")) {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];
                label:
                for (Map.Entry<String, List<String>> entry : forceBook.entrySet()) {
                    for (String value : entry.getValue()) {
                        if (value.equals(forceUser)) {
                            entry.getValue().remove(value);
                            break label;
                        }
                    }
                }
                if (!forceBook.containsKey(forceSide)) {
                    forceBook.putIfAbsent(forceSide, new ArrayList<>());
                }
                forceBook.get(forceSide).add(forceUser);

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scan.nextLine();
        }
        forceBook.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                // .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size))
                //       .reversed().thenComparing(Map.Entry.comparingByKey()))
                .sorted((e1, e2) -> {
                    int res = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                }).forEach(e -> {
            System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
            e.getValue().stream()
                    .sorted(String::compareTo)
                    .forEach(user -> System.out.println("! " + user));
        });
    }
}
