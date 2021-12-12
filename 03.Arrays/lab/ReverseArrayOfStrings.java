package T3Arrays.lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] array = input.split(" ");
        for (int i = 0; i < array.length / 2; i++) {
            //разменяме две стойности чрез трета временна променлива temp
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(String.join(" ", array));
    }
}
