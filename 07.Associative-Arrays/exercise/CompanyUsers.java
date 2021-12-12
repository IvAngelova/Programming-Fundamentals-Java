package T7AssociativeArrays.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> companyUsers = new TreeMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];
            if (!companyUsers.containsKey(company)) {
                companyUsers.put(company, new ArrayList<>());
            }
            if (!companyUsers.get(company).contains(id)) {
                companyUsers.get(company).add(id);
            }
            input = scan.nextLine();
        }
        companyUsers.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().stream().forEach(id -> System.out.println("-- " + id));
        });
    }
}
