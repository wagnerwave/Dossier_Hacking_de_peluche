package com.tuya.smart.android.device.bean;

import java.io.Serializable;

public class ValueSchemaBean implements Serializable {
    public static final String type = "value";
    public int max;
    public int min;
    public int scale;
    public int step;
    public String unit;

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public int getScale() {
        return this.scale;
    }

    public int getStep() {
        return this.step;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public void setMin(int i) {
        this.min = i;
    }

    public void setScale(int i) {
        this.scale = i;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
