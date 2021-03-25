package a.e.a.a.o.i;

import a.e.a.a.o.h.k;
import a.e.a.a.o.j.b;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;

public class e extends k implements k {
    public UUID k;
    public UUID l;

    public e(UUID uuid, UUID uuid2, b bVar) {
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
        D(!z(this.k, this.l, true) ? -1 : 0);
    }

    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        H();
        D(i == 0 ? 0 : -1);
    }
}
