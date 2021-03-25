package com.tuya.smart.home.sdk.bean.scene.condition.property;

import java.util.HashMap;

public class BoolProperty implements IProperty {
    public static final long serialVersionUID = 8585979020871884684L;
    public static final String type = "bool";
    public HashMap<Boolean, String> boolMap = new HashMap<>();

    public HashMap<Boolean, String> getBoolMap() {
        return this.boolMap;
    }
}
