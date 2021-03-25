package com.tuya.smart.sdk.bean;

public class BlueMeshModuleMapBean {
    public BluetoothStatusBean bluetooth;
    public BlueMeshWifiStatusBean wifi;

    public BluetoothStatusBean getBluetooth() {
        return this.bluetooth;
    }

    public BlueMeshWifiStatusBean getWifi() {
        return this.wifi;
    }

    public void setBluetooth(BluetoothStatusBean bluetoothStatusBean) {
        this.bluetooth = bluetoothStatusBean;
    }

    public void setWifi(BlueMeshWifiStatusBean blueMeshWifiStatusBean) {
        this.wifi = blueMeshWifiStatusBean;
    }
}
