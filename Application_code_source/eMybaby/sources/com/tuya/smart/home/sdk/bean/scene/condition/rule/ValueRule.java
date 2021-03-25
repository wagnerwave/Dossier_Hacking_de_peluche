package com.tuya.smart.home.sdk.bean.scene.condition.rule;

import java.util.List;

public class ValueRule extends Rule {
    public ValueRule(String str, String str2, int i) {
        this.expr.clear();
        List<Object> list = this.expr;
        list.add("$" + str);
        this.expr.add(str2);
        this.expr.add(Integer.valueOf(i));
    }

    public static ValueRule newInstance(String str, String str2, int i) {
        return new ValueRule(str, str2, i);
    }
}
