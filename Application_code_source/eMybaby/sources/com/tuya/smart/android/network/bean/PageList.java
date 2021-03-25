package com.tuya.smart.android.network.bean;

import java.util.List;

public class PageList<T> {
    public List<T> data;
    public int page = 0;
    public int total = 0;

    public List<T> getData() {
        return this.data;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotal() {
        return this.total;
    }

    public void setData(List<T> list) {
        this.data = list;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
