package com.cuatroochenta.miniland.model;

import a.c.a.d.a;
import a.c.a.f.e;
import a.c.d.r.j;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Measure implements Comparable<Measure> {
    public static final float KG_TO_GR = 1000.0f;
    public static final float KG_TO_LIB = 2.2046225f;
    public static final float KG_TO_OZ = 35.27392f;
    public static final float KG_TO_ST = 0.15747286f;
    public static final int MEASURE_UNIT_GR = 4;
    public static final int MEASURE_UNIT_KG = 0;
    public static final int MEASURE_UNIT_LIB = 1;
    public static final int MEASURE_UNIT_OZ = 3;
    public static final int MEASURE_UNIT_STONE = 2;
    public Date date;
    public Long idCrecimiento;
    public String stringDate;
    public int unit;
    public float value;

    public Measure() {
    }

    public Measure(float f, int i) {
        this.unit = i;
        this.value = f;
        this.date = Calendar.getInstance().getTime();
    }

    public static float convertValueToUnit(float f, int i, int i2) {
        return i == i2 ? f : i == 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? f : f * 1000.0f : f * 35.27392f : f * 0.15747286f : f * 2.2046225f : i2 == 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? f : f / 1000.0f : f / 35.27392f : f / 0.15747286f : f / 2.2046225f : convertValueToUnit(convertValueToUnit(f, i, 0), 0, i2);
    }

    public static String getMeasureNameForWebservice(int i) {
        return i != 1 ? i != 3 ? i != 4 ? "kg" : "gr" : "oz" : "lb";
    }

    public int compareTo(Measure measure) {
        if (getIdCrecimiento() == null || measure.getIdCrecimiento() == null) {
            return 0;
        }
        return measure.getIdCrecimiento().compareTo(getIdCrecimiento());
    }

    public float convertValueToUnit(int i) {
        return convertValueToUnit(getValue(), getUnit(), i);
    }

    public Date getDate() {
        return this.date;
    }

    public Long getIdCrecimiento() {
        return this.idCrecimiento;
    }

    public String getMeasureUnitName() {
        return j.c(getUnit()).toLowerCase();
    }

    public String getStringDate() {
        String str = this.stringDate;
        return (str == null || str.equals("null") || this.stringDate.isEmpty()) ? getDate() != null ? j.g.format(getDate()) : a.g(this.stringDate) : this.stringDate;
    }

    public int getUnit() {
        return this.unit;
    }

    public float getValue() {
        return this.value;
    }

    public String getWebserviceWeight() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.ENGLISH, "%f", new Object[]{Float.valueOf(convertValueToUnit(0))}));
        e.b("Value sent to Webservices-->" + sb.toString());
        return sb.toString();
    }

    public String getWebseviceStringDate() {
        return getDate() != null ? j.j.format(getDate()) : "";
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public void setIdCrecimiento(Long l) {
        this.idCrecimiento = l;
    }

    public void setStringDate(String str) {
        this.stringDate = str;
    }

    public void setUnit(int i) {
        this.unit = i;
    }

    public void setValue(float f) {
        this.value = f;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int unit2 = getUnit();
        if (unit2 == 0) {
            str = String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(this.value)});
        } else if (unit2 == 3) {
            str = String.format(Locale.ENGLISH, "%.1f", new Object[]{Float.valueOf(this.value)});
        } else if (unit2 != 4) {
            str = String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.value)});
        } else {
            str = String.format(Locale.ENGLISH, "%.0f", new Object[]{Float.valueOf(this.value)});
        }
        sb.append(str);
        sb.append(" ");
        sb.append(getMeasureUnitName());
        return sb.toString();
    }
}
