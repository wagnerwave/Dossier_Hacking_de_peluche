package com.tuya.sdk.sigmesh.bean;

import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;
import java.nio.ByteBuffer;

public class DeviceInfoRep extends Reps {
    public String authKey;
    public String deviceVersion;
    public int flag;
    public String hardwareVersion;
    public boolean isBind;
    public String protocolVersion;
    public byte[] srand;

    private String version(byte[] bArr) {
        if (bArr.length < 2) {
            return "";
        }
        byte b2 = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        byte b3 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
        return String.valueOf(b2 + "." + b3);
    }

    public void parseRep(byte[] bArr) {
        boolean z = false;
        if (bArr == null || bArr.length < 12) {
            this.success = false;
            return;
        }
        try {
            byte[] bArr2 = new byte[2];
            byte[] bArr3 = new byte[2];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.get(bArr2);
            wrap.get(bArr3);
            this.flag = wrap.get() & 2;
            if ((wrap.get() & AVFrame.FRM_STATE_UNKOWN) == 1) {
                z = true;
            }
            this.isBind = z;
            byte[] bArr4 = new byte[6];
            wrap.get(bArr4);
            byte[] bArr5 = new byte[2];
            byte[] bArr6 = new byte[32];
            wrap.get(bArr5);
            wrap.get(bArr6);
            this.deviceVersion = version(bArr2);
            this.protocolVersion = version(bArr3);
            this.srand = bArr4;
            this.hardwareVersion = version(bArr5);
            this.authKey = o00o0000oo.O0000oOo(bArr6);
            this.success = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
