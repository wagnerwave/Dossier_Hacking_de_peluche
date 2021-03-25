package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;
import java.util.List;

public class ActRespBean implements Serializable {
    public String actDetail;
    public long dpId;
    public String dpName;
    public long id;
    public String name;
    public List<String> operators;
    public String valueRangeDisplay;
    public String valueRangeJson;

    public String getActDetail() {
        return this.actDetail;
    }

    public long getDpId() {
        return this.dpId;
    }

    public String getDpName() {
        return this.dpName;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperators() {
        return this.operators;
    }

    public String getValueRangeDisplay() {
        return this.valueRangeDisplay;
    }

    public String getValueRangeJson() {
        return this.valueRangeJson;
    }

    public void setActDetail(String str) {
        this.actDetail = str;
    }

    public void setDpId(long j) {
        this.dpId = j;
    }

    public void setDpName(String str) {
        this.dpName = str;
    }

    public void setId(int i) {
        this.id = (long) i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperators(List<String> list) {
        this.operators = list;
    }

    public void setValueRangeDisplay(String str) {
        this.valueRangeDisplay = str;
    }

    public void setValueRangeJson(String str) {
        this.valueRangeJson = str;
    }
}
