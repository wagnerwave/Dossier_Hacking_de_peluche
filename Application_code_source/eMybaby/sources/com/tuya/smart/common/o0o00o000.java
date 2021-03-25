package com.tuya.smart.common;

import com.tuya.smart.home.sdk.bean.HomeBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class o0o00o000 {
    public static volatile o0o00o000 O000000o;
    public ConcurrentHashMap<Long, HomeBean> O00000Oo = new ConcurrentHashMap<>();

    public static o0o00o000 O000000o() {
        if (O000000o == null) {
            synchronized (o0o00o000.class) {
                if (O000000o == null) {
                    O000000o = new o0o00o000();
                }
            }
        }
        return O000000o;
    }

    public HomeBean O000000o(long j) {
        return this.O00000Oo.get(Long.valueOf(j));
    }

    public void O000000o(long j, HomeBean homeBean) {
        this.O00000Oo.put(Long.valueOf(j), homeBean);
    }

    public List<HomeBean> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O00000Oo.values());
        return arrayList;
    }

    public void O00000Oo(long j) {
        this.O00000Oo.remove(Long.valueOf(j));
    }

    public void O00000o0() {
        this.O00000Oo.clear();
    }
}
