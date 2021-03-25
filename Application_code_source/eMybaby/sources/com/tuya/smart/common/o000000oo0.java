package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class o000000oo0 {
    public static final String O000000o = "ConfigAppKeyAddState";
    public SigMeshSearchDeviceBean O00000Oo;
    public o000oo0000 O00000o;
    public o0000o00oo O00000o0;
    public oo0oo0o00 O00000oO;
    public ooooo000o O00000oo = new ooooo000o() {
        public void O000000o(Message message) {
            if (message instanceof AccessMessage) {
                AccessMessage accessMessage = (AccessMessage) message;
                if (((accessMessage.getAccessPdu()[0] & 240) >> 6) == 2 && message.getOpCode() == 32771) {
                    o000000ooo o000000ooo = new o000000ooo(accessMessage);
                    if (o000000oo0.this.O00000o0 == null) {
                        return;
                    }
                    if (o000000ooo.d_()) {
                        o000000oo0.this.O00000o0.O000000o(o000000oo0.this.O00000Oo);
                    } else {
                        o000000oo0.this.O00000o0.O000000o(o000000oo0.this.O00000Oo, O00OOo.O000O0oo, "receive add appkey fail");
                    }
                }
            }
        }
    };

    public o000000oo0(o0000o00oo o0000o00oo, o000oo0000 o000oo0000) {
        this.O00000o0 = o0000o00oo;
        this.O00000o = o000oo0000;
    }

    public ooooo000o O000000o() {
        return this.O00000oo;
    }

    public void O000000o(final SigMeshSearchDeviceBean sigMeshSearchDeviceBean, String[] strArr) {
        this.O00000Oo = sigMeshSearchDeviceBean;
        NetworkKey O00000o2 = this.O00000o.O00000o();
        o000o0o0o0 o000o0o0o0 = new o000o0o0o0(0, o00o0000oo.O000000o(strArr[0]));
        o00oo0oo00.O000000o(O000000o, "ConfigAppKeyAddAction send");
        this.O00000oO = new oo0oo0o00(this.O00000Oo.getMacAdress(), O00000o2, o000o0o0o0, this.O00000o, new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O00000Oo(o000000oo0.O000000o, "ConfigAppKeyAddAction send error " + str2);
                if (o000000oo0.this.O00000o0 != null) {
                    o0000o00oo O000000o2 = o000000oo0.this.O00000o0;
                    SigMeshSearchDeviceBean sigMeshSearchDeviceBean = sigMeshSearchDeviceBean;
                    O000000o2.O000000o(sigMeshSearchDeviceBean, O00OOo.O000O0oo, "add appkey fail" + str);
                }
            }

            public void O00000Oo() {
                o00oo0oo00.O00000Oo(o000000oo0.O000000o, "ConfigAppKeyAddAction send success");
            }
        });
        ProvisionedMeshNode provisionedMeshNode = this.O00000Oo.getProvisionedMeshNode();
        provisionedMeshNode.setAddedAppKey(0, o000o0o0o0);
        this.O00000oO.O000000o(oo0o0oooo.O000000o().O00000o0(), provisionedMeshNode.getUnicastAddress(), provisionedMeshNode.getDeviceKey());
    }
}
