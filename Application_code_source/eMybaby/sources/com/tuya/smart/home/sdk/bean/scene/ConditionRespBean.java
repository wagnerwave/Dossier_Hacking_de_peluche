package com.tuya.smart.home.sdk.bean.scene;

import com.tuya.smart.android.device.bean.SchemaBean;
import java.util.List;

public class ConditionRespBean {
    public static final int ENTITY_TYPE_DEV = -1;
    public ConditionExtraInfoBean condCalExtraInfo;
    public String entityId;
    public String entityName;
    public String entitySubId;
    public int entityType;
    public long id;
    public List<MCGroup> mcGroups;
    public String newIcon;
    public String operators;
    public SchemaBean property;
    public String status;
    public String valueRangeDisplay;
    public List<List<Object>> valueRangeJson;

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

    public long getId() {
        return this.id;
    }

    public List<MCGroup> getMcGroups() {
        return this.mcGroups;
    }

    public String getNewIcon() {
        return this.newIcon;
    }

    public String getOperators() {
        return this.operators;
    }

    public SchemaBean getProperty() {
        return this.property;
    }

    public String getStatus() {
        return this.status;
    }

    public String getValueRangeDisplay() {
        return this.valueRangeDisplay;
    }

    public List<List<Object>> getValueRangeJson() {
        return this.valueRangeJson;
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

    public void setId(long j) {
        this.id = j;
    }

    public void setMcGroups(List<MCGroup> list) {
        this.mcGroups = list;
    }

    public void setNewIcon(String str) {
        this.newIcon = str;
    }

    public void setOperators(String str) {
        this.operators = str;
    }

    public void setProperty(SchemaBean schemaBean) {
        this.property = schemaBean;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setValueRangeDisplay(String str) {
        this.valueRangeDisplay = str;
    }

    public void setValueRangeJson(List<List<Object>> list) {
        this.valueRangeJson = list;
    }
}
