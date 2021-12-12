package T6ObjectsAndClasses.lab.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfSongs = Integer.parseInt(scan.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= countOfSongs; i++) {
            String[] songInfo = scan.nextLine().split("_");
            String typeList = songInfo[0];
            String name = songInfo[1];
            String time = songInfo[2];

            Song currentSong = new Song();
            currentSong.setTypeList(typeList);
            currentSong.setName(name);
            currentSong.setTime(time);

            songs.add(currentSong);
        }
        String typeList = scan.nextLine();
        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (typeList.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
