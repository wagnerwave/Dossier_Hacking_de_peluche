package com.tuya.smart.common;

import a.e.a.a.a;
import com.tuya.sdk.tuyamesh.blemesh.search.BlueMeshSearch;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.BlueMeshBean;

public class OoO0o {
    public static final String O000000o = "BleSearchDevSingle";
    public O000000o O00000Oo;
    public final BlueMeshSearch O00000o = new BlueMeshSearch(TuyaSdk.getApplication());
    public a O00000o0 = o00o0o0o00.O000000o().O00000Oo();

    public interface O000000o {
        void O000000o();

        void O000000o(SearchDeviceBean searchDeviceBean);

        void O00000Oo();
    }

    public void O000000o() {
        L.d(O000000o, "cancel");
        this.O00000Oo = null;
        this.O00000o.stopSearch();
    }

    public void O000000o(BlueMeshBean blueMeshBean, int i, O000000o o000000o) {
        StringBuilder n = a.a.a.a.a.n("code: ");
        n.append(blueMeshBean.getCode());
        L.d(O000000o, n.toString());
        this.O00000Oo = o000000o;
        this.O00000o.searchDeviceConnected(blueMeshBean.getCode(), i, 10000, (o00oo00o00) new o00oo00o00() {
            public void O000000o() {
                if (OoO0o.this.O00000Oo != null) {
                    OoO0o.this.O00000Oo.O000000o();
                }
            }

            public synchronized void O000000o(SearchDeviceBean searchDeviceBean) {
                L.d(OoO0o.O000000o, "name: " + searchDeviceBean.getMeshName());
                if (OoO0o.this.O00000Oo != null) {
                    OoO0o.this.O00000Oo.O000000o(searchDeviceBean);
                }
                OoO0o.this.O00000o.stopSearch();
            }

            public void O00000Oo() {
                if (OoO0o.this.O00000Oo != null) {
                    OoO0o.this.O00000Oo.O00000Oo();
                }
            }
        });
    }

    public void O000000o(BlueMeshBean blueMeshBean, O000000o o000000o) {
        O000000o(blueMeshBean, -1, o000000o);
    }

    public void O00000Oo() {
        L.d(O000000o, "stopSearch");
        BlueMeshSearch blueMeshSearch = this.O00000o;
        if (blueMeshSearch != null) {
            blueMeshSearch.stopSearch();
        }
    }
}
