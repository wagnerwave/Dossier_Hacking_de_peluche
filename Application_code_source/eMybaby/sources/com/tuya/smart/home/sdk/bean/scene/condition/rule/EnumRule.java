package com.tuya.smart.home.sdk.bean.scene.condition.rule;

import java.util.List;

public class EnumRule extends Rule {
    public EnumRule(String str, String str2) {
        this.expr.clear();
        List<Object> list = this.expr;
        list.add("$" + str);
        this.expr.add("==");
        this.expr.add(str2);
    }

    public static EnumRule newInstance(String str, String str2) {
        return new EnumRule(str, str2);
    }
}
