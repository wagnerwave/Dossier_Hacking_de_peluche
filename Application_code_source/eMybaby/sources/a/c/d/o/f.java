package a.c.d.o;

import a.a.a.a.a;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.util.Log;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f760b;

    public f(e eVar, BluetoothDevice bluetoothDevice) {
        this.f760b = eVar;
        this.f759a = bluetoothDevice;
    }

    public void run() {
        BluetoothGatt bluetoothGatt;
        e eVar;
        StringBuilder n = a.n("Connecting ... ->");
        n.append(this.f759a.getName());
        Log.d("SCALE", n.toString());
        if (Build.VERSION.SDK_INT >= 23) {
            eVar = this.f760b;
            bluetoothGatt = this.f759a.connectGatt(eVar.f753e, true, eVar.l, 2);
        } else {
            eVar = this.f760b;
            bluetoothGatt = this.f759a.connectGatt(eVar.f753e, true, eVar.l);
        }
        eVar.i = bluetoothGatt;
    }
}
