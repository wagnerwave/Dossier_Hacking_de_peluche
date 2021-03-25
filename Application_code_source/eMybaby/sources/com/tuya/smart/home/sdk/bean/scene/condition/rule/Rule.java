package com.tuya.smart.home.sdk.bean.scene.condition.rule;

import java.util.ArrayList;
import java.util.List;

public abstract class Rule {
    public List<Object> expr = new ArrayList(3);

    public List<Object> getExpr() {
        return this.expr;
    }
}
