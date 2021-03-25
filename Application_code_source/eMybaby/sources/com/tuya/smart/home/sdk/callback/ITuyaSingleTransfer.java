package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.home.sdk.bean.TransferDataBean;
import com.tuya.smart.sdk.api.ITuyaDataCallback;

public interface ITuyaSingleTransfer {
    boolean isOnline();

    void registerTransferCallback(ITuyaTransferCallback iTuyaTransferCallback);

    void registerTransferDataListener(ITuyaDataCallback<TransferDataBean> iTuyaDataCallback);

    void startConnect();

    void stopConnect();

    void subscribeDevice(String str);

    void unRegisterTransferCallback(ITuyaTransferCallback iTuyaTransferCallback);

    void unRegisterTransferDataListener(ITuyaDataCallback<TransferDataBean> iTuyaDataCallback);

    void unSubscribeDevice(String str);
}
