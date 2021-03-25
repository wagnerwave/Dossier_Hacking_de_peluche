package com.tuya.smart.home.sdk.bean.scene;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.device.bean.SchemaBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ConditionActionBean extends ActionBean {
    public String choosedOperator;
    public ConditionExtraInfoBean condCalExtraInfo;
    public String entityId;
    public String entityName;
    public String entitySubId;
    public int entityType;
    public List<String> mcGroupNames;
    public String newIcon;
    public List<String> operators;
    public SchemaBean schema;

    public ConditionActionBean() {
    }

    public ConditionActionBean(ConditionRespBean conditionRespBean) {
        setName(conditionRespBean.getEntityName());
        setId(conditionRespBean.getId());
        setEntityType(conditionRespBean.getEntityType());
        setEntitySubId(conditionRespBean.getEntitySubId());
        setEntityId(conditionRespBean.getEntityId());
        setEntityName(conditionRespBean.getEntityName());
        setCondCalExtraInfo(conditionRespBean.getCondCalExtraInfo());
        List<MCGroup> mcGroups = conditionRespBean.getMcGroups();
        this.mcGroupNames = new ArrayList();
        if (mcGroups != null && !mcGroups.isEmpty()) {
            for (MCGroup groupName : mcGroups) {
                this.mcGroupNames.add(groupName.getGroupName());
            }
        }
        setDpId((conditionRespBean.getEntityType() == 1 || conditionRespBean.getEntityType() == 7) ? Long.valueOf(conditionRespBean.getProperty().getId()).longValue() : conditionRespBean.getId());
        this.actDetail = conditionRespBean.getValueRangeDisplay();
        List<List<Object>> valueRangeJson = conditionRespBean.getValueRangeJson();
        if (valueRangeJson != null) {
            for (List next : valueRangeJson) {
                this.rangeKeys.add(next.get(0));
                this.rangeValues.add(next.get(1).toString());
            }
        }
        setSchema(conditionRespBean.getProperty());
        try {
            if (!TextUtils.isEmpty(conditionRespBean.getOperators())) {
                this.operators = JSON.parseArray(conditionRespBean.getOperators(), String.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (conditionRespBean.getProperty() != null) {
                setType(new JSONObject(conditionRespBean.getProperty().getProperty()).getString("type"));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        setNewIcon(conditionRespBean.getNewIcon());
    }

    public String getChoosedOperator() {
        return this.choosedOperator;
    }

    public ConditionExtraInfoBean getCondCalExtraInfo() {
        return this.condCalExtraInfo;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public String getEntitySubId() {
        return this.entitySubId;
    }

    public int getEntityType() {
        return this.entityType;
    }

    public List<String> getMcGroupNames() {
        return this.mcGroupNames;
    }

    public String getNewIcon() {
        return this.newIcon;
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public SchemaBean getSchema() {
        return this.schema;
    }

    public void setChoosedOperator(String str) {
        this.choosedOperator = str;
    }

    public void setCondCalExtraInfo(ConditionExtraInfoBean conditionExtraInfoBean) {
        this.condCalExtraInfo = conditionExtraInfoBean;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public void setEntitySubId(String str) {
        this.entitySubId = str;
    }

    public void setEntityType(int i) {
        this.entityType = i;
    }

    public void setMcGroupNames(List<String> list) {
        this.mcGroupNames = list;
    }

    public void setNewIcon(String str) {
        this.newIcon = str;
    }

    public void setOperators(List<String> list) {
        this.operators = list;
    }

    public void setSchema(SchemaBean schemaBean) {
        this.schema = schemaBean;
    }
}
