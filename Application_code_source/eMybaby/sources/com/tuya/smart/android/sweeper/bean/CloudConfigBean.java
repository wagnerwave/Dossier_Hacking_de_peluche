package com.tuya.smart.android.sweeper.bean;

public class CloudConfigBean {
    public String ak;
    public String bucket;
    public String endpoint;
    public String expiration;
    public PathConfig pathConfig;
    public String provider;
    public String region;
    public String sk;
    public String token;

    public String getAk() {
        return this.ak;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public PathConfig getPathConfig() {
        return this.pathConfig;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getRegion() {
        return this.region;
    }

    public String getSk() {
        return this.sk;
    }

    public String getToken() {
        return this.token;
    }

    public void setAk(String str) {
        this.ak = str;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setExpiration(String str) {
        this.expiration = str;
    }

    public void setPathConfig(PathConfig pathConfig2) {
        this.pathConfig = pathConfig2;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSk(String str) {
        this.sk = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
