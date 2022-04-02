package POJO;

import java.util.*;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOf;
import static java.util.List.of;

public class Song {
    private final String title;
    private final int year;
    private final List<String> singers;


    // конструктор
    public Song(String title, int year, String... singers){
        this.title=title;
        this.year=year;
        this.singers=asList(singers);
    }

    // геттеры
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public List<String> getSingers() { return copyOf(singers); }

    private List<String> copyOf(List<String> singers) { return singers; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return year == song.year && Objects.equals(title, song.title) && Objects.equals(singers, song.singers);
    }

    @Override
    public String toString() {
        return String.format("Song{" + "title='" + title + '\'' + ", year=" + year + ", singers=" + singers + '}');
    }

    @Override
    public int hashCode() { return Objects.hash(title, year, singers); }
}
