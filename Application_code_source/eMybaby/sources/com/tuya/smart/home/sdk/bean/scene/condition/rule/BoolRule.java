package com.tuya.smart.home.sdk.bean.scene.condition.rule;

import java.util.List;

public class BoolRule extends Rule {
    public BoolRule(String str, boolean z) {
        this.expr.clear();
        List<Object> list = this.expr;
        list.add("$" + str);
        this.expr.add("==");
        this.expr.add(Boolean.valueOf(z));
    }

    public static BoolRule newInstance(String str, boolean z) {
        return new BoolRule(str, z);
    }
}
