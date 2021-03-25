package com.tuya.smart.common;

import a.j.a.b;
import com.tutk.IOTC.AVFrame;

public final class OO00OO {
    public static final String O000000o = "RawParser";

    public static String O000000o(String str, byte[] bArr) {
        int i = ((bArr[1] & AVFrame.FRM_STATE_UNKOWN) << 8) + (bArr[0] & AVFrame.FRM_STATE_UNKOWN);
        String format = String.format("%02x", new Object[]{Integer.valueOf(i)});
        byte b2 = (byte) (bArr[2] & AVFrame.FRM_STATE_UNKOWN);
        String format2 = String.format("%04x", new Object[]{Integer.valueOf(((bArr[3] & AVFrame.FRM_STATE_UNKOWN) << 8) + (bArr[4] & AVFrame.FRM_STATE_UNKOWN))});
        byte[] bArr2 = new byte[10];
        System.arraycopy(bArr, 5, bArr2, 0, 10);
        if (b2 == b.BLE_GATT_OP_CTRL_DB.f() || b2 == b.BLE_GATT_OP_CTRL_EB.f()) {
            return OO00o00.O00000Oo(format2).O000000o(str, b2, bArr2, format);
        }
        if (b2 == b.BLE_GATT_OP_CTRL_D4.f()) {
            OO000o.O000000o(bArr2, i);
            return "";
        } else if (b2 != b.BLE_GATT_OP_CTRL_E1.f()) {
            return "";
        } else {
            OO000o.O000000o(bArr2);
            return "";
        }
    }

    public static String O000000o(byte[] bArr) {
        return String.format("%02x", new Object[]{Integer.valueOf(((bArr[1] << 8) + (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) & 255)});
    }
}
