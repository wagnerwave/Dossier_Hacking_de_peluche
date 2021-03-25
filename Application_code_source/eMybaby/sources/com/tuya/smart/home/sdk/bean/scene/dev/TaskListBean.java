package com.tuya.smart.home.sdk.bean.scene.dev;

import com.tuya.smart.android.device.bean.ValueSchemaBean;
import com.tuya.smart.home.sdk.bean.scene.ActionBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionActionBean;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskListBean implements Serializable {
    public static final long serialVersionUID = -5152349627288974102L;
    public ConditionExtraInfoBean condCalExtraInfo;
    public long dpId;
    public int entityType;
    public long id;
    public List<String> mcGroupNames;
    public String name;
    public List<String> operators;
    public HashMap<Object, String> tasks = new HashMap<>();
    public String type;
    public ValueSchemaBean valueSchemaBean;

    public TaskListBean() {
    }

    public TaskListBean(ActionBean actionBean) {
        this.id = actionBean.getId();
        this.name = actionBean.name;
        this.dpId = actionBean.dpId;
        for (Object next : actionBean.rangeKeys) {
            this.tasks.put(next, actionBean.rangeValues.get(actionBean.rangeKeys.indexOf(next)));
        }
        this.type = actionBean.getType();
        this.operators = new ArrayList();
        if (actionBean.getOperators() != null) {
            this.operators.addAll(actionBean.getOperators());
        }
        if (actionBean instanceof ConditionActionBean) {
            ConditionActionBean conditionActionBean = (ConditionActionBean) actionBean;
            this.mcGroupNames = conditionActionBean.getMcGroupNames();
            this.condCalExtraInfo = conditionActionBean.getCondCalExtraInfo();
        }
        this.valueSchemaBean = actionBean.getValueSceheamData();
    }

    public ConditionExtraInfoBean getCondCalExtraInfo() {
        return this.condCalExtraInfo;
    }

    public long getDpId() {
        return this.dpId;
    }

    public int getEntityType() {
        return this.entityType;
    }

    public long getId() {
        return this.id;
    }

    public List<String> getMcGroupNames() {
        return this.mcGroupNames;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public HashMap<Object, String> getTasks() {
        return this.tasks;
    }

    public String getType() {
        return this.type;
    }

    public ValueSchemaBean getValueSchemaBean() {
        return this.valueSchemaBean;
    }

    public void setCondCalExtraInfo(ConditionExtraInfoBean conditionExtraInfoBean) {
        this.condCalExtraInfo = conditionExtraInfoBean;
    }

    public void setDpId(long j) {
        this.dpId = j;
    }

    public void setEntityType(int i) {
        this.entityType = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMcGroupNames(List<String> list) {
        this.mcGroupNames = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperators(List<String> list) {
        this.operators = list;
    }

    public void setType(String str) {
        this.type = str;
    }
}
