package com.tuya.sdk.mqttmanager.bean;

public class MqttConfigBean {
    public boolean cleanSession;
    public String clientId;
    public boolean debug;
    public int keepAlive;
    public int maxInflight;
    public int port;
    public int qos;
    public boolean retained;
    public String serverUrl;
    public boolean ssl;
    public String sslKey;
    public String sslPassword;
    public int timeOut;
    public String userName;
    public String willTopic;

    public String getClientId() {
        return this.clientId;
    }

    public int getKeepAlive() {
        return this.keepAlive;
    }

    public int getMaxInflight() {
        return this.maxInflight;
    }

    public int getPort() {
        return this.port;
    }

    public int getQos() {
        return this.qos;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public String getSslKey() {
        return this.sslKey;
    }

    public String getSslPassword() {
        return this.sslPassword;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWillTopic() {
        return this.willTopic;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isRetained() {
        return this.retained;
    }

    public boolean isSsl() {
        return this.ssl;
    }

    public void setCleanSession(boolean z) {
        this.cleanSession = z;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setKeepAlive(int i) {
        this.keepAlive = i;
    }

    public void setMaxInflight(int i) {
        this.maxInflight = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setQos(int i) {
        this.qos = i;
    }

    public void setRetained(boolean z) {
        this.retained = z;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public void setSsl(boolean z) {
        this.ssl = z;
    }

    public void setSslKey(String str) {
        this.sslKey = str;
    }

    public void setSslPassword(String str) {
        this.sslPassword = str;
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setWillTopic(String str) {
        this.willTopic = str;
    }
}
