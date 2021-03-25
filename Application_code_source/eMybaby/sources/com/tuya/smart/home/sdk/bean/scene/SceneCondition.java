package com.tuya.smart.home.sdk.bean.scene;

import com.tuya.smart.home.sdk.bean.scene.condition.rule.Rule;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SceneCondition implements Serializable {
    public static final String CONDITION_TYPE_TIMER = "timer";
    public static final long serialVersionUID = 8624400661890233596L;
    public Integer condType;
    public String entityId;
    public String entityName;
    public String entitySubIds;
    public int entityType;
    public List<Object> expr;
    public String exprDisplay;
    public ConditionExtraInfoBean extraInfo;
    public String iconUrl;
    public String id;

    public static SceneCondition createDevCondition(DeviceBean deviceBean, String str, Rule rule) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId(deviceBean.getDevId());
        sceneCondition.setEntityName(deviceBean.getName());
        sceneCondition.setEntityType(1);
        sceneCondition.setEntitySubIds(str);
        if (rule != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(rule.getExpr());
            sceneCondition.setExpr(arrayList);
        }
        return sceneCondition;
    }

    @Deprecated
    public static SceneCondition createDevCondition(DeviceBean deviceBean, String str, List<Rule> list) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId(deviceBean.getDevId());
        sceneCondition.setEntityName(deviceBean.getName());
        sceneCondition.setEntityType(1);
        sceneCondition.setEntitySubIds(str);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Rule expr2 : list) {
                arrayList.add(expr2.getExpr());
            }
            sceneCondition.setExpr(arrayList);
        }
        return sceneCondition;
    }

    public static SceneCondition createTimerCondition(String str, String str2, String str3, Rule rule) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId("timer");
        sceneCondition.setEntityName(str2);
        sceneCondition.setExprDisplay(str);
        sceneCondition.setEntityType(6);
        sceneCondition.setEntitySubIds(str3);
        sceneCondition.setExpr(rule.getExpr());
        return sceneCondition;
    }

    public static SceneCondition createWeatherCondition(PlaceFacadeBean placeFacadeBean, String str, Rule rule) {
        SceneCondition sceneCondition = new SceneCondition();
        sceneCondition.setEntityId(String.valueOf(placeFacadeBean.getCityId()));
        sceneCondition.setEntityName(placeFacadeBean.getCity());
        sceneCondition.setEntityType(3);
        sceneCondition.setEntitySubIds(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(rule.getExpr());
        sceneCondition.setExpr(arrayList);
        return sceneCondition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SceneCondition.class != obj.getClass()) {
            return false;
        }
        SceneCondition sceneCondition = (SceneCondition) obj;
        if (this.entityType != sceneCondition.entityType) {
            return false;
        }
        String str = this.id;
        if (str == null ? sceneCondition.id != null : !str.equals(sceneCondition.id)) {
            return false;
        }
        String str2 = this.entitySubIds;
        if (str2 == null ? sceneCondition.entitySubIds != null : !str2.equals(sceneCondition.entitySubIds)) {
            return false;
        }
        String str3 = this.entityId;
        if (str3 == null ? sceneCondition.entityId != null : !str3.equals(sceneCondition.entityId)) {
            return false;
        }
        String str4 = this.entityName;
        if (str4 == null ? sceneCondition.entityName != null : !str4.equals(sceneCondition.entityName)) {
            return false;
        }
        Integer num = this.condType;
        if (num == null ? sceneCondition.condType != null : !num.equals(sceneCondition.condType)) {
            return false;
        }
        String str5 = this.exprDisplay;
        if (str5 == null ? sceneCondition.exprDisplay != null : !str5.equals(sceneCondition.exprDisplay)) {
            return false;
        }
        List<Object> list = this.expr;
        if (list == null ? sceneCondition.expr != null : !list.equals(sceneCondition.expr)) {
            return false;
        }
        String str6 = this.iconUrl;
        if (str6 == null ? sceneCondition.iconUrl != null : !str6.equals(sceneCondition.iconUrl)) {
            return false;
        }
        ConditionExtraInfoBean conditionExtraInfoBean = this.extraInfo;
        ConditionExtraInfoBean conditionExtraInfoBean2 = sceneCondition.extraInfo;
        return conditionExtraInfoBean != null ? conditionExtraInfoBean.equals(conditionExtraInfoBean2) : conditionExtraInfoBean2 == null;
    }

    public Integer getCondType() {
        return this.condType;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public String getEntitySubIds() {
        return this.entitySubIds;
    }

    public int getEntityType() {
        return this.entityType;
    }

    public List<Object> getExpr() {
        return this.expr;
    }

    public String getExprDisplay() {
        return this.exprDisplay;
    }

    public ConditionExtraInfoBean getExtraInfo() {
        return this.extraInfo;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.entitySubIds;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.entityId;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.entityType) * 31;
        String str4 = this.entityName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.condType;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.exprDisplay;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<Object> list = this.expr;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str6 = this.iconUrl;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ConditionExtraInfoBean conditionExtraInfoBean = this.extraInfo;
        if (conditionExtraInfoBean != null) {
            i = conditionExtraInfoBean.hashCode();
        }
        return hashCode8 + i;
    }

    public void setCondType(Integer num) {
        this.condType = num;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public void setEntitySubIds(String str) {
        this.entitySubIds = str;
    }

    public void setEntityType(int i) {
        this.entityType = i;
    }

    public void setExpr(List<Object> list) {
        this.expr = list;
    }

    public void setExprDisplay(String str) {
        this.exprDisplay = str;
    }

    public void setExtraInfo(ConditionExtraInfoBean conditionExtraInfoBean) {
        this.extraInfo = conditionExtraInfoBean;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }
}
