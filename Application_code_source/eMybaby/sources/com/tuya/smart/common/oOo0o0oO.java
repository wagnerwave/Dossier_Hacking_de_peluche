package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.smart.android.base.event.NetWorkStatusEvent;
import com.tuya.smart.android.base.event.NetWorkStatusEventModel;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.NetworkUtil;
import com.tuya.smart.android.common.utils.TuyaConcurrentList;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.common.ooOOOOoo;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.enums.ActiveEnum;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaSearchDeviceListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import com.tuya.smart.sdk.enums.DeviceActiveEnum;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class oOo0o0oO implements Handler.Callback, NetWorkStatusEvent, o0oo00o0oo, o0oo00oo00, o0oo00oo0o, o0oo00ooo0, ooOOOOoo.O000000o {
    public static final String O000000o = "TuyaSmartHardwareManager";
    public static final int O00000Oo = 1;
    public CopyOnWriteArrayList<O000000o> O00000o = new CopyOnWriteArrayList<>();
    public o0oo0o000o O00000o0;
    public o000 O00000oO = new o000();
    public TuyaConcurrentList<ITuyaSearchDeviceListener> O00000oo = new TuyaConcurrentList<>();
    public TuyaConcurrentList<o0o0o0o0o0> O0000O0o = new TuyaConcurrentList<>();
    public volatile boolean O0000OOo = false;
    public ooOOOOoo O0000Oo;
    public Handler O0000Oo0 = new Handler(Looper.getMainLooper(), this);

    public static class O000000o {
        public int O000000o;
        public o0o00ooooo O00000Oo;

        public O000000o(int i, o0o00ooooo o0o00ooooo) {
            this.O000000o = i;
            this.O00000Oo = o0o00ooooo;
        }

        public int O000000o() {
            return this.O000000o;
        }

        public o0o00ooooo O00000Oo() {
            return this.O00000Oo;
        }
    }

    public static void O000000o(oO0000o0 oo0000o0) {
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            List<HgwBean> O00000o2 = o0o00o0o00.O000000o().O00000o();
            if (oo0000o0 != null) {
                oo0000o0.O000000o(O00000o2);
            }
        }
    }

    public static void O000000o(String str) {
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            o0o00o0o00.O000000o().O000000o(str);
        }
    }

    public static void O000000o(String str, oO0000Oo oo0000oo) {
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            HgwBean O00000Oo2 = o0o00o0o00.O000000o().O00000Oo(str);
            if (oo0000oo != null) {
                oo0000oo.O000000o(O00000Oo2);
            }
        }
    }

    public static void O000000o(String str, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null || (!dev.isZigBeeWifi() && !dev.is433Wifi())) {
            O000000o(str, "", iResultCallback);
            return;
        }
        for (DeviceBean nodeId : oOo0oooO.O000000o().O00000Oo(str)) {
            O000000o(str, nodeId.getNodeId(), (IResultCallback) null);
        }
    }

    public static void O000000o(String str, String str2, IResultCallback iResultCallback) {
        oO0O0o0o.O000000o(str, str2, iResultCallback);
    }

    private void O00000Oo(List<HgwBean> list) {
        for (final HgwBean next : list) {
            this.O00000oo.query(new TuyaConcurrentList.QueryListCallback<ITuyaSearchDeviceListener>() {
                /* renamed from: O000000o */
                public void query(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
                    iTuyaSearchDeviceListener.onDeviceFind(next.getGwId(), DeviceActiveEnum.to(next.getActive()));
                }
            });
        }
    }

    private void O00000oO() {
        if (!this.O0000OOo || !this.O0000Oo.O000000o()) {
            L.d(O000000o, "service is not start or the application is background");
        } else {
            L.d(O000000o, "checkService");
            if (((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class)) != null) {
                this.O00000o0.O000000o((Context) TuyaSdk.getApplication());
            } else {
                return;
            }
        }
        this.O0000Oo0.sendEmptyMessageDelayed(1, 5000);
    }

    public void O000000o() {
        this.O0000Oo0.removeMessages(1);
        O00000oO();
    }

    public void O000000o(int i, o0o00ooooo o0o00ooooo) {
        this.O00000o.add(new O000000o(i, o0o00ooooo));
    }

    public void O000000o(final HgwBean hgwBean, final boolean z) {
        Class cls = o0o00o0o00.class;
        o0O0O00O.O000000o(hgwBean, z);
        this.O0000O0o.query(new TuyaConcurrentList.QueryListCallback<o0o0o0o0o0>() {
            /* renamed from: O000000o */
            public void query(o0o0o0o0o0 o0o0o0o0o0) {
                o0o0o0o0o0.O000000o(hgwBean, z);
            }
        });
        L.d(O000000o, "online: " + z + "; devId: " + hgwBean.getGwId());
        DeviceBean dev = oOo0oooO.O000000o().getDev(hgwBean.getGwId());
        if (z) {
            if (dev != null && ActiveEnum.ACTIVED.getType() == hgwBean.getActive()) {
                L.d(O000000o, "add new gw");
                o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(cls);
                if (o0o00o0o00 != null) {
                    o0o00o0o00.O000000o().O000000o(hgwBean.getGwId(), hgwBean);
                }
                O000000o(hgwBean.getGwId(), (IResultCallback) null);
                if (!TuyaUtil.hasLatOrLon(dev.getLat(), dev.getLon()) && TuyaUtil.hasLatOrLon(TuyaSdk.getLatitude(), TuyaSdk.getLongitude())) {
                    this.O00000oO.O000000o(dev.getDevId());
                }
            } else {
                return;
            }
        } else if (dev != null) {
            L.d(O000000o, "remove gw");
            o0o00o0o00 o0o00o0o002 = (o0o00o0o00) Oo0.O000000o(cls);
            if (o0o00o0o002 != null) {
                o0o00o0o002.O000000o().O00000o0(hgwBean.getGwId());
            }
        } else {
            return;
        }
        oO0O0Oo0.O000000o(dev.getDevId());
    }

    public void O000000o(o0o00ooooo o0o00ooooo) {
        Iterator<O000000o> it = this.O00000o.iterator();
        while (it.hasNext()) {
            O000000o next = it.next();
            if (next.O00000Oo == o0o00ooooo) {
                this.O00000o.remove(next);
                return;
            }
        }
    }

    public void O000000o(o0o0o0o0o0 o0o0o0o0o0) {
        this.O0000O0o.add(o0o0o0o0o0);
    }

    public void O000000o(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        this.O00000oo.add(iTuyaSearchDeviceListener);
    }

    public void O000000o(String str, int i, boolean z, byte[] bArr) {
        final int i2 = i;
        final String str2 = str;
        final boolean z2 = z;
        final byte[] bArr2 = bArr;
        this.O0000Oo0.post(new Runnable() {
            public void run() {
                L.d(oOo0o0oO.O000000o, Thread.currentThread().getName());
                Iterator it = oOo0o0oO.this.O00000o.iterator();
                while (it.hasNext()) {
                    O000000o o000000o = (O000000o) it.next();
                    if (o000000o.O000000o() == i2) {
                        o000000o.O00000Oo().O000000o(str2, i2, z2, bArr2);
                    }
                }
            }
        });
    }

    public void O000000o(String str, String str2) {
        oO0O0Oo0.O000000o(str, str, str2, false);
    }

    public void O000000o(String str, String str2, int i, String str3) {
        L.d(O000000o, "onLocalDpSubDeviceReceivedSuccess devId: " + str + " cid: " + str2 + " ctype: " + i + " dps: " + str3);
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str3, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        DeviceRespBean O000000o2 = oO00O0o0.O000000o().O000000o(str, str2);
        String devId = O000000o2.getDevId();
        if (oOO0OO0O.O00000o0(devId, linkedHashMap)) {
            str3 = JSON.toJSONString(linkedHashMap);
        }
        String str4 = str3;
        if (!oOO0OO0O.O00000Oo(devId, (Map<String, Object>) linkedHashMap)) {
            L.d(O000000o, "checkReceiveCommond error");
            return;
        }
        oO00O0o0.O000000o().O000000o(O000000o2, (Map<String, Object>) linkedHashMap);
        o0O0O00O.O000000o(str, str2, devId, i, str4, false);
    }

    public void O000000o(String str, String str2, String str3) {
        L.e(O000000o, "local control devId:" + str + " errorCode: " + str2 + " errorMsg:" + str3);
    }

    public void O000000o(List<HgwBean> list) {
        if (this.O00000o0 != null && list != null) {
            for (HgwBean next : list) {
                if (next != null && next.getActive() == ActiveEnum.ACTIVED.getType() && oO00O0o0.O000000o().O000000o(next)) {
                    L.d(O000000o, next.toString());
                    this.O00000o0.O000000o(next);
                }
            }
            O00000Oo(list);
        }
    }

    public boolean O000000o(String str, int i) {
        return oOo0000O.O000000o().O000000o(str, i);
    }

    public boolean O000000o(String str, int i, int i2) {
        return oOo0000O.O000000o().O000000o(str, i, i2);
    }

    public String O00000Oo(String str) {
        DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(str);
        if (O00000Oo2 != null) {
            return O00000Oo2.getLocalKey();
        }
        return null;
    }

    public void O00000Oo() {
        o0o00oo0oo o0o00oo0oo = (o0o00oo0oo) Oo0.O000000o(o0o00oo0oo.class);
        if (o0o00oo0oo == null || !o0o00oo0oo.O000000o().isLogin()) {
            L.d(O000000o, "startConnectTransferServer failure with in not login status");
            return;
        }
        StringBuilder n = a.n("startConnectTransferServer");
        n.append(this.O0000OOo);
        L.d(O000000o, n.toString());
        if (!this.O0000OOo) {
            this.O0000OOo = true;
            o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
            if (o0o00o0o00 != null) {
                o0oo0o000o O000000o2 = o0o00o0o00.O000000o();
                this.O00000o0 = O000000o2;
                O000000o2.O000000o((o0oo00oo00) this);
                this.O00000o0.O000000o((o0oo00o0oo) this);
                this.O00000o0.O000000o((o0oo00oo0o) this);
                this.O00000o0.O000000o((o0oo00ooo0) this);
                TuyaSdk.getEventBus().register(this);
                this.O0000Oo = new ooOOOOoo(TuyaSdk.getApplication(), this);
                O00000oO();
            }
        }
    }

    public void O00000Oo(o0o0o0o0o0 o0o0o0o0o0) {
        this.O0000O0o.remove(o0o0o0o0o0);
    }

    public void O00000Oo(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        this.O00000oo.remove(iTuyaSearchDeviceListener);
    }

    public void O00000Oo(String str, String str2) {
        ProductBean.SchemaInfo schemaInfo;
        long j = 0;
        for (GroupBean next : o0O000Oo.O000000o().O00000Oo()) {
            if (TextUtils.equals(next.getLocalId(), str)) {
                j = next.getId();
            }
        }
        boolean z = false;
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str2, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        GroupRespBean O00000o02 = o0O000Oo.O000000o().O00000o0(j);
        if (O00000o02 != null) {
            String productId = O00000o02.getProductId();
            ProductBean O000000o2 = oO0O00Oo.O000000o().O000000o(productId);
            if (!(O000000o2 == null || (schemaInfo = O000000o2.getSchemaInfo()) == null)) {
                z = oOO0OO0O.O00000Oo(O00000o02.getDps(), schemaInfo.getSchemaMap());
            }
            if (!oOO0OO0O.O000000o(productId, (LinkedHashMap<String, Object>) linkedHashMap)) {
                L.d(O000000o, "checkReceiveCommond error");
                return;
            }
            Map<String, Object> O000000o3 = oO0O0Oo0.O000000o(O00000o02, (Map<String, Object>) linkedHashMap);
            if (O000000o3 != null && O000000o3.size() > 0) {
                if (z) {
                    str2 = JSON.toJSONString(O000000o3);
                }
                o0oOo0O0.O000000o(j, str2);
            }
        }
    }

    public void O00000o() {
        O00000o0();
        this.O00000oo.clear();
        this.O0000O0o.clear();
        this.O00000oO.onDestroy();
        if (!this.O00000o.isEmpty()) {
            this.O00000o.clear();
        }
    }

    public String O00000o0(String str) {
        HgwBean hgwBean;
        DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(str);
        if (O00000Oo2 == null || (hgwBean = O00000Oo2.getHgwBean()) == null) {
            return null;
        }
        return hgwBean.getVersion();
    }

    public void O00000o0() {
        StringBuilder n = a.n("stopDeviceTranferService");
        n.append(this.O0000OOo);
        L.d(O000000o, n.toString());
        if (this.O0000OOo && ((o0o00o0o00) Oo0.O000000o(o0o00o0o00.class)) != null) {
            this.O00000o0.O00000Oo((Context) TuyaSdk.getApplication());
            TuyaSdk.getEventBus().unregister(this);
            this.O0000OOo = false;
            this.O0000Oo0.removeMessages(1);
            ooOOOOoo oooooooo = this.O0000Oo;
            if (oooooooo != null) {
                oooooooo.O00000Oo();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        L.d(O000000o, "check service status");
        O00000oO();
        return false;
    }

    public void onEvent(NetWorkStatusEventModel netWorkStatusEventModel) {
        if (!netWorkStatusEventModel.isAvailable() && !NetworkUtil.isWifiConnected(TuyaSdk.getApplication())) {
            for (DeviceBean devId : oOo0oooO.O000000o().getDevList()) {
                O000000o(devId.getDevId());
            }
        }
    }
}
