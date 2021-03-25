package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.sdk.bluemesh.bean.MeshRelationBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.home.sdk.api.ITuyaHomeChangeListener;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O0OOOo0 {
    public static final String O000000o = "TuyaMeshInitialize";
    public ITuyaHomeChangeListener O00000Oo = new ITuyaHomeChangeListener() {
        public void onHomeAdded(long j) {
        }

        public void onHomeInfoChanged(long j) {
        }

        public void onHomeInvite(long j, String str) {
        }

        public void onHomeRemoved(long j) {
        }

        public void onServerConnectSuccess() {
            for (String O000000o2 : O0OOOo0.this.O00000o0) {
                O0OOOo0.this.O00000o0(O000000o2);
            }
        }

        public void onSharedDeviceList(List<DeviceBean> list) {
        }

        public void onSharedGroupList(List<GroupBean> list) {
        }
    };
    public o0o0o00000<o0o0oo0o00> O00000o = new o0o0o00000<o0o0oo0o00>() {
        /* renamed from: O000000o */
        public void onResult(o0o0oo0o00 o0o0oo0o00) {
            O0000o.O000000o(o0o0oo0o00.O000000o(), o0o0oo0o00.O00000o(), o0o0oo0o00.O00000Oo(), o0o0oo0o00.O00000o0());
        }
    };
    public List<String> O00000o0 = new ArrayList();
    public o0o0o00000<o0o0oooooo> O00000oO = new o0o0o00000<o0o0oooooo>() {
        /* renamed from: O000000o */
        public void onResult(o0o0oooooo o0o0oooooo) {
            O0000o.O000000o(o0o0oooooo.O000000o(), o0o0oooooo.O00000Oo(), o0o0oooooo.O00000oO(), o0o0oooooo.O00000o0(), o0o0oooooo.O00000o());
        }
    };
    public o0o0o00000<o0o0oo0o0o> O00000oo = new o0o0o00000<o0o0oo0o0o>() {
        /* renamed from: O000000o */
        public void onResult(o0o0oo0o0o o0o0oo0o0o) {
            O0000o.O000000o(o0o0oo0o0o.O00000Oo(), o0o0oo0o0o.O000000o());
        }
    };
    public o0o0o00000<o0o0ooo000> O0000O0o = new o0o0o00000<o0o0ooo000>() {
        /* renamed from: O000000o */
        public void onResult(o0o0ooo000 o0o0ooo000) {
            O0000o.O000000o(o0o0ooo000.O00000Oo(), o0o0ooo000.O000000o());
        }
    };
    public o0o0o00000<o0o0ooo00o> O0000OOo = new o0o0o00000<o0o0ooo00o>() {
        /* renamed from: O000000o */
        public void onResult(o0o0ooo00o o0o0ooo00o) {
            if (o0o0ooo00o.O00000o0()) {
                O0000o.O000000o(o0o0ooo00o.O000000o(), o0o0ooo00o.O00000Oo());
            }
        }
    };
    public o0oo0oo00o O0000Oo = new o0oo0oo00o() {
        public void O000000o() {
            O0000o.O000000o(true);
        }

        public void O000000o(String str, String str2) {
            O0000o.O000000o(false);
        }
    };
    public o0o0o00000<o0oo0000o0> O0000Oo0 = new o0o0o00000<o0oo0000o0>() {
        /* renamed from: O000000o */
        public void onResult(o0oo0000o0 o0oo0000o0) {
            O0000o.O000000o(o0oo0000o0.O000000o(), o0oo0000o0.O00000Oo());
        }
    };

    public static class O000000o {
        public static O0OOOo0 O000000o = new O0OOOo0();
    }

    public static O0OOOo0 O000000o() {
        return O000000o.O000000o;
    }

    private void O00000o() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oooooo.class, this.O00000oO);
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo0o00.class, this.O00000o);
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo0o0o.class, this.O00000oo);
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0ooo000.class, this.O0000O0o);
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0ooo00o.class, this.O0000OOo);
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0oo0000o0.class, this.O0000Oo0);
        }
    }

    private void O00000o0() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oooooo.class, this.O00000oO);
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo0o00.class, this.O00000o);
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo0o0o.class, this.O00000oo);
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0ooo000.class, this.O0000O0o);
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0ooo00o.class, this.O0000OOo);
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0oo0000o0.class, this.O0000Oo0);
        }
    }

    /* access modifiers changed from: private */
    public void O00000o0(final String str) {
        L.d(O000000o, "requestMeshRelationList");
        if (!TextUtils.isEmpty(str)) {
            new O0OOo().O00000o0(str, new Business.ResultListener<Map<String, String>>() {
                /* renamed from: O000000o */
                public void onFailure(BusinessResponse businessResponse, Map<String, String> map, String str) {
                }

                /* renamed from: O00000Oo */
                public void onSuccess(BusinessResponse businessResponse, Map<String, String> map, String str) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : map.entrySet()) {
                        hashMap.put(next.getKey(), JSON.parseArray((String) next.getValue(), MeshRelationBean.class));
                    }
                    OooOO.O000000o().O000000o(str, (Map<String, List<MeshRelationBean>>) hashMap);
                    OooOO.O000000o().O000000o(str);
                }
            });
        }
    }

    private void O00000oO() {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O000000o(this.O0000Oo);
        }
    }

    private void O00000oo() {
        o0o00o0oo0 o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class);
        if (o0o00o0oo0 != null) {
            o0o00o0oo0.O000000o().O00000Oo(this.O0000Oo);
        }
    }

    public void O000000o(String str) {
        O000000o(str, false);
    }

    public void O000000o(String str, boolean z) {
        Class cls = o0o00o0o0o.class;
        if (this.O00000o0.isEmpty()) {
            O00Oo00.O000000o(TuyaSdk.getApplication(), z);
            O00000o0();
            O00000oO();
            ((o0o00o0o0o) Oo0.O000000o(cls)).O000000o().unRegisterTuyaHomeChangeListener(this.O00000Oo);
            ((o0o00o0o0o) Oo0.O000000o(cls)).O000000o().registerTuyaHomeChangeListener(this.O00000Oo);
        }
        this.O00000o0.add(str);
        O00000o0(str);
    }

    public synchronized void O00000Oo() {
        O00000o();
        O00000oo();
        ((o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class)).O000000o().unRegisterTuyaHomeChangeListener(this.O00000Oo);
    }

    public synchronized void O00000Oo(String str) {
        this.O00000o0.remove(str);
        if (this.O00000o0.isEmpty()) {
            O00000Oo();
        }
    }
}
