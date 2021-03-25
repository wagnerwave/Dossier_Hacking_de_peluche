package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;

public class PreCondition implements Serializable {
    public static final String TIMEINTERVAL_ALLDAY = "allDay";
    public static final String TIMEINTERVAL_CUSTOM = "custom";
    public static final String TIMEINTERVAL_DAYTIME = "daytime";
    public static final String TIMEINTERVAL_NIGHT = "night";
    public static final String TYPE_TIME_CHECK = "timeCheck";
    public String condType;
    public PreConditionExpr expr;
    public String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreCondition.class != obj.getClass()) {
            return false;
        }
        PreCondition preCondition = (PreCondition) obj;
        String str = this.id;
        if (str == null ? preCondition.id != null : !str.equals(preCondition.id)) {
            return false;
        }
        String str2 = this.condType;
        if (str2 == null ? preCondition.condType != null : !str2.equals(preCondition.condType)) {
            return false;
        }
        PreConditionExpr preConditionExpr = this.expr;
        PreConditionExpr preConditionExpr2 = preCondition.expr;
        return preConditionExpr != null ? preConditionExpr.equals(preConditionExpr2) : preConditionExpr2 == null;
    }

    public String getCondType() {
        return this.condType;
    }

    public PreConditionExpr getExpr() {
        return this.expr;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.condType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PreConditionExpr preConditionExpr = this.expr;
        if (preConditionExpr != null) {
            i = preConditionExpr.hashCode();
        }
        return hashCode2 + i;
    }

    public void setCondType(String str) {
        this.condType = str;
    }

    public void setExpr(PreConditionExpr preConditionExpr) {
        this.expr = preConditionExpr;
    }

    public void setId(String str) {
        this.id = str;
    }
}
