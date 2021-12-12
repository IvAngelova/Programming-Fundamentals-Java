package FinalExamPrep;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String places = scan.nextLine();
        String regex = "([=\\/])(?<location>[A-Z][A-Za-z]{2,})\\1"; // след първата буква също могат да бъдат главни
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        List<String> locations = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            locations.add(matcher.group("location"));
            travelPoints += matcher.group("location").length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", locations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
