package com.tuya.smart.common;

import com.tuya.smart.android.mvp.presenter.BasePresenter;
import com.tuya.smart.home.sdk.api.ITuyaHomeChangeListener;
import com.tuya.smart.home.sdk.api.ITuyaHomeManager;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.sdk.TuyaSdk;
import java.util.List;

public class o0o0o0ooo extends BasePresenter implements ITuyaHomeManager {
    public final o0o0o00o0 O000000o = new o0o00oooo(TuyaSdk.getApplication(), this.mHandler);

    public void createHome(String str, double d2, double d3, String str2, List<String> list, ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.O000000o.O000000o(str, d2, d3, str2, list, iTuyaHomeResultCallback);
    }

    public void queryHomeList(ITuyaGetHomeListCallback iTuyaGetHomeListCallback) {
        this.O000000o.O000000o(iTuyaGetHomeListCallback);
    }

    public void registerTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        o0o0ooo0o.O00000Oo().O000000o(iTuyaHomeChangeListener);
    }

    public void unRegisterTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        o0o0ooo0o.O00000Oo().O00000Oo(iTuyaHomeChangeListener);
    }
}
