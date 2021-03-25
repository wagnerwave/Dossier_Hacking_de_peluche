package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;

public class o00000oooo {
    public static final String O00000Oo = "ConfigNetworkTransmitState";
    public SigMeshSearchDeviceBean O000000o;
    public o000oo0000 O00000o;
    public o0000o0ooo O00000o0;
    public ooooo000o O00000oO = new ooooo000o() {
        public void O000000o(Message message) {
            if (message instanceof AccessMessage) {
                AccessMessage accessMessage = (AccessMessage) message;
                if (((accessMessage.getAccessPdu()[0] & 240) >> 6) == 2 && message.getOpCode() == 32805) {
                    new o0000o0000(accessMessage);
                    if (o00000oooo.this.O00000o0 != null) {
                        o00000oooo.this.O00000o0.O000000o(o00000oooo.this.O000000o);
                    }
                }
            }
        }
    };

    public o00000oooo(o0000o0ooo o0000o0ooo, o000oo0000 o000oo0000) {
        this.O00000o0 = o0000o0ooo;
        this.O00000o = o000oo0000;
    }

    public ooooo000o O000000o() {
        return this.O00000oO;
    }

    public void O000000o(SigMeshSearchDeviceBean sigMeshSearchDeviceBean) {
        this.O000000o = sigMeshSearchDeviceBean;
        ProvisionedMeshNode provisionedMeshNode = sigMeshSearchDeviceBean.getProvisionedMeshNode();
        new oo0ooo0oo(5, 2).O000000o(this.O000000o.getMacAdress(), this.O00000o, oo0o0oooo.O000000o().O00000o0(), provisionedMeshNode.getUnicastAddress(), provisionedMeshNode.getDeviceKey(), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(o00000oooo.O00000Oo, "sendNetworkTransmit fail ");
                if (o00000oooo.this.O00000o0 != null) {
                    o0000o0ooo O000000o2 = o00000oooo.this.O00000o0;
                    SigMeshSearchDeviceBean sigMeshSearchDeviceBean = o00000oooo.this.O000000o;
                    O000000o2.O000000o(sigMeshSearchDeviceBean, O00OOo.O000OOo, "sendModelPublication fail " + str2);
                }
            }

            public void O00000Oo() {
            }
        });
    }
}
