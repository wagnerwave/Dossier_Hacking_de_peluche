package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;
import java.util.List;

public class ConditionAllBean implements Serializable {
    public List<ConditionRespBean> devConds;
    public List<ConditionRespBean> envConds;

    public List<ConditionRespBean> getDevConds() {
        return this.devConds;
    }

    public List<ConditionRespBean> getEnvConds() {
        return this.envConds;
    }

    public void setDevConds(List<ConditionRespBean> list) {
        this.devConds = list;
    }

    public void setEnvConds(List<ConditionRespBean> list) {
        this.envConds = list;
    }
}
