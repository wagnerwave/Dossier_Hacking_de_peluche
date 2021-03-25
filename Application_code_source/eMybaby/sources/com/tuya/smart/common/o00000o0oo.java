package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.ModelBindBean;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.Element;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class o00000o0oo {
    public static final String O000000o = "ConfigModelBindState";
    public static final int O00000o0 = 80;
    public static final long O0000OOo = 3000;
    public SigMeshSearchDeviceBean O00000Oo;
    public o0000o0o0o O00000o;
    public o000oo0000 O00000oO;
    public List<ModelBindBean> O00000oo;
    public List<ModelBindBean> O0000O0o;
    public Handler O0000Oo;
    public int O0000Oo0 = 2;
    public Handler.Callback O0000OoO = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 80) {
                return false;
            }
            StringBuilder n = a.n(" ");
            n.append(o00000o0oo.this.O0000Oo0);
            o00oo0oo00.O00000Oo(o00000o0oo.O000000o, n.toString());
            if (o00000o0oo.this.O0000Oo0 > 0) {
                o00000o0oo.O00000Oo(o00000o0oo.this);
                o00000o0oo.this.O0000Oo.sendEmptyMessageDelayed(80, 3000);
                o00000o0oo o00000o0oo = o00000o0oo.this;
                o00000o0oo.O000000o((Iterator<ModelBindBean>) o00000o0oo.O00000oo.iterator());
                return false;
            } else if (o00000o0oo.this.O00000o == null) {
                return false;
            } else {
                o00000o0oo.this.O00000o.O000000o(o00000o0oo.this.O00000Oo, O00OOo.O000OO0o, "bind model timeout");
                return false;
            }
        }
    };
    public ooooo000o O0000Ooo = new ooooo000o() {
        public void O000000o(com.tuya.sdk.sigmesh.bean.Message message) {
            if (message instanceof AccessMessage) {
                AccessMessage accessMessage = (AccessMessage) message;
                if (((accessMessage.getAccessPdu()[0] & 240) >> 6) == 2 && message.getOpCode() == 32830) {
                    o00000o0o0 o00000o0o0 = new o00000o0o0(accessMessage);
                    if (o00000o0o0.O00000oo()) {
                        StringBuilder n = a.n("app bind success ");
                        n.append(o00000o0o0.O00000oO());
                        n.append("  address:");
                        n.append(o00000o0o0.h_());
                        o00oo0oo00.O00000Oo(o00000o0oo.O000000o, n.toString());
                        o00000o0oo.this.O0000O0o.add(new ModelBindBean(o00000o0o0.h_(), o00000o0o0.O00000oO(), (o000o0oooo) null));
                        o00000o0oo.this.O00000Oo();
                        return;
                    }
                    StringBuilder n2 = a.n("app bind fail ");
                    n2.append(o00000o0o0.O00000oO());
                    n2.append("  address:");
                    n2.append(o00000o0o0.h_());
                    o00oo0oo00.O00000Oo(o00000o0oo.O000000o, n2.toString());
                }
            }
        }
    };

    public o00000o0oo(o0000o0o0o o0000o0o0o, o000oo0000 o000oo0000) {
        this.O00000o = o0000o0o0o;
        this.O00000oO = o000oo0000;
        this.O00000oo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000Oo = new Handler(Looper.getMainLooper(), this.O0000OoO);
    }

    /* access modifiers changed from: private */
    public void O000000o(final Iterator<ModelBindBean> it) {
        if (it.hasNext()) {
            final ModelBindBean next = it.next();
            ProvisionedMeshNode provisionedMeshNode = this.O00000Oo.getProvisionedMeshNode();
            new oo0oo0ooo(this.O00000Oo.getMacAdress(), o000oo0o0o.O000000o(next.getMeshAddress()), next.getModelId(), 0, new o00o0o0o0o.O000000o() {
                public void O000000o(String str, String str2) {
                    o00000o0oo.this.O0000Oo.removeMessages(80);
                    if (o00000o0oo.this.O00000o != null) {
                        StringBuilder q = a.q("bindModel send error ", str2, "   meshAddress:");
                        q.append(next.getMeshAddress());
                        q.append("  modelId:");
                        q.append(next.getModelId());
                        o00oo0oo00.O00000Oo(o00000o0oo.O000000o, q.toString());
                        o0000o0o0o O00000oO = o00000o0oo.this.O00000o;
                        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = o00000o0oo.this.O00000Oo;
                        O00000oO.O000000o(sigMeshSearchDeviceBean, O00OOo.O000OO0o, "bind model fail " + str2);
                    }
                }

                public void O00000Oo() {
                    o00000o0oo.this.O000000o((Iterator<ModelBindBean>) it);
                }
            }, this.O00000oO).O000000o(oo0o0oooo.O000000o().O00000o0(), provisionedMeshNode.getUnicastAddress(), provisionedMeshNode.getDeviceKey());
        }
    }

    private void O000000o(Map<Integer, Element> map) {
        HashMap hashMap = new HashMap();
        this.O00000oo.clear();
        if (map != null && !map.isEmpty()) {
            hashMap.put(4096, (Object) null);
            hashMap.put(4864, (Object) null);
            hashMap.put(4870, (Object) null);
            hashMap.put(4871, (Object) null);
            hashMap.put(4867, (Object) null);
            hashMap.put(Integer.valueOf(oooooo000.O0000Oo0), (Object) null);
            for (Map.Entry next : map.entrySet()) {
                Element element = (Element) next.getValue();
                if (element != null) {
                    for (Map.Entry next2 : element.getMeshModels().entrySet()) {
                        if (hashMap.containsKey(next2.getKey())) {
                            this.O00000oo.add(new ModelBindBean(((Integer) next.getKey()).intValue(), ((Integer) next2.getKey()).intValue(), (o000o0oooo) next2.getValue()));
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ int O00000Oo(o00000o0oo o00000o0oo) {
        int i = o00000o0oo.O0000Oo0;
        o00000o0oo.O0000Oo0 = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        for (ModelBindBean next : this.O00000oo) {
            boolean z = false;
            Iterator<ModelBindBean> it = this.O0000O0o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ModelBindBean next2 = it.next();
                if (next.getModelId() == next2.getModelId() && next.getMeshAddress() == next2.getMeshAddress()) {
                    z = true;
                    continue;
                    break;
                }
            }
            if (!z) {
                return;
            }
        }
        this.O0000Oo.removeMessages(80);
        o0000o0o0o o0000o0o0o = this.O00000o;
        if (o0000o0o0o != null) {
            o0000o0o0o.O000000o(this.O00000Oo);
            this.O0000O0o.clear();
        }
    }

    public ooooo000o O000000o() {
        return this.O0000Ooo;
    }

    public void O000000o(SigMeshSearchDeviceBean sigMeshSearchDeviceBean) {
        this.O0000O0o.clear();
        this.O0000Oo0 = 3;
        this.O00000Oo = sigMeshSearchDeviceBean;
        O000000o(sigMeshSearchDeviceBean.getElement());
        if (this.O00000oo.isEmpty()) {
            this.O00000o.O000000o(sigMeshSearchDeviceBean);
            return;
        }
        this.O0000Oo.sendEmptyMessageDelayed(80, 3000);
        O000000o(this.O00000oo.iterator());
    }
}
