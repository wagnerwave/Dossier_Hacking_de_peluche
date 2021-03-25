package com.tuya.smart.blescan;

import java.util.List;

public enum ScanCache {
    INSTANCE;
    
    public static final int MAX_CACHE_COUNT = 40;
    public List<ScanLeBean> beanList;

    private void trimToSize() {
        if (this.beanList.size() >= 40) {
            this.beanList.subList(0, 10).clear();
        }
    }

    public void add(ScanLeBean scanLeBean) {
        this.beanList.add(scanLeBean);
        trimToSize();
    }

    public List<ScanLeBean> getCacheBeanList() {
        return this.beanList;
    }

    public void removeAll() {
        this.beanList.clear();
    }
}
