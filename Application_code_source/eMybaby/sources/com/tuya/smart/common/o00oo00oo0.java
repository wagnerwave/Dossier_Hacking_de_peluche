package com.tuya.smart.common;

import android.bluetooth.BluetoothDevice;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.android.blemesh.bean.SigMeshSearchDeviceBean;

public class o00oo00oo0 {
    public static SearchDeviceBean O000000o(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        SigMeshSearchDeviceBean sigMeshSearchDeviceBean = new SigMeshSearchDeviceBean();
        sigMeshSearchDeviceBean.setType(1);
        sigMeshSearchDeviceBean.setDevice(bluetoothDevice);
        sigMeshSearchDeviceBean.setMacAdress(bluetoothDevice.getAddress());
        sigMeshSearchDeviceBean.setScanRecord(bArr);
        sigMeshSearchDeviceBean.setRssi(i);
        sigMeshSearchDeviceBean.setMeshBeacon(o00o0000oo.O000000o(bArr));
        sigMeshSearchDeviceBean.setMeshName(bluetoothDevice.getName());
        return sigMeshSearchDeviceBean;
    }
}
