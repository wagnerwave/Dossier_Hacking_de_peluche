package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import java.util.List;

public interface ITuyaHomeManager {
    void createHome(String str, double d2, double d3, String str2, List<String> list, ITuyaHomeResultCallback iTuyaHomeResultCallback);

    void onDestroy();

    void queryHomeList(ITuyaGetHomeListCallback iTuyaGetHomeListCallback);

    void registerTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener);

    void unRegisterTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener);
}
