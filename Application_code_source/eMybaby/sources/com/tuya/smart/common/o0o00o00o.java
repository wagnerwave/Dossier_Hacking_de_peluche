package com.tuya.smart.common;

import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.List;

public class o0o00o00o implements o0oo0o0o0o {
    public static volatile o0o00o00o O000000o;
    public final o0o00oo0o O00000Oo = new o0o00oo0o(TuyaSdk.getApplication());

    public static o0oo0o0o0o O000000o() {
        if (O000000o == null) {
            synchronized (o0o00o00o.class) {
                if (O000000o == null) {
                    O000000o = new o0o00o00o();
                }
            }
        }
        return O000000o;
    }

    public void O000000o(long j, DeviceRespBean deviceRespBean, ProductBean productBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(deviceRespBean);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(productBean);
        this.O00000Oo.O000000o(j, (List<DeviceRespBean>) arrayList, (List<ProductBean>) arrayList2);
    }
}
