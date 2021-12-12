package T6ObjectsAndClasses.exercise.Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Pupil> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentData = scan.nextLine().split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            double grade = Double.parseDouble(studentData[2]);
            Pupil student = new Pupil(firstName, lastName, grade);
            students.add(student);
        }
        students = students.stream().sorted(Comparator.comparing(Pupil::getGrade).reversed())
                .collect(Collectors.toList());

        students.forEach(e -> System.out.println(e));
    }
}
