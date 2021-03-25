package com.tuya.smart.common;

import a.a.a.a.a;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.tutk.IOTC.AVFrame;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;

public class o00oo00o0o {
    public static final String O000000o = "ble_search";
    public static final int O00000Oo = 3;
    public static final int O00000o = 6;
    public static final int O00000o0 = 16;
    public static final int O00000oO = 8;

    public static SearchDeviceBean O000000o(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        return O000000o(bluetoothDevice, bArr, bluetoothDevice.getAddress(), bluetoothDevice.getName(), i);
    }

    public static SearchDeviceBean O000000o(BluetoothDevice bluetoothDevice, byte[] bArr, String str, String str2, int i) {
        BluetoothDevice bluetoothDevice2 = bluetoothDevice;
        byte[] bArr2 = bArr;
        if ((TextUtils.equals(str2, o00oo0o000.O000000o) && bArr2 == null) || bArr2 == null) {
            return null;
        }
        try {
            int i2 = (bArr2[3] & AVFrame.FRM_STATE_UNKOWN) - 1;
            if (i2 <= 16) {
                if (i2 >= 0) {
                    byte[] bArr3 = new byte[16];
                    System.arraycopy(bArr2, 5, bArr3, 0, i2);
                    int b2 = a.b(i2, 3, 1, 1);
                    int i3 = (bArr2[b2] & AVFrame.FRM_STATE_UNKOWN) - 1;
                    if (i3 <= 0) {
                        return null;
                    }
                    System.arraycopy(bArr2, b2 + 2, new byte[i3], 0, i3);
                    int i4 = b2 + i3 + 1 + 1 + 4;
                    System.arraycopy(bArr2, i4, new byte[6], 0, 6);
                    int i5 = i4 + 6;
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = (bArr2[i5] << 8) + (bArr2[i6] & AVFrame.FRM_STATE_UNKOWN);
                    int i9 = i7 + 1;
                    byte b3 = bArr2[i7] & AVFrame.FRM_STATE_UNKOWN;
                    int i10 = i9 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr2[i9] & AVFrame.FRM_STATE_UNKOWN) + (bArr2[i10] << 8)) & 255;
                    byte[] bArr4 = new byte[8];
                    System.arraycopy(bArr2, i11, bArr4, 0, 8);
                    int i13 = i11 + 8;
                    System.arraycopy(bArr2, i13, new byte[3], 0, 2);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(new char[]{(char) bArr2[i13], '.', (char) bArr2[i13 + 1]});
                    String stringBuffer2 = stringBuffer.toString();
                    SearchDeviceBean searchDeviceBean = new SearchDeviceBean();
                    searchDeviceBean.setMeshName(o00ooo0000.O000000o(bArr3));
                    searchDeviceBean.setRssi(i);
                    if (bluetoothDevice2 != null) {
                        searchDeviceBean.setDevice(bluetoothDevice);
                    }
                    searchDeviceBean.setScanRecord(bArr2);
                    searchDeviceBean.setMacAdress(str);
                    searchDeviceBean.setVendorId(i8);
                    searchDeviceBean.setMeshAddress(i12);
                    searchDeviceBean.setStatus(b3);
                    searchDeviceBean.setVersion(stringBuffer2);
                    searchDeviceBean.setProductId(bArr4);
                    return searchDeviceBean;
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
