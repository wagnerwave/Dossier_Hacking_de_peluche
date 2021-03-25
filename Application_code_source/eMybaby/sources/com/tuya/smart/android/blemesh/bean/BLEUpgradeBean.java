package com.tuya.smart.android.blemesh.bean;

import com.tuya.smart.android.device.bean.UpgradeInfoBean;

public class BLEUpgradeBean extends UpgradeInfoBean {
    public long fileSize;
    public String md5;
    public String url;

    public long getFileSize() {
        return this.fileSize;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
