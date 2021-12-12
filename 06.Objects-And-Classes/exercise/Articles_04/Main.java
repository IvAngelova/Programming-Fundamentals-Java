package T6ObjectsAndClasses.exercise.Articles_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List <Article> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String title = input.split(", ")[0];
            String content = input.split(", ")[1];
            String author = input.split(", ")[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String typeOfInput = scan.nextLine();
        List <Article> sortedList = new ArrayList<>();
        switch (typeOfInput){
            case "title":
             sortedList = articles.stream().sorted(Comparator.comparing(e -> e.getTitle()))
                     .collect(Collectors.toList());
                break;
            case "content":
                sortedList = articles.stream().sorted(Comparator.comparing(e -> e.getContent()))
                        .collect(Collectors.toList());
                break;
            case "author":
                sortedList = articles.stream().sorted(Comparator.comparing(e -> e.getAuthor()))
                        .collect(Collectors.toList());
                break;
        }
        for (Article article : sortedList) {
            System.out.println(article);
        }

    }
}
