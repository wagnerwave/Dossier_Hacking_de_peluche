package a.e.a.a.o.i;

import a.e.a.a.o.h.j;
import a.e.a.a.o.j.b;
import a.e.a.a.r.a;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import java.util.UUID;

public class n extends k implements j {
    public UUID k;
    public UUID l;
    public byte[] m;

    public n(UUID uuid, UUID uuid2, byte[] bArr, b bVar) {
        super(bVar);
        this.k = uuid;
        this.l = uuid2;
        this.m = bArr;
    }

    public void F() {
        int o = o();
        if (o == 0 || !(o == 2 || o == 19)) {
            D(-1);
        } else {
            I();
        }
    }

    public final void I() {
        int i;
        if (!this.f3254e.w(this.k, this.l, this.m)) {
            i = -1;
        } else {
            Log.d("miio-bluetooth", "BleWriteNoRspRequest startWrite:  startWrite success");
            i = 0;
        }
        D(i);
    }

    public void d(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        Log.d("miio-bluetooth", "BleWriteNoRspRequest onCharacteristicWrite() called with: characteristic = [" + bluetoothGattCharacteristic + "], status = [" + i + "], value = [" + a.b(bArr) + "]");
    }
}
