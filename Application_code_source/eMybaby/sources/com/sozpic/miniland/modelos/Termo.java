package com.sozpic.miniland.modelos;

import java.util.Date;

public class Termo implements Comparable<Termo> {
    public Date fecha;
    public String id;
    public Double tmp;

    public int compareTo(Termo termo) {
        if (getFecha() == null || termo.getFecha() == null) {
            return 0;
        }
        return termo.getFecha().compareTo(getFecha());
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getId() {
        return this.id;
    }

    public Double getTmp() {
        return this.tmp;
    }

    public void setFecha(Date date) {
        this.fecha = date;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTmp(Double d2) {
        this.tmp = d2;
    }
}
