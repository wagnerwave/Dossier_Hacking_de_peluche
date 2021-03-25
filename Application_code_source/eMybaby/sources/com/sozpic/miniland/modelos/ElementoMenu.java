package com.sozpic.miniland.modelos;

public class ElementoMenu {
    public static final int MENU_CALENDAR = 13;
    public static final int MENU_FICHA_MEDICA = 9;
    public static final int MENU_HOME = 0;
    public static final int MENU_HUMIDIFICADOR = 8;
    public static final int MENU_MI_BEBE = 1;
    public static final int MENU_MI_FAMILIA = 2;
    public static final int MENU_MY_BUDDY = 5;
    public static final int MENU_MY_SCALE = 7;
    public static final int MENU_NUTRICION = 11;
    public static final int MENU_PHOTO_ALBUM = 10;
    public static final int MENU_PREGNANCY = 4;
    public static final int MENU_SETTINGS = 14;
    public static final int MENU_TERMOMETRO = 6;
    public static final int MENU_VIGILABEBES = 3;
    public static final int MENU_WORLD = 12;
    public int id;
    public int imagen;
    public String nombre;

    public int getId() {
        return this.id;
    }

    public int getImagen() {
        return this.imagen;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImagen(int i) {
        this.imagen = i;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }
}
