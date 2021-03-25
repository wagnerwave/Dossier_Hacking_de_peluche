package com.sozpic.miniland.modelos;

public class Video {
    public String helpSection;
    public int id;
    public String nombre;

    public Video(int i, String str, String str2) {
        this.id = i;
        this.nombre = str;
        this.helpSection = str2;
    }

    public String getHelpSection() {
        return this.helpSection;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setHelpSection(String str) {
        this.helpSection = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }
}
