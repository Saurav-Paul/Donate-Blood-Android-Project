package com.example.saurav.donateblood;

public class Globals {


    private static Globals instance = new Globals();

    // Getter-Setters
    public static Globals getInstance() {
        return instance;
    }

    public static void setInstance(Globals instance) {
        Globals.instance = instance;
    }

    private String temp;


    private Globals() {

    }


    public String getValue() {
        return temp;
    }


    public void setValue(String notification_index) {
        this.temp = notification_index;
    }



}