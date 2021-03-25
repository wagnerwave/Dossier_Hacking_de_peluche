package com.tuya.smart.blescan;

import a.a.a.a.a;
import android.bluetooth.BluetoothDevice;
import androidx.annotation.Keep;
import com.tuya.smart.blescan.utils.BluetoothUtils;

@Keep
public class ScanLeBean {
    public String address;
    public BluetoothDevice device;
    public String name;
    public Object parseObject;
    public int rssi;
    public byte[] scanRecord;

    public String toString() {
        StringBuilder n = a.n("ScanLeBean{name='");
        a.x(n, this.name, '\'', ", address='");
        a.x(n, this.address, '\'', ", rssi=");
        n.append(this.rssi);
        n.append(", parseObject=");
        n.append(this.parseObject);
        n.append(", scanRecord=");
        n.append(BluetoothUtils.parse(this.scanRecord));
        n.append('}');
        return n.toString();
    }
}
