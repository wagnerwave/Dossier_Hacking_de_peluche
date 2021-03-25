package com.tuya.smart.sdk.bean.message;

public class MessageAttach {
    public boolean isVideo = false;
    public String thumbUrl;
    public String url;

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideo(boolean z) {
        this.isVideo = z;
    }
}
