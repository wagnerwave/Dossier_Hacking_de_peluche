package com.tuya.smart.android.sweeper.bean;

import java.util.List;

public class SweeperHistory {
    public List<SweeperHistoryBean> datas;
    public int totalCount;

    public List<SweeperHistoryBean> getDatas() {
        return this.datas;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setDatas(List<SweeperHistoryBean> list) {
        this.datas = list;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }
}
