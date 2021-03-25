package com.tuya.smart.android.sweeper;

import com.tuya.smart.android.sweeper.bean.SweeperByteData;

public interface ITuyaSweeperByteDataListener {
    void onFailure(int i, String str);

    void onSweeperByteData(SweeperByteData sweeperByteData);
}
