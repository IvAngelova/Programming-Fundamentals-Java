package T8TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] path = scan.nextLine().split("\\\\");
        String fullFileName = path[path.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
