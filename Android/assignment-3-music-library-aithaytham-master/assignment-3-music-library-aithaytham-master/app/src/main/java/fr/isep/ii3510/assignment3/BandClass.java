package fr.isep.ii3510.assignment3;

import java.util.ArrayList;
import java.util.List;

public class BandClass {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name ;

    List<AlbumClass> album = new ArrayList<>();
}

