package T9RegEx.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> racers = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        Map<String, Integer> racersDistance = new LinkedHashMap<>();
        racers.forEach(racer -> racersDistance.put(racer, 0));
        String regexName = "[A-Za-z]+";
        String regexDistance = "[0-9]";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternDistance = Pattern.compile(regexDistance);
        while (!input.equals("end of race")) {
            Matcher matcherName = patternName.matcher(input);
            Matcher matcherDistance = patternDistance.matcher(input);
            StringBuilder nameSB = new StringBuilder();
            while (matcherName.find()) {
                nameSB.append(matcherName.group());
            }
            String name = nameSB.toString();
            int distance = 0;
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }
            if (racersDistance.containsKey(name)) {
                racersDistance.put(name, racersDistance.get(name) + distance);
            }
            input = scan.nextLine();
        }
        List<String> top3Racers = racersDistance.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3Racers.get(0));
        System.out.println("2nd place: " + top3Racers.get(1));
        System.out.println("3rd place: " + top3Racers.get(2));
    }
}
