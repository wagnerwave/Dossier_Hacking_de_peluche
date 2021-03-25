package com.tuya.smart.sdk.bean.feedback;

import java.util.ArrayList;

public class FeedbackMsgListBean {
    public int lastTime;
    public ArrayList<FeedbackMsgBean> list;

    public int getLastTime() {
        return this.lastTime;
    }

    public ArrayList<FeedbackMsgBean> getList() {
        return this.list;
    }

    public void setLastTime(int i) {
        this.lastTime = i;
    }

    public void setList(ArrayList<FeedbackMsgBean> arrayList) {
        this.list = arrayList;
    }
}
