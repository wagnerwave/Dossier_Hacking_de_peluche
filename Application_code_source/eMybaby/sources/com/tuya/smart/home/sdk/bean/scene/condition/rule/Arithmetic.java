package com.tuya.smart.home.sdk.bean.scene.condition.rule;

public enum Arithmetic {
    GREATER("<"),
    EQUAL("=="),
    SMALLER(">");
    
    public String arithmetic;

    /* access modifiers changed from: public */
    Arithmetic(String str) {
        this.arithmetic = str;
    }

    public String getArithmetic() {
        return this.arithmetic;
    }

    public void setArithmetic(String str) {
        this.arithmetic = str;
    }
}
