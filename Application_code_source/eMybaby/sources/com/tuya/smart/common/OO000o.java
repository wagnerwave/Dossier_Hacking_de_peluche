package com.tuya.smart.common;

import a.j.a.b;
import com.tutk.IOTC.AVFrame;

public final class OO000o {
    public static final String O000000o = "NotificationParser";

    public static void O000000o(String str, byte b2, byte[] bArr, byte[] bArr2, String str2) {
        int i = ((bArr2[4] & AVFrame.FRM_STATE_UNKOWN) << 8) + (bArr2[3] & AVFrame.FRM_STATE_UNKOWN);
        String format = String.format("%02x", new Object[]{Integer.valueOf(i)});
        if (b2 == b.BLE_GATT_OP_CTRL_DC.f()) {
            OO00o00.O00000Oo(str2).O000000o(str, bArr);
        } else if (b2 == b.BLE_GATT_OP_CTRL_DB.f() || b2 == b.BLE_GATT_OP_CTRL_EB.f()) {
            OO00o00.O00000Oo(str2).O000000o(str, b2, bArr, format);
        } else if (b2 == b.BLE_GATT_OP_CTRL_D4.f()) {
            O000000o(bArr, i);
        } else if (b2 == b.BLE_GATT_OP_CTRL_E1.f()) {
            O000000o(bArr);
        }
    }

    public static void O000000o(byte[] bArr) {
        int i = 65535 & ((bArr[3] << 8) + (bArr[2] & AVFrame.FRM_STATE_UNKOWN));
        O0000o.O00000Oo(String.format("%02x", new Object[]{Integer.valueOf(i)}), String.format("%02x", new Object[]{Integer.valueOf(((bArr[1] << 8) + (bArr[0] & AVFrame.FRM_STATE_UNKOWN)) & 255)}));
    }

    public static void O000000o(byte[] bArr, int i) {
        String str;
        boolean z;
        String str2 = "";
        if ((bArr[0] & AVFrame.FRM_STATE_UNKOWN) == 255) {
            byte b2 = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
            if (b2 == 0) {
                str2 = "modify group exception";
                str = o00oo0o0o0.O0000o00;
            } else if (b2 != 1) {
                if (b2 == 2) {
                    str2 = "The device not in group";
                    str = o00oo0o0o0.O0000OoO;
                } else if (b2 == 3) {
                    str2 = "The device can add 8 groups at most, please remove first";
                    str = o00oo0o0o0.O0000Ooo;
                }
            }
            z = false;
            O0000o.O000000o(String.format("%02x", new Object[]{Integer.valueOf(i)}), z, str2, str);
        }
        str = str2;
        z = true;
        O0000o.O000000o(String.format("%02x", new Object[]{Integer.valueOf(i)}), z, str2, str);
    }
}
