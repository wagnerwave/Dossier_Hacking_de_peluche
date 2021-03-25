package com.tuya.sdk.sigmesh.bean;

import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;
import java.nio.ByteBuffer;

public class OTAStartRep extends Reps {
    public boolean allowUpdate;
    public int maxLimit;
    public int otaVersion;
    public int type;
    public String version;

    public void parseRep(byte[] bArr) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.allowUpdate = (wrap.get() & AVFrame.FRM_STATE_UNKOWN) == 0;
            this.otaVersion = wrap.get() & AVFrame.FRM_STATE_UNKOWN;
            byte b2 = wrap.get() & AVFrame.FRM_STATE_UNKOWN;
            this.type = b2;
            if (b2 == 0) {
                byte[] bArr2 = new byte[4];
                byte[] bArr3 = new byte[2];
                wrap.get(bArr2);
                wrap.get(bArr3);
                this.version = String.valueOf((bArr2[1] & AVFrame.FRM_STATE_UNKOWN) + "." + (bArr2[2] & AVFrame.FRM_STATE_UNKOWN) + "." + (bArr2[3] & AVFrame.FRM_STATE_UNKOWN));
                this.maxLimit = o00o0000oo.O0000oOO(bArr3);
                this.success = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
