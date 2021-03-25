package com.tuya.smart.sdk.bean;

public class SpeechTTSBean {
    public String format;
    public String httpRequestType;
    public boolean keepSession;
    public String requestBody;
    public String text;
    public String ttsUrl;

    public SpeechTTSBean(String str, String str2, boolean z, String str3, String str4, String str5) {
        this.format = str;
        this.httpRequestType = str2;
        this.keepSession = z;
        this.requestBody = str3;
        this.text = str4;
        this.ttsUrl = str5;
    }

    public String getFormat() {
        return this.format;
    }

    public String getHttpRequestType() {
        return this.httpRequestType;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public String getText() {
        return this.text;
    }

    public String getTtsUrl() {
        return this.ttsUrl;
    }

    public boolean isKeepSession() {
        return this.keepSession;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setHttpRequestType(String str) {
        this.httpRequestType = str;
    }

    public void setKeepSession(boolean z) {
        this.keepSession = z;
    }

    public void setRequestBody(String str) {
        this.requestBody = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTtsUrl(String str) {
        this.ttsUrl = str;
    }
}
