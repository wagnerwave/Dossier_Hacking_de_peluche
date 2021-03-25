package com.tuya.smart.common;

import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.bean.NetworkKey;
import com.tuya.sdk.sigmesh.bean.ProvisionedMeshNode;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;

public class oo0o0oooo {
    public static final oo0o0oooo O00000Oo = new oo0o0oooo();
    public static final String O00000o0 = "SigMeshLocalManager";
    public byte[] O000000o = {0, -86};
    public int O00000o = 20;
    public String O00000oO;
    public String O00000oo;
    public byte[] O0000O0o;
    public ooo0o0o00 O0000OOo;
    public ProvisionedMeshNode O0000Oo;
    public int O0000Oo0;
    public o000oo0000 O0000OoO = new o000oo0000(O00Oo00.O000000o());

    public static oo0o0oooo O000000o() {
        return O00000Oo;
    }

    /* access modifiers changed from: private */
    public void O000000o(ControlMessage controlMessage) {
        ProvisionedMeshNode O0000Oo2 = O000000o().O0000Oo();
        if (O0000Oo2 != null) {
            ooo0o0o00 ooo0o0o00 = new ooo0o0o00(O0000Oo2.getNodeMac(), new o00o0o0o0o.O000000o() {
                public void O000000o(String str, String str2) {
                }

                public void O00000Oo() {
                }
            }, this.O0000OoO);
            ooo0o0o00.O000000o((Message) controlMessage);
            ooo0o0o00.O0000o();
        }
    }

    public void O000000o(int i) {
        this.O00000o = i - 3;
    }

    public void O000000o(ProvisionedMeshNode provisionedMeshNode) {
        this.O0000Oo = provisionedMeshNode;
    }

    public void O000000o(ProvisionedMeshNode provisionedMeshNode, String str, String str2, byte[] bArr, final o000oo00o0 o000oo00o0) {
        this.O0000Oo = provisionedMeshNode;
        this.O00000oo = str;
        this.O00000oO = str2;
        byte[] array = ByteBuffer.allocate(4).putInt(0).array();
        byte[] O000000o2 = o00o0000oo.O000000o(str);
        this.O000000o = (byte[]) bArr.clone();
        o00oo0oo00.O000000o(O00000o0, "initSigMeshLocalManager  netkey:" + str2);
        this.O0000OoO.O000000o(new NetworkKey(0, o00o0000oo.O000000o(this.O00000oO)), this.O0000Oo, array, O000000o2);
        this.O0000OoO.O000000o((o000oo00o0) new o000oo00o0() {
            public void O000000o(ControlMessage controlMessage) {
                o00oo0oo00.O000000o(oo0o0oooo.O00000o0, "sendSegmentAcknowledgementMessage ");
                oo0o0oooo.this.O000000o(oo0o0oooo.this.O0000OoO.O00000o0(controlMessage));
            }

            public byte[] O000000o(byte[] bArr) {
                return o000oo00o0.O000000o(bArr);
            }
        });
    }

    public void O000000o(o000oo0000 o000oo0000) {
        this.O0000OoO = o000oo0000;
    }

    public void O000000o(ooo0o0o00 ooo0o0o00) {
        this.O0000OOo = ooo0o0o00;
    }

    public void O000000o(String str) {
        this.O00000oO = str;
    }

    public void O000000o(byte[] bArr) {
        this.O000000o = bArr;
    }

    public int O00000Oo() {
        return this.O00000o;
    }

    public void O00000Oo(int i) {
        this.O0000O0o = ByteBuffer.allocate(4).putInt(i).array();
    }

    public void O00000Oo(String str) {
        this.O00000oo = str;
    }

    public String O00000o() {
        return this.O00000oO;
    }

    public void O00000o0(int i) {
        this.O0000Oo0 = i;
        ooo0oo00o.O000000o().O000000o(i);
    }

    public byte[] O00000o0() {
        byte[] bArr = this.O000000o;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public String O00000oO() {
        return this.O00000oo;
    }

    public byte[] O00000oo() {
        if (this.O0000O0o == null) {
            this.O0000O0o = ByteBuffer.allocate(4).putInt(0).array();
        }
        return (byte[]) this.O0000O0o.clone();
    }

    public ooo0o0o00 O0000O0o() {
        return this.O0000OOo;
    }

    public int O0000OOo() {
        return this.O0000Oo0;
    }

    public ProvisionedMeshNode O0000Oo() {
        return this.O0000Oo;
    }

    public int O0000Oo0() {
        int O00000Oo2 = ooo0oo00o.O000000o().O00000Oo();
        this.O0000Oo0 = O00000Oo2;
        return O00000Oo2;
    }

    public o000oo0000 O0000OoO() {
        return this.O0000OoO;
    }
}
