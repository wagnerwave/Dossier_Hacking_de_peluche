package com.tuya.smart.home.sdk.bean.scene.condition.property;

import java.util.HashMap;

public class EnumProperty implements IProperty {
    public static final long serialVersionUID = -6445389594463670437L;
    public static final String type = "enum";
    public HashMap<Object, String> enums = new HashMap<>();

    public HashMap<Object, String> getEnums() {
        return this.enums;
    }
}
