package T1BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceLightsabers = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());
        double totalLightsabers = Math.ceil(students + (0.1 * students)) * priceLightsabers;
        double totalRobes = students * priceRobes;
        // всеки 6-ти колан е безплатен
        int freeBelts = students / 6;
        double totalBelts = (students - freeBelts) * priceBelts;
        double totalMoneyNeededForEquipment = totalBelts + totalLightsabers + totalRobes;
        if (money >= totalMoneyNeededForEquipment) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalMoneyNeededForEquipment);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalMoneyNeededForEquipment - money);
        }
    }
}
