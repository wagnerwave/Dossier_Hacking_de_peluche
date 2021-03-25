package a.e.a.a.p;

import a.e.a.a.p.i.e;
import a.e.a.a.p.i.g;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3262b = {"android.bluetooth.device.action.BOND_STATE_CHANGED"};

    public d(h hVar) {
        super(hVar);
    }

    public List<String> a() {
        return Arrays.asList(f3262b);
    }

    public boolean c(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        if (bluetoothDevice != null) {
            String address = bluetoothDevice.getAddress();
            for (g invoke : b(e.class)) {
                invoke.invoke(address, Integer.valueOf(intExtra));
            }
        }
        return true;
    }
}
