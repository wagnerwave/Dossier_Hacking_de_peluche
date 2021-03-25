package com.tuya.smart.home.sdk.bean.scene.condition;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.home.sdk.bean.scene.ActionBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionActionBean;
import com.tuya.smart.home.sdk.bean.scene.condition.property.BoolProperty;
import com.tuya.smart.home.sdk.bean.scene.condition.property.EnumProperty;
import com.tuya.smart.home.sdk.bean.scene.condition.property.IProperty;
import com.tuya.smart.home.sdk.bean.scene.condition.property.TimerProperty;
import com.tuya.smart.home.sdk.bean.scene.condition.property.ValueProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ConditionListBean implements Serializable {
    public static final long serialVersionUID = 304714977183918709L;
    public String entityName;
    public int entityType;
    public long id;
    public String name;
    public String newIcon;
    public List<String> operators;
    public IProperty property;
    public String type;

    public ConditionListBean() {
    }

    public ConditionListBean(ActionBean actionBean) {
        String str;
        Class cls;
        this.name = actionBean.getSchema().getName();
        this.type = actionBean.getSchema().getCode();
        if (actionBean instanceof ConditionActionBean) {
            ConditionActionBean conditionActionBean = (ConditionActionBean) actionBean;
            if (conditionActionBean.getEntityType() == 9 || conditionActionBean.getEntityType() == 11) {
                this.type = conditionActionBean.getEntitySubId();
            }
        }
        if (!TextUtils.isEmpty(actionBean.getType())) {
            String type2 = actionBean.getType();
            char c2 = 65535;
            switch (type2.hashCode()) {
                case 3029738:
                    if (type2.equals("bool")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3118337:
                    if (type2.equals("enum")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 110364485:
                    if (type2.equals("timer")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 111972721:
                    if (type2.equals("value")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                str = actionBean.getSchema().getProperty();
                cls = ValueProperty.class;
            } else if (c2 == 1) {
                EnumProperty enumProperty = new EnumProperty();
                this.property = enumProperty;
                HashMap<Object, String> enums = enumProperty.getEnums();
                for (Object next : actionBean.rangeKeys) {
                    enums.put(next, actionBean.rangeValues.get(actionBean.rangeKeys.indexOf(next)));
                }
                return;
            } else if (c2 == 2) {
                BoolProperty boolProperty = new BoolProperty();
                this.property = boolProperty;
                HashMap<Boolean, String> boolMap = boolProperty.getBoolMap();
                for (Object next2 : actionBean.rangeKeys) {
                    boolMap.put((Boolean) next2, actionBean.rangeValues.get(actionBean.rangeKeys.indexOf(next2)));
                }
                return;
            } else if (c2 == 3) {
                str = actionBean.getSchema().getProperty();
                cls = TimerProperty.class;
            } else {
                return;
            }
            this.property = (IProperty) JSON.parseObject(str, cls);
        }
    }

    public String getEntityName() {
        return this.entityName;
    }

    public int getEntityType() {
        return this.entityType;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNewIcon() {
        return this.newIcon;
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public IProperty getProperty() {
        return this.property;
    }

    public String getType() {
        return this.type;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public void setEntityType(int i) {
        this.entityType = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNewIcon(String str) {
        this.newIcon = str;
    }

    public void setOperators(List<String> list) {
        this.operators = list;
    }

    public void setProperty(IProperty iProperty) {
        this.property = iProperty;
    }

    public void setType(String str) {
        this.type = str;
    }
}
