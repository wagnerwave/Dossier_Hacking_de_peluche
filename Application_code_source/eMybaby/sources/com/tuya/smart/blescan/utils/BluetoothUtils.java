package com.tuya.smart.blescan.utils;

import a.a.a.a.a;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.tutk.IOTC.AVFrame;
import com.tutk.IOTC.Camera;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class BluetoothUtils {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final char[] HEX_ARRAY = Camera.HEXES.toCharArray();

    public static boolean hasBlePermission(Context context) {
        int checkSelfPermission = ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_ADMIN");
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission != 0) {
            arrayList.add("android.permission.BLUETOOTH");
        }
        if (checkSelfPermission2 != 0) {
            arrayList.add("android.permission.BLUETOOTH_ADMIN");
        }
        return arrayList.isEmpty();
    }

    public static boolean isBluetoothEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static String parse(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & AVFrame.FRM_STATE_UNKOWN;
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[b2 >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
            if (i != bArr.length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        StringBuilder n = a.n("(0x) ");
        n.append(new String(cArr));
        return n.toString();
    }
}
