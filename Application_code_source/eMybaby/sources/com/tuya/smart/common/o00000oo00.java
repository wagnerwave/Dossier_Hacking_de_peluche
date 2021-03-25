package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class o00000oo00 {
    public static final int O00000Oo = 81;
    public static final String O00000o0 = "ConfigModelPublicationState";
    public static final long O0000OOo = 3000;
    public SigMeshSearchDeviceBean O000000o;
    public o0000o0oo0 O00000o;
    public o000oo0000 O00000oO;
    public Handler O00000oo;
    public int O0000O0o = 2;
    public List<Integer> O0000Oo;
    public List<Integer> O0000Oo0;
    public ooooo000o O0000OoO = new ooooo000o() {
        public void O000000o(Message message) {
            if (message instanceof AccessMessage) {
                AccessMessage accessMessage = (AccessMessage) message;
                if (((accessMessage.getAccessPdu()[0] & 240) >> 6) == 2 && message.getOpCode() == 32793) {
                    o00000oo0o o00000oo0o = new o00000oo0o(accessMessage);
                    if (o00000oo0o.O00000oO()) {
                        StringBuilder n = a.n("sendModelPublication success  modelId:");
                        n.append(o00000oo0o.O0000o00());
                        o00oo0oo00.O000000o(o00000oo00.O00000o0, n.toString());
                        o00000oo00.this.O0000Oo.add(Integer.valueOf(o00000oo0o.O0000o00()));
                        o00000oo00.this.O00000Oo();
                        return;
                    }
                    StringBuilder n2 = a.n("publication model fail ");
                    n2.append(o00000oo0o.O0000o00());
                    o00oo0oo00.O00000Oo(o00000oo00.O00000o0, n2.toString());
                }
            }
        }
    };
    public Handler.Callback O0000Ooo = new Handler.Callback() {
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 81) {
                return false;
            }
            StringBuilder n = a.n(" ");
            n.append(o00000oo00.this.O0000O0o);
            o00oo0oo00.O00000Oo(o00000oo00.O00000o0, n.toString());
            if (o00000oo00.this.O0000O0o > 0) {
                o00000oo00.O00000o(o00000oo00.this);
                o00000oo00.this.O00000oo.sendEmptyMessageDelayed(81, 3000);
                o00000oo00 o00000oo00 = o00000oo00.this;
                o00000oo00.O000000o((Iterator<Integer>) o00000oo00.O0000Oo0.iterator());
                return false;
            } else if (o00000oo00.this.O00000o == null) {
                return false;
            } else {
                o00000oo00.this.O00000o.O000000o(o00000oo00.this.O000000o, O00OOo.O000OOOo, "sendModelPublication timeout ");
                return false;
            }
        }
    };

    public o00000oo00(o0000o0oo0 o0000o0oo0, o000oo0000 o000oo0000) {
        this.O00000o = o0000o0oo0;
        this.O00000oO = o000oo0000;
        this.O00000oo = new Handler(Looper.getMainLooper(), this.O0000Ooo);
        this.O0000Oo = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.O0000Oo0 = arrayList;
        arrayList.add(4096);
    }

    /* access modifiers changed from: private */
    public void O000000o(Iterator<Integer> it) {
        int i;
        int i2;
        if (it.hasNext()) {
            final int intValue = it.next().intValue();
            ProvisionedMeshNode provisionedMeshNode = this.O000000o.getProvisionedMeshNode();
            byte[] unicastAddress = provisionedMeshNode.getUnicastAddress();
            byte[] O000000o2 = o000oo0o0o.O000000o(53248);
            if (intValue == 4096) {
                i2 = 30;
                i = 1;
            } else {
                i2 = 3;
                i = 3;
            }
            final Iterator<Integer> it2 = it;
            new oo0ooo000(unicastAddress, O000000o2, 0, false, 3, i2, i, 5, 4, intValue).O000000o(this.O000000o.getMacAdress(), this.O00000oO, oo0o0oooo.O000000o().O00000o0(), provisionedMeshNode.getUnicastAddress(), provisionedMeshNode.getDeviceKey(), new o00o0o0o0o.O000000o() {
                public void O000000o(String str, String str2) {
                    StringBuilder n = a.n("sendModelPublication fail modelId:");
                    n.append(intValue);
                    o00oo0oo00.O000000o(o00000oo00.O00000o0, n.toString());
                    o00000oo00.this.O00000oo.removeMessages(81);
                    if (o00000oo00.this.O00000o != null) {
                        o0000o0oo0 O0000O0o = o00000oo00.this.O00000o;
                        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = o00000oo00.this.O000000o;
                        O0000O0o.O000000o(sigMeshSearchDeviceBean, O00OOo.O000OOOo, "sendModelPublication fail " + str2);
                    }
                }

                public void O00000Oo() {
                    o00000oo00.this.O000000o((Iterator<Integer>) it2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        if (Arrays.equals(this.O0000Oo.toArray(), this.O0000Oo0.toArray())) {
            this.O00000oo.removeMessages(81);
            o0000o0oo0 o0000o0oo0 = this.O00000o;
            if (o0000o0oo0 != null) {
                o0000o0oo0.O000000o(this.O000000o);
                this.O0000Oo.clear();
            }
        }
    }

    public static /* synthetic */ int O00000o(o00000oo00 o00000oo00) {
        int i = o00000oo00.O0000O0o;
        o00000oo00.O0000O0o = i - 1;
        return i;
    }

    public ooooo000o O000000o() {
        return this.O0000OoO;
    }

    public void O000000o(SigMeshSearchDeviceBean sigMeshSearchDeviceBean) {
        this.O000000o = sigMeshSearchDeviceBean;
        this.O0000Oo.clear();
        this.O0000O0o = 3;
        this.O00000oo.sendEmptyMessageDelayed(81, 3000);
        O000000o(this.O0000Oo0.iterator());
    }
}
