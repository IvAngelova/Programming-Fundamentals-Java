package T7AssociativeArrays.exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        while (keyMaterials.get("motes") < 250 && keyMaterials.get("fragments") < 250 && keyMaterials.get("shards") < 250) {
            String[] input = scan.nextLine().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                switch (material) {
                    case "shards":
                        keyMaterials.put("shards", keyMaterials.get("shards") + quantity);
                        break;
                    case "fragments":
                        keyMaterials.put("fragments", keyMaterials.get("fragments") + quantity);
                        break;
                    case "motes":
                        keyMaterials.put("motes", keyMaterials.get("motes") + quantity);
                        break;
                    default:
                        if (!junkMaterials.containsKey(material)) {
                            junkMaterials.put(material, quantity);
                        } else {
                            junkMaterials.put(material, junkMaterials.get(material) + quantity);
                        }
                        break;
                }
                if (keyMaterials.get("shards") >= 250 || keyMaterials.get("fragments") >= 250 ||
                        keyMaterials.get("motes") >= 250)
                    break;
            }
        }
        String legendaryItem = "";
        if (keyMaterials.get("motes") >= 250) {
            legendaryItem = "Dragonwrath";
            keyMaterials.put("motes", keyMaterials.get("motes") - 250);
        } else if (keyMaterials.get("fragments") >= 250) {
            legendaryItem = "Valanyr";
            keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
        } else if (keyMaterials.get("shards") >= 250) {
            legendaryItem = "Shadowmourne";
            keyMaterials.put("shards", keyMaterials.get("shards") - 250);
        }
        System.out.printf("%s obtained!%n", legendaryItem);
        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        junkMaterials.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
