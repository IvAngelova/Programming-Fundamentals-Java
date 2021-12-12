package T2DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pokePowerN = Integer.parseInt(scan.nextLine());
        int distanceBetweenTargetsM = Integer.parseInt(scan.nextLine());
        int exhaustionFactorY = Integer.parseInt(scan.nextLine());
        int pokedTargetsCount = 0;
        double halfN = pokePowerN / 2.0;
        while (pokePowerN >= distanceBetweenTargetsM) {
            pokedTargetsCount++;
            pokePowerN -= distanceBetweenTargetsM;
            if (pokePowerN == halfN && exhaustionFactorY != 0) {
                pokePowerN = pokePowerN / exhaustionFactorY;
            }
        }
        System.out.println(pokePowerN);
        System.out.println(pokedTargetsCount);
    }
}
