package com.tuya.smart.home.sdk.bean.scene.condition.rule;

import android.text.TextUtils;
import com.tuya.smart.android.network.TuyaApiParams;
import java.util.HashMap;

public class TimerRule extends Rule {
    public TimerRule(String str, String str2, String str3, String str4) {
        this.expr.clear();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(TuyaApiParams.KEY_TIME_ZONE_ID, str);
        }
        hashMap.put("loops", str2);
        hashMap.put("time", str3);
        hashMap.put("date", str4);
        this.expr.add(hashMap);
    }

    public static TimerRule newInstance(String str, String str2, String str3) {
        return new TimerRule((String) null, str, str2, str3);
    }

    public static TimerRule newInstance(String str, String str2, String str3, String str4) {
        return new TimerRule(str, str2, str3, str4);
    }
}
