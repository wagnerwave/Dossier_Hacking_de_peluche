package com.inuker.bluetooth.library;

import a.e.a.a.g;
import a.e.a.a.i;
import a.e.a.a.r.b;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BluetoothService extends Service {
    public IBinder onBind(Intent intent) {
        Log.v("miio-bluetooth", b.o("BluetoothService onBind", new Object[0]));
        return g.g();
    }

    public void onCreate() {
        super.onCreate();
        Log.v("miio-bluetooth", b.o("BluetoothService onCreate", new Object[0]));
        i.a().f3230a = getApplicationContext();
    }
}
