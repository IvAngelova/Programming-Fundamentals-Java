package T7AssociativeArrays.exercise;

import java.util.*;


public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String student = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            if (!students.containsKey(student)) {
                students.put(student, new ArrayList<>());
            }
            students.get(student).add(grade);
        }

        Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> kvp : students.entrySet()) {
            double average = kvp.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (average >= 4.50) {
                averageGrade.put(kvp.getKey(), average);
            }
        }
        averageGrade.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));

    }
}
