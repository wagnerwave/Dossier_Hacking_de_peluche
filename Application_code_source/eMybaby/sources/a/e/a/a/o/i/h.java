package a.e.a.a.o.i;

import a.e.a.a.o.h.e;
import a.e.a.a.o.j.b;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;

public class h extends k implements e {
    public UUID k;
    public UUID l;

    public h(UUID uuid, UUID uuid2, b bVar) {
        super(bVar);
        this.k = uuid;
        this.l = uuid2;
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
        if (!this.f3254e.g(this.k, this.l)) {
            D(-1);
        } else {
            G();
        }
    }

    public void e(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        int i2;
        H();
        if (i == 0) {
            this.f3251b.putByteArray("extra.byte.value", bArr);
            i2 = 0;
        } else {
            i2 = -1;
        }
        D(i2);
    }
}
