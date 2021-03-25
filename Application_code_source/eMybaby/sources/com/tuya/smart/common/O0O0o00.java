package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class O0O0o00 {
    public static final O0O0o00 O000000o = new O0O0o00();
    public HashMap<String, o00o0o00oo> O00000Oo = new HashMap<>(15);
    public HashMap<String, Boolean> O00000o = new HashMap<>(15);
    public HashMap<String, TuyaSigMeshBean> O00000o0 = new HashMap<>(15);

    public static O0O0o00 O000000o() {
        return O000000o;
    }

    public void O000000o(String str) {
        this.O00000Oo.remove(str);
    }

    public void O000000o(String str, TuyaSigMeshBean tuyaSigMeshBean) {
        this.O00000o0.put(str, tuyaSigMeshBean);
    }

    public void O000000o(String str, o00o0o00oo o00o0o00oo) {
        this.O00000Oo.put(str, o00o0o00oo);
    }

    public void O000000o(String str, String str2) {
        this.O00000o.put(a.k(str, str2), Boolean.TRUE);
    }

    public o00o0o00oo O00000Oo(String str) {
        return this.O00000Oo.get(str);
    }

    public void O00000Oo() {
        this.O00000o.clear();
    }

    public void O00000Oo(String str, String str2) {
        this.O00000o.put(a.k(str, str2), Boolean.FALSE);
    }

    public TuyaSigMeshBean O00000o(String str) {
        return this.O00000o0.get(str);
    }

    public void O00000o(String str, String str2) {
        HashMap<String, Boolean> hashMap = this.O00000o;
        hashMap.remove(str + str2);
    }

    public void O00000o0(String str) {
        this.O00000o0.remove(str);
    }

    public boolean O00000o0(String str, String str2) {
        Boolean bool = this.O00000o.get(a.k(str, str2));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void O00000oO(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.O00000o.entrySet()) {
            if (((String) next.getKey()).startsWith(str)) {
                arrayList.add(next.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.O00000o.remove((String) it.next());
        }
    }
}
