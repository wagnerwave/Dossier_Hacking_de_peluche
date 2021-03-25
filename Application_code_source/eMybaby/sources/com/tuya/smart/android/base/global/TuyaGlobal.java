package com.tuya.smart.android.base.global;

import android.os.Build;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.common.utils.TyCommonUtil;

public class TuyaGlobal {
    public static String mLang;
    public static final String mOsSystem = Build.VERSION.RELEASE;
    public static final String mPlatForm = Build.MODEL;
    public static volatile TuyaGlobal mTuyaGlobal;

    public TuyaGlobal() {
        mLang = TyCommonUtil.getLang(TuyaSmartSdk.getApplication());
    }

    public static TuyaGlobal getInstance() {
        if (mTuyaGlobal == null) {
            synchronized (TuyaGlobal.class) {
                if (mTuyaGlobal == null) {
                    mTuyaGlobal = new TuyaGlobal();
                }
            }
        }
        return mTuyaGlobal;
    }

    public String getLang() {
        return mLang;
    }

    public String getOsSystem() {
        return mOsSystem;
    }

    public String getPlatForm() {
        return mPlatForm;
    }
}
