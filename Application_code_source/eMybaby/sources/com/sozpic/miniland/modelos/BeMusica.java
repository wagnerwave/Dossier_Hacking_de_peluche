package com.sozpic.miniland.modelos;

public class BeMusica {
    public String duracion;
    public int id;
    public int idc;
    public boolean im;
    public int imagen;
    public int imagen_on;
    public long lduracion;
    public boolean local;
    public String mp3sd;
    public String titulo;

    public String getDuracion() {
        return this.duracion;
    }

    public boolean getI() {
        return this.im;
    }

    public int getId() {
        return this.id;
    }

    public int getIdC() {
        return this.idc;
    }

    public int getImagen() {
        return this.imagen;
    }

    public int getImagen_on() {
        return this.imagen_on;
    }

    public long getLduracion() {
        return this.lduracion;
    }

    public boolean getLocal() {
        return this.local;
    }

    public String getMp3sd() {
        return this.mp3sd;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setDuracion(String str) {
        this.duracion = str;
    }

    public void setI(boolean z) {
        this.im = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIdC(int i) {
        this.idc = i;
    }

    public void setImagen(int i) {
        this.imagen = i;
    }

    public void setImagen_on(int i) {
        this.imagen_on = i;
    }

    public void setLduracion(long j) {
        this.lduracion = j;
    }

    public void setLocal() {
        this.local = true;
    }

    public void setMp3sd(String str) {
        this.mp3sd = str;
    }

    public void setTitulo(String str) {
        this.titulo = str;
    }
}
