package com.tuya.smart.android.hardware.bean;

import a.a.a.a.a;
import java.util.Arrays;

public class TuyaFrame {
    public static final int footer = 43605;
    public static final int header = 21930;
    public int code = 0;
    public int crc32 = 0;
    public byte[] data = new byte[0];
    public int length = 0;
    public int seq = 0;
    public int type = 0;

    public TuyaFrame() {
    }

    public TuyaFrame(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        this.seq = i;
        this.type = i2;
        this.length = i3;
        this.code = i4;
        this.data = bArr;
        this.crc32 = i5;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        StringBuilder n = a.n("TuyaFrame{seq=");
        n.append(this.seq);
        n.append(", type=");
        n.append(this.type);
        n.append(", length=");
        n.append(this.length);
        n.append(", code=");
        n.append(this.code);
        n.append(", data=");
        n.append(Arrays.toString(this.data));
        n.append(", crc32=");
        n.append(this.crc32);
        n.append('}');
        return n.toString();
    }
}
