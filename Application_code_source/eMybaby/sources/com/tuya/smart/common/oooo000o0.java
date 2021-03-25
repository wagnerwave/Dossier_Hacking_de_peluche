package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.sigmesh.bean.ProvisioningCapabilities;
import com.tuya.sdk.sigmesh.bean.UnprovisionedBeacon;
import com.tuya.sdk.sigmesh.bean.UnprovisionedMeshNode;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class oooo000o0 implements O00Oo0, oooo0000o {
    public static final String O000000o = "TuyaBlueMeshLocalActivator";
    public static final int O0000oo0 = 136;
    public oooo00o00 O00000Oo;
    public SigMeshSearchDeviceBean O00000o;
    public O00Oo00o O00000o0;
    public oooo000oo O00000oO;
    public O0O00o0 O00000oo;
    public oooo0o0o0 O0000O0o;
    public o000o000oo O0000OOo;
    public o000o000o0 O0000Oo;
    public o000o00o00 O0000Oo0;
    public o000o00o0o O0000OoO;
    public o000o00oo0 O0000Ooo;
    public o00000oooo O0000o;
    public o000000oo0 O0000o0;
    public o00000o00o O0000o00;
    public o00000o0oo O0000o0O;
    public o00000oo00 O0000o0o;
    public Handler.Callback O0000oO = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 136) {
                return false;
            }
            StringBuilder n = a.n("WHAT_TIME_OUT ");
            n.append(oooo000o0.this.O0000oo);
            o00oo0oo00.O000000o("TuyaBlueMeshLocalActivator", n.toString());
            O00Oo00o o00Oo00o = oooo000o0.this.O00000o0;
            if (o00Oo00o != null) {
                o00Oo00o.O000000o((SearchDeviceBean) null, O00OOo.O0000Ooo, "time out");
                oooo000o0.this.O00000o0.O000000o();
            }
            oooo000o0.this.O000000o();
            return false;
        }
    };
    public boolean O0000oO0;
    public long O0000oOO;
    public long O0000oOo;
    public int O0000oo;
    public List<SearchDeviceBean> O0000ooO;
    public String O0000ooo;
    public String[] O00oOooO;
    public Handler O00oOooo = new Handler(Looper.getMainLooper(), this.O0000oO);

    public oooo000o0(oooo00o00 oooo00o00) {
        this.O00000Oo = oooo00o00;
        this.O0000ooO = oooo00o00.O000000o();
        this.O0000ooo = oooo00o00.O00000o();
        this.O00oOooO = oooo00o00.O00000oO();
        this.O00000o0 = oooo00o00.O00000Oo();
        O0000oO0();
        this.O0000oo = oooo00o00.O00000o0();
        this.O0000O0o = new oooo0o0o0(this.O00000oO.O000000o());
        this.O0000OOo = new o000o000oo(this.O00000oO.O00000Oo());
        this.O0000Oo0 = new o000o00o00(this.O00000oO.O00000o0());
        this.O0000Oo = new o000o000o0(this.O00000oO.O00000o());
        this.O0000OoO = new o000o00o0o(this.O00000oO.O00000oO());
        this.O0000Ooo = new o000o00oo0(this.O00000oO.O00000oo());
        this.O0000o00 = new o00000o00o(this.O00000oO.O0000O0o(), this.O00000oO.O0000Ooo());
        this.O0000o0 = new o000000oo0(this.O00000oO.O0000OOo(), this.O00000oO.O0000Ooo());
        this.O0000o0O = new o00000o0oo(this.O00000oO.O0000Oo0(), this.O00000oO.O0000Ooo());
        this.O0000o0o = new o00000oo00(this.O00000oO.O0000Oo(), this.O00000oO.O0000Ooo());
        this.O0000o = new o00000oooo(this.O00000oO.O0000OoO(), this.O00000oO.O0000Ooo());
        this.O00000oO.O000000o(this.O0000OOo.O000000o());
        this.O00000oO.O000000o(this.O0000Oo0.O000000o());
        this.O00000oO.O000000o(this.O0000Oo.O000000o());
        this.O00000oO.O000000o(this.O0000OoO.O000000o());
        this.O00000oO.O000000o(this.O0000Ooo.O000000o());
        this.O00000oO.O000000o(this.O0000o00.O000000o());
        this.O00000oO.O000000o(this.O0000o0.O000000o());
        this.O00000oO.O000000o(this.O0000o0O.O000000o());
        this.O00000oO.O000000o(this.O0000o0o.O000000o());
        this.O00000oO.O000000o(this.O0000o.O000000o());
    }

    private UnprovisionedMeshNode O0000oOO() {
        UUID uuid;
        if (this.O00000o.getMeshBeacon() != null) {
            uuid = ((UnprovisionedBeacon) this.O00000o.getMeshBeacon()).getUuid();
        } else {
            byte[] O000000o2 = o00o0000oo.O000000o(this.O00000o.getScanRecordBean(), o00o00o000.O00000oO);
            uuid = O000000o2 != null ? o00o0000oo.O00000oO(O000000o2) : null;
        }
        if (uuid == null) {
            return null;
        }
        return o00o0000oo.O000000o(uuid, this.O00000o.getMeshName(), this.O0000ooo);
    }

    public void O000000o() {
        this.O0000oO0 = true;
        this.O0000O0o.O00000o();
        this.O00000o0 = null;
        this.O00000oO.O0000o00();
        this.O00oOooo.removeMessages(136);
    }

    public void O000000o(ControlMessage controlMessage) {
        ooo0o0o00 ooo0o0o00 = new ooo0o0o00(this.O00000o.getMacAdress(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
            }

            public void O00000Oo() {
            }
        }, this.O00000oO.O0000Ooo());
        ooo0o0o00.O000000o((com.tuya.sdk.sigmesh.bean.Message) controlMessage);
        ooo0o0o00.O0000o();
    }

    public void O000000o(ProvisioningCapabilities provisioningCapabilities) {
        this.O0000Oo0.O000000o((SearchDeviceBean) this.O00000o, provisioningCapabilities);
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O0000O0o.O000000o(this.O00000oO.O000000o());
        this.O0000O0o.O000000o(searchDeviceBean);
    }

    public void O000000o(final SearchDeviceBean searchDeviceBean, O00Ooo00.O000000o o000000o) {
        if (!TextUtils.equals(searchDeviceBean.getMacAdress(), this.O00000o.getMacAdress())) {
            StringBuilder n = a.n("doCustomCodeForFinale mac not equals currentConfigBean ");
            n.append(searchDeviceBean.getMacAdress());
            n.append(DpTimerBean.FILL);
            n.append(this.O00000o.getMacAdress());
            o00oo0oo00.O00000Oo("TuyaBlueMeshLocalActivator", n.toString());
            this.O00000oO.O000000o(searchDeviceBean, O00OOo.O0000OoO, "config mac not equal current mac ");
            return;
        }
        this.O00000oo.O000000o(searchDeviceBean, o000000o, "", new O0O000o() {
            public void O000000o() {
                oooo000o0.this.O00000oO.O000000o(searchDeviceBean);
            }

            public void O000000o(String str, String str2) {
                oooo000o0.this.O00000oO.O000000o(searchDeviceBean, str, str2);
            }
        });
    }

    public void O000000o(O0O00o0 o0O00o0) {
        this.O00000oo = o0O00o0;
        O0000oO();
        this.O0000oOO = System.currentTimeMillis();
        O0000o0O();
    }

    public void O000000o(String str, String str2) {
        this.O00000oO.O000000o(this.O00000o, str, str2);
    }

    public void O00000Oo() {
        this.O0000OOo.O000000o((SearchDeviceBean) this.O00000o);
    }

    public void O00000o() {
        this.O0000OoO.O000000o((SearchDeviceBean) this.O00000o);
    }

    public void O00000o0() {
        this.O0000Oo.O000000o((SearchDeviceBean) this.O00000o);
    }

    public void O00000oO() {
        this.O00000oo.O000000o(this.O00000o, new O0O00oO() {
            public void O000000o(int i) {
                oooo000o0 oooo000o0 = oooo000o0.this;
                O00Oo00o o00Oo00o = oooo000o0.O00000o0;
                if (o00Oo00o != null) {
                    o00Oo00o.O000000o(oooo000o0.O00000o, O00OOo.O00000oO);
                }
                byte[] O000000o2 = o000oo0o0o.O000000o(i);
                oooo000o0.this.O00000o.setMeshAddress(i);
                oooo000o0.this.O00000o.getUnprovisionedMeshNode().setUnicastAddress(O000000o2);
                oooo000o0 oooo000o02 = oooo000o0.this;
                oooo000o02.O0000Ooo.O000000o((SearchDeviceBean) oooo000o02.O00000o);
            }

            public void O000000o(String str, String str2) {
                oooo000o0 oooo000o0 = oooo000o0.this;
                oooo000o0.O00000oO.O000000o(oooo000o0.O00000o, str, str2);
            }
        });
    }

    public void O00000oo() {
        this.O0000O0o.O00000Oo();
    }

    public void O0000O0o() {
        this.O0000o00.O000000o(this.O00000o);
    }

    public void O0000OOo() {
        ProvisionedMeshNode provisionedMeshNode = this.O00000o.getProvisionedMeshNode();
        if (provisionedMeshNode != null) {
            this.O00000oO.O0000Ooo().O000000o(new NetworkKey(0, provisionedMeshNode.getNetworkKey()), provisionedMeshNode, ByteBuffer.allocate(4).putInt(0).array(), (byte[]) null);
            this.O0000o0.O000000o(this.O00000o, this.O00oOooO);
        }
    }

    public void O0000Oo() {
        this.O0000o0o.O000000o(this.O00000o);
    }

    public void O0000Oo0() {
        this.O0000o0O.O000000o(this.O00000o);
    }

    public void O0000OoO() {
        this.O0000o.O000000o(this.O00000o);
    }

    public void O0000Ooo() {
        this.O0000O0o.O00000o0();
    }

    public SigMeshSearchDeviceBean O0000o() {
        return this.O00000o;
    }

    public oooo0o0o0 O0000o0() {
        return this.O0000O0o;
    }

    public void O0000o00() {
        this.O0000O0o.O000000o();
    }

    public void O0000o0O() {
        if (!this.O0000oO0) {
            if (this.O0000ooO.isEmpty()) {
                o00oo0oo00.O00000Oo("TuyaBlueMeshLocalActivator", String.format("sigmesh config time %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.O0000oOO)}));
                O00Oo00o o00Oo00o = this.O00000o0;
                if (o00Oo00o != null) {
                    o00Oo00o.O000000o();
                }
                O000000o();
                return;
            }
            SearchDeviceBean remove = this.O0000ooO.remove(0);
            this.O00000o = (SigMeshSearchDeviceBean) remove;
            this.O0000oOo = System.currentTimeMillis();
            UnprovisionedMeshNode O0000oOO2 = O0000oOO();
            if (O0000oOO2 == null) {
                this.O00000oO.O000000o(this.O00000o, O00OOo.O000O0OO, "init UnprovisionedMeshNode fail");
                return;
            }
            this.O00000o.setUnprovisionedMeshNode(O0000oOO2);
            this.O00000o0.O000000o(remove, O00OOo.O000OOoO);
            O000000o(remove);
        }
    }

    public long O0000o0o() {
        return this.O0000oOo;
    }

    public void O0000oO() {
        this.O00oOooo.removeMessages(136);
        this.O00oOooo.sendEmptyMessageDelayed(136, (long) (this.O0000oo * 1000));
    }

    public void O0000oO0() {
        this.O00000oO = new oooo000oo(this, this.O00000o0);
    }
}
