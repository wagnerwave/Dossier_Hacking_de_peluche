package com.tuya.smart.android.device.bean;

import java.io.Serializable;
import java.util.Set;

public class EnumSchemaBean implements Serializable {
    public static final String type = "enum";
    public Set<String> range;

    public Set<String> getRange() {
        return this.range;
    }

    public void setRange(Set<String> set) {
        this.range = set;
    }
}
