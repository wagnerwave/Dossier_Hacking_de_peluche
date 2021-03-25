package com.tuya.smart.sdk.bean.feedback;

public class FeedbackBean extends FeedbackTypeBean {
    public String content;
    public String dateTime;

    public String getContent() {
        return this.content;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }
}
