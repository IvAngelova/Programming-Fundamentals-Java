package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double max = Double.NEGATIVE_INFINITY;
        String biggestKeg = "";
        for (int i = 0; i < n; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > max) {
                max = volume;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}
