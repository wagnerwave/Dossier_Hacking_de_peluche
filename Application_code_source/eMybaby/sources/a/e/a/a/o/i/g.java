package a.e.a.a.o.i;

import a.e.a.a.o.h.f;
import a.e.a.a.o.j.b;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;

public class g extends k implements f {
    public UUID k;
    public UUID l;
    public UUID m;

    public g(UUID uuid, UUID uuid2, UUID uuid3, b bVar) {
        super(bVar);
        this.k = uuid;
        this.l = uuid2;
        this.m = uuid3;
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
        if (!this.f3254e.j(this.k, this.l, this.m)) {
            D(-1);
        } else {
            G();
        }
    }

    public void b(BluetoothGattDescriptor bluetoothGattDescriptor, int i, byte[] bArr) {
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
