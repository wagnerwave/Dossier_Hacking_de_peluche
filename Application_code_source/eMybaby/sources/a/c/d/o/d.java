package a.c.d.o;

import a.a.a.a.a;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.util.Log;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f747a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f748b;

    public d(c cVar, BluetoothDevice bluetoothDevice) {
        this.f748b = cVar;
        this.f747a = bluetoothDevice;
    }

    public void run() {
        BluetoothGatt bluetoothGatt;
        c cVar;
        StringBuilder n = a.n("Connecting ... ->");
        n.append(this.f747a.getName());
        Log.d("SAMICO-BABYSC", n.toString());
        if (Build.VERSION.SDK_INT >= 23) {
            cVar = this.f748b;
            bluetoothGatt = this.f747a.connectGatt(cVar.f740d, true, cVar.l, 2);
        } else {
            cVar = this.f748b;
            bluetoothGatt = this.f747a.connectGatt(cVar.f740d, true, cVar.l);
        }
        cVar.h = bluetoothGatt;
    }
}
