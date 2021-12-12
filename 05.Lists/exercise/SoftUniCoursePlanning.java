package T5Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scan.nextLine();
        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTitle = tokens[1];
            String exercise = lessonTitle + "-Exercise";
            switch (command) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTitle)) {
                        if (index >= 0 && index < schedule.size()) {
                            schedule.add(index, lessonTitle);
                        }
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                        if (schedule.contains(exercise)) {
                            schedule.remove(exercise);
                        }
                    }
                    break;
                case "Swap":
                    String lessonTitleToSwap2 = tokens[2];
                    String exercise2 = lessonTitleToSwap2 + "-Exercise";
                    int index1 = schedule.indexOf(lessonTitle);
                    int index2 = schedule.indexOf(lessonTitleToSwap2);
                    if (schedule.contains(lessonTitle) && schedule.contains(lessonTitleToSwap2)) {
                        schedule.set(index1, lessonTitleToSwap2);
                        schedule.set(index2, lessonTitle);

                        if (schedule.contains(exercise) &&
                                schedule.contains(exercise2)) {
                            schedule.set(index1 + 1, exercise2);
                            schedule.set(index2 + 1, exercise);
                        } else if (schedule.contains(exercise)) {
                            schedule.add(index2 + 1, exercise);
                            schedule.remove(schedule.indexOf(lessonTitleToSwap2) + 1);
                        } else if (schedule.contains(exercise2)) {
                            schedule.add(index1 + 1, exercise2);
                            schedule.remove(schedule.indexOf(lessonTitle) + 1);
                        }
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(lessonTitle)) {
                        int indexOfLesson = schedule.indexOf(lessonTitle);
                        if (!schedule.contains(exercise)) {
                            schedule.add(indexOfLesson + 1, exercise);
                        }
                    } else {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }
                    break;
            }


            input = scan.nextLine();
        }
        for (int i = 0; i <= schedule.size() - 1; i++) {
            System.out.println(i + 1 + "." + schedule.get(i));
        }
    }
}
