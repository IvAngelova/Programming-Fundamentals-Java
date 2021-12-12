package T8TextProcessing.moreExercises;

import java.util.Scanner;

public class Html {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        System.out.println("<h1>");
        System.out.println(title);
        System.out.println("</h1>");
        String content = scan.nextLine();
        System.out.println("<article>");
        System.out.println(content);
        System.out.println("</article>");
        String input = scan.nextLine();
        while (!input.equals("end of comments")) {
            System.out.println("<div>");
            System.out.println(input);
            System.out.println("</div>");
            input = scan.nextLine();
        }
    }
}
