package com.example.projetand;

public class listclub {
    private String Name,Type,Description,Localisation;
    private static String Namec,Typec,Descriptionc,Localisationc;
    private float Note;
    private static float Notec;
    public int id;
    public static int idc;



    public listclub() {

    }

    public static float getNotec() {
        return Notec;
    }

    public static void setNotec(float notec) {
        Notec = notec;
    }

    public static int getIdc() {
        return idc;
    }

    public static void setIdc(int idc) {
        listclub.idc = idc;
    }

    public static String getTypec() {
        return Typec;
    }

    public static void setTypec(String typec) {
        Typec = typec;
    }

    public static String getDescriptionc() {
        return Descriptionc;
    }

    public static void setDescriptionc(String descriptionc) {
        Descriptionc = descriptionc;
    }

    public static String getLocalisationc() {
        return Localisationc;
    }

    public static void setLocalisationc(String localisationc) {
        Localisationc = localisationc;
    }

    public static String getNamec() {
        return Namec;
    }

    public static void setNamec(String namec) {
        Namec = namec;
    }

    public String getName() {
        return Name;
    }

    public void setName( String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(String localisation) {
        Localisation = localisation;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public float getNote() {
        return Note;
    }

    public void setNote(float note) {
        Note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
