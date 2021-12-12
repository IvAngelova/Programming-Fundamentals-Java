package T7AssociativeArrays.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String resource = scan.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }
            resource = scan.nextLine();
        }
        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
