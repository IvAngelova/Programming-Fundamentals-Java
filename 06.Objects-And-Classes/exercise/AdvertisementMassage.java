package T6ObjectsAndClasses.exercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMassage {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         String [] phrases = {"Excellent product.", "Such a great product.",
                 "I always use that product.", "Best product of its category.",
                 "Exceptional product.", "I can’t live without this product."};
         String [] events = {"Now I feel good.", "I have succeeded with this product.",
                 "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                 "Try it yourself, I am very satisfied.", "I feel great!"};
         String [] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
         String [] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int numberOfMessages = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfMessages; i++) {
            Random rnd = new Random();
            int randomNumberPhrases = rnd.nextInt(phrases.length);
            int randomNumberEvents = rnd.nextInt(events.length);
            int randomNumberAuthors = rnd.nextInt(authors.length);
            int randomNumberCities = rnd.nextInt(cities.length);

            System.out.println(phrases[randomNumberPhrases] + " " + events[randomNumberEvents]+
                    " " + authors[randomNumberAuthors] + " - " + cities[randomNumberCities]);
        }
    }
}
