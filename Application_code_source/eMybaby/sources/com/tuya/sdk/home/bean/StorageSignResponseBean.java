package com.tuya.sdk.home.bean;

import com.tuya.smart.android.mvp.bean.IBean;
import java.util.HashMap;

public class StorageSignResponseBean implements IBean {
    public String cloudkey;
    public String endUri;
    public HashMap headers;

    public String getCloudkey() {
        return this.cloudkey;
    }

    public String getEndUri() {
        return this.endUri;
    }

    public HashMap getHeaders() {
        return this.headers;
    }

    public String getUri() {
        return this.endUri + this.cloudkey;
    }

    public void setCloudkey(String str) {
        this.cloudkey = str;
    }

    public void setEndUri(String str) {
        this.endUri = str;
    }

    public void setHeaders(HashMap hashMap) {
        this.headers = hashMap;
    }
}
