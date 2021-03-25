package com.tuya.smart.sdk.bean;

import java.util.HashMap;
import java.util.Map;

public class UiInfo {
    public String appRnVersion;
    public String name;
    public String phase;
    public boolean rnFind;
    public String type;
    public String ui;
    public Map<String, Object> uiConfig = new HashMap();

    public String getAppRnVersion() {
        return this.appRnVersion;
    }

    public String getName() {
        return this.name;
    }

    public String getPhase() {
        return this.phase;
    }

    public boolean getRnFind() {
        return this.rnFind;
    }

    public String getType() {
        return this.type;
    }

    public String getUi() {
        return this.ui;
    }

    public Map<String, Object> getUiConfig() {
        return this.uiConfig;
    }

    public void setAppRnVersion(String str) {
        this.appRnVersion = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhase(String str) {
        this.phase = str;
    }

    public void setRnFind(boolean z) {
        this.rnFind = z;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUi(String str) {
        this.ui = str;
    }

    public void setUiConfig(Map<String, Object> map) {
        this.uiConfig = map;
    }
}
