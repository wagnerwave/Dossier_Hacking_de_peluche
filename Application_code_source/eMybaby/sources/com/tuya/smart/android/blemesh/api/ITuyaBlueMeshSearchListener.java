package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;

public interface ITuyaBlueMeshSearchListener {
    void onSearchFinish();

    void onSearched(SearchDeviceBean searchDeviceBean);
}
