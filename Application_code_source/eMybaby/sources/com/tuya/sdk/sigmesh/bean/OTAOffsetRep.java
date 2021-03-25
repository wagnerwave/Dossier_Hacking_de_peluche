package com.tuya.sdk.sigmesh.bean;

import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;

public class OTAOffsetRep extends Reps {
    public int offset;
    public int type;

    public void parseRep(byte[] bArr) {
        try {
            byte b2 = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
            this.type = b2;
            if (b2 == 0) {
                this.offset = o00o0000oo.O0000oO(o00o0000oo.O000000o(bArr, 1, 4));
                this.success = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
