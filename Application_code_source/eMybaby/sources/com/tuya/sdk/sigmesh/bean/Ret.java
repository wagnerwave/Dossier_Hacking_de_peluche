package com.tuya.sdk.sigmesh.bean;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;
import com.tuya.smart.common.o00oo0oo00;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ret {
    public static final String TAG = "Ret";
    public int code;
    public byte[] data;
    public int flag;
    public byte[] iv;
    public int length;
    public byte[] raw;
    public Reps reps = new Reps();
    public int sn;
    public int sn_ack;
    public int version;

    private void dataParse() {
        a.y(this.data, false, a.n("dataParse:"), TAG);
        int i = this.code;
        if (i == 0) {
            DeviceInfoRep deviceInfoRep = new DeviceInfoRep();
            this.reps = deviceInfoRep;
            deviceInfoRep.parseRep(this.data);
        } else if (i == 12) {
            OTAStartRep oTAStartRep = new OTAStartRep();
            this.reps = oTAStartRep;
            oTAStartRep.parseRep(this.data);
        } else if (i == 13) {
            OTAFileRep oTAFileRep = new OTAFileRep();
            this.reps = oTAFileRep;
            oTAFileRep.parseRep(this.data);
        } else if (i == 14) {
            OTAOffsetRep oTAOffsetRep = new OTAOffsetRep();
            this.reps = oTAOffsetRep;
            oTAOffsetRep.parseRep(this.data);
        } else if (i == 15) {
            OTASendRep oTASendRep = new OTASendRep();
            this.reps = oTASendRep;
            oTASendRep.parseRep(this.data);
        } else if (i == 16) {
            OTAResultRep oTAResultRep = new OTAResultRep();
            this.reps = oTAResultRep;
            oTAResultRep.parseRep(this.data);
        }
    }

    public void parse(byte[] bArr) {
        try {
            byte b2 = this.raw[0] & AVFrame.FRM_STATE_UNKOWN;
            this.flag = b2;
            if (b2 == 0) {
                this.data = o00o0000oo.O000000o(this.raw, 1, this.raw.length - 1);
            } else {
                this.iv = o00o0000oo.O000000o(this.raw, 1, 16);
                byte[] O00000Oo = o00o0000oo.O00000Oo(bArr, this.iv, o00o0000oo.O000000o(this.raw, 17, this.raw.length - 17));
                this.data = O00000Oo;
                ByteBuffer wrap = ByteBuffer.wrap(O00000Oo);
                byte[] bArr2 = new byte[4];
                byte[] bArr3 = new byte[4];
                byte[] bArr4 = new byte[2];
                byte[] bArr5 = new byte[2];
                wrap.get(bArr2);
                wrap.get(bArr3);
                wrap.get(bArr4);
                wrap.get(bArr5);
                this.sn = o00o0000oo.O0000oO(bArr2);
                this.sn_ack = o00o0000oo.O0000oO(bArr3);
                this.code = o00o0000oo.O0000oOO(bArr4);
                int O0000oOO = o00o0000oo.O0000oOO(bArr5);
                this.length = O0000oOO;
                byte[] bArr6 = new byte[O0000oOO];
                byte[] bArr7 = new byte[2];
                wrap.get(bArr6);
                wrap.get(bArr7);
                ArrayList arrayList = new ArrayList();
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                arrayList.add(bArr4);
                arrayList.add(bArr5);
                arrayList.add(bArr6);
                byte[] O0000oO0 = o00o0000oo.O0000oO0(o00o0000oo.O000000o((List<byte[]>) arrayList));
                if (Arrays.equals(bArr7, O0000oO0)) {
                    o00oo0oo00.O00000o0(TAG, "parse: crc success");
                } else {
                    o00oo0oo00.O00000Oo(TAG, "parse: crc fail    crc = " + o00o0000oo.O000000o(O0000oO0, false) + ", receive crc = " + o00o0000oo.O000000o(bArr7, false));
                }
                this.data = bArr6;
            }
            dataParse();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder n = a.n("Ret{version=");
        n.append(this.version);
        n.append(", code=");
        n.append(this.code);
        n.append(", sn_ack=");
        n.append(this.sn_ack);
        n.append(", sn=");
        n.append(this.sn);
        n.append(", length=");
        n.append(this.length);
        n.append(", flag=");
        n.append(this.flag);
        n.append(", reps=");
        n.append(this.reps);
        n.append(", raw=");
        n.append(o00o0000oo.O000000o(this.raw, false));
        n.append(", data=");
        n.append(o00o0000oo.O000000o(this.data, false));
        n.append(", iv=");
        n.append(o00o0000oo.O000000o(this.iv, false));
        n.append('}');
        return n.toString();
    }
}
