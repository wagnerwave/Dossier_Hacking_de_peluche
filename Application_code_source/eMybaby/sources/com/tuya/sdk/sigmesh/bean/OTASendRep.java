package com.tuya.sdk.sigmesh.bean;

import com.tutk.IOTC.AVFrame;
import com.tuya.smart.common.o00o0000oo;
import com.tuya.smart.common.o00oo0oo00;

public class OTASendRep extends Reps {
    public static final String TAG = "OTASendRep";
    public int state;
    public int type;

    public void parseRep(byte[] bArr) {
        try {
            o00oo0oo00.O000000o(TAG, "parse ota send data: " + o00o0000oo.O000000o(bArr, false));
            this.type = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
            byte b2 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
            this.state = b2;
            if (b2 == 0) {
                this.success = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
