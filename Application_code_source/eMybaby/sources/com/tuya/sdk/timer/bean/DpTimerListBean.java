package com.tuya.sdk.timer.bean;

import java.util.ArrayList;

public class DpTimerListBean {
    public CategoryStatusBean category;
    public ArrayList<GroupTimerBean> groups;

    public CategoryStatusBean getCategory() {
        return this.category;
    }

    public ArrayList<GroupTimerBean> getGroups() {
        return this.groups;
    }

    public void setCategory(CategoryStatusBean categoryStatusBean) {
        this.category = categoryStatusBean;
    }

    public void setGroups(ArrayList<GroupTimerBean> arrayList) {
        this.groups = arrayList;
    }
}
