package com.tuya.smart.android.device.bean;

import java.util.ArrayList;

public class DataPointStatBean {
    public ArrayList<DataPointBean> data;
    public String total;

    public ArrayList<DataPointBean> getData() {
        return this.data;
    }

    public String getTotal() {
        return this.total;
    }

    public void setData(ArrayList<DataPointBean> arrayList) {
        this.data = arrayList;
    }

    public void setTotal(String str) {
        this.total = str;
    }
}
