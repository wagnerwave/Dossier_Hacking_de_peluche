package com.tuya.smart.android.sweeper;

import com.tuya.smart.android.sweeper.bean.SweeperDataBean;

public interface ITuyaSweeperDataListener {
    void onSweeperDataReceived(SweeperDataBean sweeperDataBean);
}
