package com.tuya.sdk.scene.bean;

public class LocalSceneResBean {
    public String devId;
    public long dpId;
    public String gwId;
    public String localSid;
    public String ruleBackground;
    public String ruleId;
    public String ruleName;

    public String getDevId() {
        return this.devId;
    }

    public long getDpId() {
        return this.dpId;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getLocalSid() {
        return this.localSid;
    }

    public String getRuleBackground() {
        return this.ruleBackground;
    }

    public String getRuleId() {
        return this.ruleId;
    }

    public String getRuleName() {
        return this.ruleName;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDpId(long j) {
        this.dpId = j;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setLocalSid(String str) {
        this.localSid = str;
    }

    public void setRuleBackground(String str) {
        this.ruleBackground = str;
    }

    public void setRuleId(String str) {
        this.ruleId = str;
    }

    public void setRuleName(String str) {
        this.ruleName = str;
    }
}
