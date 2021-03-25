package com.tuya.smart.common;

import a.e.a.a.r.a;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.List;

public class ooooo0o00 {
    public static final ooooo0o00 O000000o = new ooooo0o00();
    public static final String O00000Oo = "TuyaSigMeshLocalOnlineManager";
    public static final int O00000oO = 35000;
    public static final int O00000oo = 10000;
    public static final int O0000O0o = 65535;
    public Handler O00000o = new Handler(this.O00000o0.getLooper()) {
        public void handleMessage(Message message) {
            String string = message.getData().getString("meshId");
            String string2 = message.getData().getString("nodeId");
            String string3 = message.getData().getString("type");
            ProvisionedMeshNode provisionedMeshNode = null;
            if (TextUtils.equals(string3, "warn")) {
                L.d(ooooo0o00.O00000Oo, "send warn massage " + string2);
                DeviceBean subDeviceBeanByNodeId = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getSubDeviceBeanByNodeId(string, string2);
                TuyaSigMeshBean O00000o = O0O0o00.O000000o().O00000o(string);
                if (O00000o != null) {
                    provisionedMeshNode = O00000o.getProvisionedMeshNode();
                }
                if (!(subDeviceBeanByNodeId == null || provisionedMeshNode == null)) {
                    oo0ooooo0 oo0ooooo0 = new oo0ooooo0();
                    byte[] O000000o2 = o000oo0o0o.O000000o(a.c(string2));
                    byte[] O00000o0 = oo0o0oooo.O000000o().O00000o0();
                    oo0ooooo0.O000000o(provisionedMeshNode.getNodeMac(), O00000o.getMeshkey(), oo0o0oooo.O000000o().O0000OoO(), O00000o0, O000000o2, (o00o0o0o0o.O000000o) null);
                }
                ooooo0o00.this.O00000o.removeMessages(ooooo0o00.this.O000000o(string2));
                ooooo0o00.this.O00000o.sendMessageDelayed(ooooo0o00.this.O00000Oo(string, string2), 10000);
            } else if (TextUtils.equals(string3, "offline")) {
                StringBuilder q = a.a.a.a.a.q("device timeout nodeId:", string2, "  what:");
                q.append(ooooo0o00.this.O000000o(string2));
                L.e(ooooo0o00.O00000Oo, q.toString());
                ooooo0o00.this.O000000o(string, string2, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(string2);
                O0000o.O000000o(string, (List<String>) null, arrayList);
                ooooo0o00.this.O00000o.removeMessages(message.what);
            }
        }
    };
    public HandlerThread O00000o0;

    public ooooo0o00() {
        HandlerThread handlerThread = new HandlerThread("sigmesh-handler-thread");
        this.O00000o0 = handlerThread;
        handlerThread.start();
    }

    /* access modifiers changed from: private */
    public int O000000o(String str) {
        int i;
        try {
            i = Integer.parseInt(str, 16);
        } catch (Exception unused) {
            L.e(O00000Oo, "nodeId :" + str + "  not hex");
            i = 0;
        }
        return i + 65535;
    }

    private Message O000000o(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.getData().putString("meshId", str);
        obtain.getData().putString("nodeId", str2);
        obtain.getData().putString("type", "warn");
        obtain.what = O000000o(str2);
        StringBuilder q = a.a.a.a.a.q("createWarnMessage  nodeId:", str2, DpTimerBean.FILL);
        q.append(obtain.what);
        L.e(O00000Oo, q.toString());
        return obtain;
    }

    public static ooooo0o00 O000000o() {
        return O000000o;
    }

    /* access modifiers changed from: private */
    public Message O00000Oo(String str, String str2) {
        Message obtain = Message.obtain();
        obtain.getData().putString("meshId", str);
        obtain.getData().putString("nodeId", str2);
        obtain.getData().putString("type", "offline");
        obtain.what = O000000o(str2);
        StringBuilder q = a.a.a.a.a.q("createOfflineMessage  nodeId:", str2, DpTimerBean.FILL);
        q.append(obtain.what);
        L.e(O00000Oo, q.toString());
        return obtain;
    }

    public void O000000o(String str, String str2, boolean z) {
        if (z) {
            O0O0o00.O000000o().O000000o(str, str2);
            L.e(O00000Oo, "remove what " + O000000o(str2));
            this.O00000o.removeMessages(O000000o(str2));
            this.O00000o.sendMessageDelayed(O000000o(str, str2), 35000);
            return;
        }
        O0O0o00.O000000o().O00000Oo(str, str2);
        this.O00000o.removeMessages(O000000o(str2));
    }
}
