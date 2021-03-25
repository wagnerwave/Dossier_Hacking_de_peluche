package com.tuya.smart.sdk.bean.feedback;

public class FeedbackTypeBean {
    public String hdId;
    public int hdType;
    public String title;

    public String getHdId() {
        return this.hdId;
    }

    public int getHdType() {
        return this.hdType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setHdId(String str) {
        this.hdId = str;
    }

    public void setHdType(int i) {
        this.hdType = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
