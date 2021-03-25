package com.tuya.smart.home.sdk.bean;

import java.util.List;

public class SpeechPhraseBean {
    public String categoryName;
    public List<String> dics;
    public String url;

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<String> getDics() {
        return this.dics;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setDics(List<String> list) {
        this.dics = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
