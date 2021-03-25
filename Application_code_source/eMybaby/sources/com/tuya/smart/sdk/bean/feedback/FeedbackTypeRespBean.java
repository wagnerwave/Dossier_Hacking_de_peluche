package com.tuya.smart.sdk.bean.feedback;

import java.util.ArrayList;

public class FeedbackTypeRespBean {
    public ArrayList<FeedbackTypeBean> list;
    public String type;

    public ArrayList<FeedbackTypeBean> getList() {
        return this.list;
    }

    public String getType() {
        return this.type;
    }

    public void setList(ArrayList<FeedbackTypeBean> arrayList) {
        this.list = arrayList;
    }

    public void setType(String str) {
        this.type = str;
    }
}
