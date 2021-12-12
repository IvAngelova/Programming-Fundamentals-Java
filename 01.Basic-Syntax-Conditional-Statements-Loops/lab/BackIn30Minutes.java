package T1BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
//         minutes = minutes + 30;
//         if (minutes > 59){
//             minutes -= 60;
//             hours++;
//         }
//         if(hours > 23){
//             hours = 0;
//         }
//        System.out.printf("%d:%02d", hours, minutes);
        int timeInMinutes = hours * 60 + minutes + 30;
        hours = timeInMinutes / 60;
        minutes = timeInMinutes % 60;
        if (hours > 23) {
            hours = 0;
        }
        System.out.printf("%d:%02d", hours, minutes);
    }
}
