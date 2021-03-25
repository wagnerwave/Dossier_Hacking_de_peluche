package com.cuatroochenta.miniland.scalemanager;

import a.a.a.a.a;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class ScalePairingRequest extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public String f4083a = "000000";

    public void onReceive(Context context, Intent intent) {
        String str;
        if (Build.VERSION.SDK_INT >= 19 && "android.bluetooth.device.action.PAIRING_REQUEST".equals(intent.getAction())) {
            Log.d("SAMICO-BABYSC", "On Pairing Request");
            if (intent.hasExtra("android.bluetooth.device.extra.DEVICE")) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    StringBuilder n = a.n("Pairing ->");
                    n.append(bluetoothDevice.getName());
                    Log.d("SAMICO-BABYSC", n.toString());
                    if ("Samico-BabySC".equalsIgnoreCase(bluetoothDevice.getName())) {
                        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", Integer.MIN_VALUE);
                        if (bluetoothDevice.getBondState() == 12) {
                            StringBuilder n2 = a.n("Bond State is ");
                            n2.append(bluetoothDevice.getBondState());
                            str = n2.toString();
                        } else if (intExtra == 0) {
                            try {
                                bluetoothDevice.setPin(this.f4083a.getBytes());
                                Log.d("SAMICO-BABYSC", "On Set PIN");
                                return;
                            } catch (Exception unused) {
                                Log.d("SAMICO-BABYSC", "On Set PIN ");
                                return;
                            }
                        } else {
                            str = a.h("Pairing Variant is ", intExtra);
                        }
                    } else {
                        str = "Device has not same name";
                    }
                } else {
                    str = "Device is null";
                }
            } else {
                str = "Intent has no extra";
            }
            Log.d("SAMICO-BABYSC", str);
        }
    }
}
