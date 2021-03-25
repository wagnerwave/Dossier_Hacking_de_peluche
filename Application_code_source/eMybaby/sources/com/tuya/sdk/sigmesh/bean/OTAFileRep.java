package com.tuya.sdk.sigmesh.bean;

import com.tutk.IOTC.AVFrame;
import java.nio.ByteBuffer;

public class OTAFileRep extends Reps {
    public int alreadyCRC32;
    public int alreadyLength;
    public byte[] alreadyMD5;
    public int state;
    public int type;

    public void parseRep(byte[] bArr) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b2 = wrap.get() & AVFrame.FRM_STATE_UNKOWN;
            this.type = b2;
            if (b2 == 0) {
                this.state = wrap.get() & AVFrame.FRM_STATE_UNKOWN;
                this.alreadyLength = wrap.getInt();
                this.alreadyCRC32 = wrap.getInt();
                byte[] bArr2 = new byte[16];
                this.alreadyMD5 = bArr2;
                wrap.get(bArr2);
                this.success = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
