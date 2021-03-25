package a.e.a.a.o.h;

import a.e.a.a.p.i.f;

public abstract class b extends f {
    public abstract void onBluetoothStateChanged(boolean z);

    public void onSyncInvoke(Object... objArr) {
        onBluetoothStateChanged(objArr[0].booleanValue());
    }
}
