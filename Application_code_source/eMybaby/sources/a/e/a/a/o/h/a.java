package a.e.a.a.o.h;

import a.e.a.a.p.i.f;

public abstract class a extends f {
    public abstract void onConnectStatusChanged(String str, int i);

    public void onSyncInvoke(Object... objArr) {
        onConnectStatusChanged(objArr[0], objArr[1].intValue());
    }
}
