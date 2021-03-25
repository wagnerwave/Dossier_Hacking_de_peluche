package com.tuya.sdk.user.bean;

import android.net.Uri;
import com.tuya.smart.android.mvp.bean.IBean;
import java.util.HashMap;

public class StorageSign implements IBean {
    public String cloudkey;
    public String endUri;
    public HashMap headers;
    public String url;

    public String getCloudkey() {
        return this.cloudkey;
    }

    public String getEndUri() {
        return this.endUri;
    }

    public HashMap getHeaders() {
        return this.headers;
    }

    public String getUrl() {
        return this.url;
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

    public void setUrl(String str) {
        this.url = str;
        Uri parse = Uri.parse(str);
        setEndUri(parse.getScheme() + "://" + parse.getHost());
        setCloudkey(parse.getPath());
    }
}
