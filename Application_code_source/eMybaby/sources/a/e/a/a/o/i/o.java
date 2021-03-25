package a.e.a.a.o.i;

import a.e.a.a.o.h.j;
import a.e.a.a.o.j.b;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;

public class o extends k implements j {
    public UUID k;
    public UUID l;
    public byte[] m;

    public o(UUID uuid, UUID uuid2, byte[] bArr, b bVar) {
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
        if (!this.f3254e.p(this.k, this.l, this.m)) {
            D(-1);
        } else {
            G();
        }
    }

    public void d(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        H();
        D(i == 0 ? 0 : -1);
    }
}
