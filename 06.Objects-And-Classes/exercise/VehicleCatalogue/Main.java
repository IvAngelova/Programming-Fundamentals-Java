package T6ObjectsAndClasses.exercise.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        while (!input.equals("End")) {
            String[] vehicleData = input.split("\\s+");
            String type = vehicleData[0];
            switch (type) {
                case "car":
                    type = "Car";
                    break;
                case "truck":
                    type = "Truck";
                    break;
            }
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsepower = Integer.parseInt(vehicleData[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);
            input = scan.nextLine();
        }
        String modelOfVehicles = scan.nextLine();
        while (!modelOfVehicles.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(modelOfVehicles)) {
                    System.out.println(vehicle);
                    break;
                }
            }
            modelOfVehicles = scan.nextLine();
        }
        List<Vehicle> cars = vehicles.stream().filter(e -> e.getType().equals("Car"))
                .collect(Collectors.toList());
        List<Vehicle> trucks = vehicles.stream().filter(e -> e.getType().equals("Truck"))
                .collect(Collectors.toList());
        int sumHorsepowerCars = 0;
        int sumHorsepowerTrucks = 0;
        for (Vehicle car : cars) {
            sumHorsepowerCars += car.getHorsepower();
        }
        for (Vehicle truck : trucks) {
            sumHorsepowerTrucks += truck.getHorsepower();
        }
        // 0/0 = NaN!!
        if (cars.size() > 0 && trucks.size() > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n",
                    sumHorsepowerCars * 1.0 / cars.size());
            System.out.printf("Trucks have average horsepower of: %.2f.%n",
                    sumHorsepowerTrucks * 1.0 / trucks.size());
        } else if (cars.size() > 0 && trucks.size() == 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n",
                    sumHorsepowerCars * 1.0 / cars.size());
            System.out.printf("Trucks have average horsepower of: %.2f.%n", 0.0);
        } else if (cars.size() == 0 && trucks.size() > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", 0.0);
            System.out.printf("Trucks have average horsepower of: %.2f.%n",
                    sumHorsepowerTrucks * 1.0 / trucks.size());
        } else if (cars.size() == 0 && trucks.size() == 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", 0.0);
            System.out.printf("Trucks have average horsepower of: %.2f.%n", 0.0);
        }
    }
}
