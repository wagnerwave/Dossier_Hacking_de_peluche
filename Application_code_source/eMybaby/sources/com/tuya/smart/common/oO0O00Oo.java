package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class oO0O00Oo {
    public static volatile oO0O00Oo O000000o;
    public Map<String, ProductBean> O00000Oo = new ConcurrentHashMap();

    public static oO0O00Oo O000000o() {
        if (O000000o == null) {
            synchronized (oO0O00Oo.class) {
                if (O000000o == null) {
                    O000000o = new oO0O00Oo();
                }
            }
        }
        return O000000o;
    }

    private void O000000o(HashMap<String, ProductBean> hashMap) {
        this.O00000Oo.putAll(hashMap);
    }

    private void O000000o(Map<String, ProductBean> map) {
        this.O00000Oo.clear();
        this.O00000Oo.putAll(map);
    }

    public ProductBean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00000Oo.get(str);
    }

    public void O000000o(List<ProductBean> list) {
        O00000Oo(list);
    }

    public void O00000Oo() {
        this.O00000Oo.clear();
    }

    public void O00000Oo(List<ProductBean> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (ProductBean next : list) {
                hashMap.put(next.getId(), next);
            }
            O000000o((HashMap<String, ProductBean>) hashMap);
        }
    }
}
