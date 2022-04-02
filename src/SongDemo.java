import POJO.Song;

import java.util.HashSet;
import java.util.*;

public class SongDemo {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<> (Arrays.asList(
                new Song("Under Pressure", 1981, "Queen", "David Bowie"),
                new Song("Poker Face", 2009, "Lady Gaga"),
                new Song("Don’t give up", 1986, "Peter Gabriel", "Kate Bush"),
                new Song("Poker Face", 2009, "Lady Gaga"),
                new Song("I’m Real", 2001, "Jennifer Lopez", "Ja Rule"),
                new Song("Hello", 2015, "Adele"),
                new Song("Promiscuous", 2006, "Nelly Furtado", "Timbaland"),
                new Song("The Way I Are", 2007, "Timbaland", "Keri Hilson"),
                new Song("No More Tears", 1979, "Barbra Streisand", "Donna Summer"),
                new Song("All of Me", 2013, "John Legend"),
                new Song("I gotta Feeling", 2009, "The Black Eyed Peas")
        ));

        //ArrayList<Song> songArrayList = new ArrayList<>();

        int firstSong = 0;
        for (int i=0; i<songs.size(); i++) {
            if (songs.get(i).getYear() >= songs.get(firstSong).getYear()) {
                firstSong = i;
            }
        }
        System.out.println(songs.get(firstSong));

        //Выведите в консоль песни, которые исполняются дуэтом (Iterator)
        for (Iterator<Song> songIterator = songs.iterator(); songIterator.hasNext(); ) {
            Song song = songIterator.next();
            if (song.getSingers().size() > 1) {
                System.out.println(song);
            }
        }

        //Найдите певца (певицу), исполнившего наибольшее количество песен (Map)
        Map singersMap = new HashMap();
        for (Song s : songs) {
            for (String singer : s.getSingers()) {
                if (!singersMap.containsKey(singer)) {
                    singersMap.put(singer, 1);
                } else {
                    int value = (int) singersMap.get(singer) + 1;
                    singersMap.replace(singer, value);
                }
            }
        }
        int maxSong = 0;
        String maxSinger = "";
        Iterator iterator = singersMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = singersMap.get(key);
            if ((int) value > maxSong) {
                maxSong = (int) value;
                maxSinger = key.toString();
            }
        }
        System.out.println(maxSinger + "\n");

        //Выведите в консоль певцов, певших дуэтом с певцом по п.5(Set)
        HashSet<String> single = new HashSet<>();
        for (Song patent : songs) {
            if (patent.getSingers().contains(maxSinger)) {
                single.addAll(patent.getSingers());
            }
        }
        System.out.println(single.remove(maxSinger));
    }
}


