package com.tuya.sdk.user.bean;

public class BizCodeDomainBean {
    public String appDomain;
    public String appPort;
    public String key;
    public String uri;

    public String getAppDomain() {
        return this.appDomain;
    }

    public String getAppPort() {
        return this.appPort;
    }

    public String getKey() {
        return this.key;
    }

    public String getUri() {
        return this.uri;
    }

    public void setAppDomain(String str) {
        this.appDomain = str;
    }

    public void setAppPort(String str) {
        this.appPort = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
