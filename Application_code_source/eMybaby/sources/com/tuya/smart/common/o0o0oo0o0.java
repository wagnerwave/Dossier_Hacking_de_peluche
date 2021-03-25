package com.tuya.smart.common;

import com.tuya.sdk.home.cache.TuyaHomeRelationCacheManager;
import com.tuya.smart.home.sdk.api.ITuyaHomeChangeListener;
import com.tuya.smart.home.sdk.api.ITuyaHomeManager;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import java.util.List;

public class o0o0oo0o0 implements ITuyaHomeManager {
    public static volatile o0o0oo0o0 O000000o;
    public o0o0o0ooo O00000Oo = new o0o0o0ooo();

    public static ITuyaHomeManager O000000o() {
        if (O000000o == null) {
            synchronized (o0o0oo0o0.class) {
                if (O000000o == null) {
                    O000000o = new o0o0oo0o0();
                }
            }
        }
        return O000000o;
    }

    public void createHome(String str, double d2, double d3, String str2, List<String> list, ITuyaHomeResultCallback iTuyaHomeResultCallback) {
        this.O00000Oo.createHome(str, d2, d3, str2, list, iTuyaHomeResultCallback);
    }

    public void onDestroy() {
        TuyaHomeRelationCacheManager.O000000o().onDestroy();
    }

    public void queryHomeList(ITuyaGetHomeListCallback iTuyaGetHomeListCallback) {
        this.O00000Oo.queryHomeList(iTuyaGetHomeListCallback);
    }

    public void registerTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        this.O00000Oo.registerTuyaHomeChangeListener(iTuyaHomeChangeListener);
    }

    public void unRegisterTuyaHomeChangeListener(ITuyaHomeChangeListener iTuyaHomeChangeListener) {
        this.O00000Oo.unRegisterTuyaHomeChangeListener(iTuyaHomeChangeListener);
    }
}
