package T6ObjectsAndClasses.lab.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentInfo = input.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String hometown = studentInfo[3];
            // overwrite the information in the list
            Student existingStudent = getStudent(students, firstName, lastName);
            if (existingStudent != null) {
                existingStudent.setAge(age);
                existingStudent.setHometown(hometown);
            } else {
                // add a new student to the list
                Student student = new Student(firstName, lastName, age, hometown);
                students.add(student);
            }

            input = scan.nextLine();
        }
        String city = scan.nextLine();
        for (Student student : students) {
            if (city.equals(student.getHometown())) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
}
