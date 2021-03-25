package com.tuya.smart.android.sweeper;

import com.tuya.smart.android.sweeper.bean.SweeperHistory;
import com.tuya.smart.android.sweeper.bean.SweeperPathBean;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import java.util.List;

public interface ITuyaSweeper {
    void deleteAllHistoryData(String str, ITuyaDelHistoryCallback iTuyaDelHistoryCallback);

    void deleteSweeperHistoryData(String str, List<String> list, ITuyaDelHistoryCallback iTuyaDelHistoryCallback);

    String getCloudFileUrl(String str, String str2);

    void getSweeperByteData(String str, String str2, ITuyaByteDataListener iTuyaByteDataListener);

    void getSweeperCurrentPath(String str, ITuyaResultCallback<SweeperPathBean> iTuyaResultCallback);

    void getSweeperHistoryData(String str, int i, int i2, long j, long j2, ITuyaResultCallback<SweeperHistory> iTuyaResultCallback);

    void getSweeperHistoryData(String str, int i, int i2, ITuyaResultCallback<SweeperHistory> iTuyaResultCallback);

    void initCloudConfig(String str, ITuyaCloudConfigCallback iTuyaCloudConfigCallback);

    void onDestroy();

    void startConnectSweeperByteDataChannel(ITuyaSweeperByteDataListener iTuyaSweeperByteDataListener);

    void startConnectSweeperDataChannel(ITuyaSweeperDataListener iTuyaSweeperDataListener);

    void stopConnectSweeperByteDataChannel();

    void stopConnectSweeperDataChannel();

    void updateCloudConfig(String str, ITuyaCloudConfigCallback iTuyaCloudConfigCallback);
}
