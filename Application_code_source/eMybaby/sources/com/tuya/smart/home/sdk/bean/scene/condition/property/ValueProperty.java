package com.tuya.smart.home.sdk.bean.scene.condition.property;

public class ValueProperty implements IProperty {
    public static final long serialVersionUID = -7072287225351351634L;
    public static final String type = "value";
    public int max;
    public int min;
    public int step;
    public String unit;

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
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

    public void setStep(int i) {
        this.step = i;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
