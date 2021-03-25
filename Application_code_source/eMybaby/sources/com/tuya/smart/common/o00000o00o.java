package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.AccessMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;

public class o00000o00o {
    public static final String O00000Oo = "ConfigCompositionState";
    public SigMeshSearchDeviceBean O000000o;
    public o000oo0000 O00000o;
    public o0000o0o00 O00000o0;
    public ooooo000o O00000oO = new ooooo000o() {
        public void O000000o(Message message) {
            if (message instanceof AccessMessage) {
                AccessMessage accessMessage = (AccessMessage) message;
                if (((accessMessage.getAccessPdu()[0] & 240) >> 6) == 0 && message.getOpCode() == 2) {
                    o00000o000 o00000o000 = new o00000o000(accessMessage);
                    o00000o00o.this.O000000o.setElement(o00000o000.O0000Ooo());
                    o00000o00o.this.O000000o.setProductIdentifier(o00000o000.f_());
                    o00000o00o.this.O000000o.setVersionIdentifier(o00000o000.g_());
                    o00000o00o.this.O000000o.getProvisionedMeshNode().setCompositionData(o00000o000);
                    if (o00000o00o.this.O00000o0 != null) {
                        o00000o00o.this.O00000o0.O000000o(o00000o00o.this.O000000o);
                    }
                }
            }
        }
    };

    public o00000o00o(o0000o0o00 o0000o0o00, o000oo0000 o000oo0000) {
        this.O00000o0 = o0000o0o00;
        this.O00000o = o000oo0000;
    }

    public ooooo000o O000000o() {
        return this.O00000oO;
    }

    public void O000000o(final SigMeshSearchDeviceBean sigMeshSearchDeviceBean) {
        this.O000000o = sigMeshSearchDeviceBean;
        oo0oo0o0o oo0oo0o0o = new oo0oo0o0o(sigMeshSearchDeviceBean.getMacAdress(), this.O00000o, new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(o00000o00o.O00000Oo, "sendConfigComposition fail " + str2 + DpTimerBean.FILL + str);
                if (o00000o00o.this.O00000o0 != null) {
                    o0000o0o00 O000000o2 = o00000o00o.this.O00000o0;
                    SigMeshSearchDeviceBean sigMeshSearchDeviceBean = sigMeshSearchDeviceBean;
                    O000000o2.O000000o(sigMeshSearchDeviceBean, O00OOo.O000O0o, "config composition fail " + str);
                }
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(o00000o00o.O00000Oo, "sendConfigComposition success ");
            }
        });
        ProvisionedMeshNode provisionedMeshNode = this.O000000o.getProvisionedMeshNode();
        if (provisionedMeshNode != null) {
            this.O00000o.O000000o(new NetworkKey(0, provisionedMeshNode.getNetworkKey()), provisionedMeshNode, ByteBuffer.allocate(4).putInt(0).array(), (byte[]) null);
            oo0oo0o0o.O000000o(oo0o0oooo.O000000o().O00000o0(), provisionedMeshNode.getUnicastAddress(), provisionedMeshNode.getDeviceKey());
        }
    }
}
