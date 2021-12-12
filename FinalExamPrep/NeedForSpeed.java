package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> carsMileage = new LinkedHashMap<>();
        Map<String, Integer> carsFuel = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            carsMileage.put(car, mileage);
            carsFuel.put(car, fuel);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String command = input.split(" : ")[0];
            String car = input.split(" : ")[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(input.split(" : ")[2]);
                    int fuel = Integer.parseInt(input.split(" : ")[3]);
                    if (carsFuel.get(car) < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsMileage.put(car, carsMileage.get(car) + distance);
                        carsFuel.put(car, carsFuel.get(car) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                car, distance, fuel);
                    }
                    if (carsMileage.get(car) >= 100000) {
                        carsMileage.remove(car);
                        carsFuel.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    int fuelRefill = Integer.parseInt(input.split(" : ")[2]);
                    if (carsFuel.get(car) + fuelRefill <= 75) {
                        carsFuel.put(car, carsFuel.get(car) + fuelRefill);
                        System.out.printf("%s refueled with %d liters%n", car, fuelRefill);
                    } else {
                        int refill = 75 - carsFuel.get(car);
                        carsFuel.put(car, 75);
                        System.out.printf("%s refueled with %d liters%n", car, refill);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(input.split(" : ")[2]);
                    if (carsMileage.get(car) - kilometers < 10000) {
                        carsMileage.put(car, 10000);
                    } else {
                        carsMileage.put(car, carsMileage.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        carsMileage.entrySet().stream()
                .sorted((e1, e2) -> {
                    int result = Integer.compare(e2.getValue(), e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        entry.getKey(), entry.getValue(), carsFuel.get(entry.getKey())));
    }
}
