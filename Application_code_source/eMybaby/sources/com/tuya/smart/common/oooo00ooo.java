package com.tuya.smart.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;

public class oooo00ooo {
    public static final String O000000o = "sig_mesh_storage";
    public static String O00000Oo = "sig_mesh";
    public static String O00000o = "sig_mesh_address";
    public static String O00000o0 = "sig_mesh_seq";
    public static oooo00ooo O00000oO;
    public SharedPreferences O00000oo;

    public oooo00ooo(Context context) {
        this.O00000oo = context.getSharedPreferences(O000000o, 4);
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        StringBuilder sb = new StringBuilder();
        sb.append(O00000Oo);
        sb.append(o0o00oo0oo != null ? o0o00oo0oo.O000000o().getUser().getSid() : "");
        O00000Oo = sb.toString();
    }

    public static synchronized oooo00ooo O000000o() {
        oooo00ooo oooo00ooo;
        synchronized (oooo00ooo.class) {
            if (O00000oO == null) {
                O00000oO = new oooo00ooo(TuyaSmartSdk.getApplication());
            }
            oooo00ooo = O00000oO;
        }
        return oooo00ooo;
    }

    public int O000000o(String str) {
        SharedPreferences sharedPreferences = this.O00000oo;
        return sharedPreferences.getInt(O00000o0 + str, 0);
    }

    public void O000000o(int i, String str) {
        SharedPreferences.Editor edit = this.O00000oo.edit();
        edit.putInt(O00000o0 + str, i).apply();
    }

    public void O000000o(SigMeshBean sigMeshBean) {
        if (sigMeshBean != null) {
            List<SigMeshBean> O00000Oo2 = O00000Oo();
            int size = O00000Oo2.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                if (TextUtils.equals(O00000Oo2.get(i).getMeshId(), sigMeshBean.getMeshId())) {
                    O00000Oo2.set(i, sigMeshBean);
                    z = true;
                }
            }
            if (!z) {
                O00000Oo2.add(sigMeshBean);
            }
            O000000o(O00000Oo2);
        }
    }

    public void O000000o(List<SigMeshBean> list) {
        this.O00000oo.edit().putString(O00000Oo, JSON.toJSONString(list)).apply();
    }

    public int O00000Oo(String str) {
        SharedPreferences sharedPreferences = this.O00000oo;
        return sharedPreferences.getInt(O00000o + str, 0);
    }

    public List<SigMeshBean> O00000Oo() {
        List<SigMeshBean> list = null;
        String string = this.O00000oo.getString(O00000Oo, (String) null);
        if (string != null) {
            list = JSON.parseArray(string, SigMeshBean.class);
        }
        return list == null ? new ArrayList() : list;
    }

    public void O00000Oo(int i, String str) {
        SharedPreferences.Editor edit = this.O00000oo.edit();
        edit.putInt(O00000o + str, i).apply();
    }

    public void O00000o0() {
        this.O00000oo.edit().remove(O00000Oo).apply();
    }

    public void O00000o0(String str) {
        List<SigMeshBean> O00000Oo2 = O00000Oo();
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
}
