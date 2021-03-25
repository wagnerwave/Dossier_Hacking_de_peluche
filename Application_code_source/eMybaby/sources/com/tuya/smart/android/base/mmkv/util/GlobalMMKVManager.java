package com.tuya.smart.android.base.mmkv.util;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.base.mmkv.manager.MMKVManager;
import com.tuya.smart.android.base.utils.PreferencesUtil;

public class GlobalMMKVManager {
    public static volatile MMKVManager sMMKVManager;

    public static MMKVManager getMMKVManager() {
        if (sMMKVManager == null) {
            synchronized (GlobalMMKVManager.class) {
                if (sMMKVManager == null) {
                    sMMKVManager = new MMKVManager(TuyaSmartSdk.getApplication(), PreferencesUtil.GLOBAL_KEY, true);
                }
            }
        }
        return sMMKVManager;
    }
}
