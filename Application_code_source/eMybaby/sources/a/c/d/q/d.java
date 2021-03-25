package a.c.d.q;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f777b;

    public d(b bVar, BluetoothDevice bluetoothDevice) {
        this.f777b = bVar;
        this.f776a = bluetoothDevice;
    }

    public void run() {
        BluetoothGatt bluetoothGatt;
        b bVar;
        if (Build.VERSION.SDK_INT >= 23) {
            bVar = this.f777b;
            bluetoothGatt = this.f776a.connectGatt(bVar.f768c, true, bVar.l, 2);
        } else {
            bVar = this.f777b;
            bluetoothGatt = this.f776a.connectGatt(bVar.f768c, true, bVar.l);
        }
        bVar.i = bluetoothGatt;
    }
}
