package fr.isep.ii3510.assignment3;

import java.util.ArrayList;
import java.util.List;

public class AlbumClass {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name ;


    List<SongClass> song = new ArrayList<>();

}
