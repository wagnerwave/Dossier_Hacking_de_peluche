package com.tuya.smart.common;

import com.tuya.sdk.home.bean.RoomResponseBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class o0o00o0o0 {
    public static volatile o0o00o0o0 O000000o;
    public ConcurrentHashMap<Long, RoomBean> O00000Oo = new ConcurrentHashMap<>();

    public static o0o00o0o0 O000000o() {
        if (O000000o == null) {
            synchronized (o0o00o0o0.class) {
                if (O000000o == null) {
                    O000000o = new o0o00o0o0();
                }
            }
        }
        return O000000o;
    }

    private void O000000o(HashMap<Long, RoomBean> hashMap) {
        this.O00000Oo.putAll(hashMap);
    }

    public RoomBean O000000o(Long l) {
        return this.O00000Oo.get(l);
    }

    public void O000000o(long j) {
        this.O00000Oo.remove(Long.valueOf(j));
    }

    public void O000000o(Long l, RoomBean roomBean) {
        this.O00000Oo.put(l, roomBean);
    }

    public void O000000o(ArrayList<RoomResponseBean> arrayList) {
        Iterator<RoomResponseBean> it = arrayList.iterator();
        while (it.hasNext()) {
            RoomResponseBean next = it.next();
            O000000o().O000000o(Long.valueOf(next.getId())).setDisplayOrder(next.getDisplayOrder());
        }
    }

    public void O000000o(List<RoomBean> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (RoomBean next : list) {
                hashMap.put(Long.valueOf(next.getRoomId()), next);
            }
            O000000o((HashMap<Long, RoomBean>) hashMap);
        }
    }

    public List<RoomBean> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O00000Oo.values());
        return arrayList;
    }

    public void O00000o0() {
        this.O00000Oo.clear();
    }
}
