package com.tuya.smart.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.user.bean.User;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.ArrayList;
import java.util.List;

public class O0000Oo0 {
    public static final String O000000o = "bule_mesh_storage";
    public static String O00000Oo = "bule_mesh";
    public static O0000Oo0 O00000o0;
    public SharedPreferences O00000o;

    public O0000Oo0(Context context) {
        User user;
        this.O00000o = context.getSharedPreferences(O000000o, 4);
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo != null && (user = o0o00oo0oo.O000000o().getUser()) != null) {
            O00000Oo += user.getSid();
        }
    }

    public static synchronized O0000Oo0 O000000o() {
        O0000Oo0 o0000Oo0;
        synchronized (O0000Oo0.class) {
            if (O00000o0 == null) {
                O00000o0 = new O0000Oo0(TuyaSmartSdk.getApplication());
            }
            o0000Oo0 = O00000o0;
        }
        return o0000Oo0;
    }

    public void O000000o(BlueMeshBean blueMeshBean) {
        if (blueMeshBean != null) {
            List<BlueMeshBean> O00000Oo2 = O00000Oo();
            int size = O00000Oo2.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                if (TextUtils.equals(O00000Oo2.get(i).getMeshId(), blueMeshBean.getMeshId())) {
                    O00000Oo2.set(i, blueMeshBean);
                    z = true;
                }
            }
            if (!z) {
                O00000Oo2.add(blueMeshBean);
            }
            O000000o(O00000Oo2);
        }
    }

    public void O000000o(String str) {
        List<BlueMeshBean> O00000Oo2 = O00000Oo();
        int size = O00000Oo2.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (TextUtils.equals(O00000Oo2.get(i).getMeshId(), str)) {
                O00000Oo2.remove(i);
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            O000000o(O00000Oo2);
        }
    }

    public void O000000o(List<BlueMeshBean> list) {
        this.O00000o.edit().putString(O00000Oo, JSON.toJSONString(list)).apply();
    }

    public List<BlueMeshBean> O00000Oo() {
        List<BlueMeshBean> list = null;
        String string = this.O00000o.getString(O00000Oo, (String) null);
        if (string != null) {
            list = JSON.parseArray(string, BlueMeshBean.class);
        }
        return list == null ? new ArrayList() : list;
    }

    public void O00000o0() {
        this.O00000o.edit().remove(O00000Oo).apply();
    }
}
