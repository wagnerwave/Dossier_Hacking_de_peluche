package a.d.a.a.e.m;

import a.d.a.a.f.a;
import a.d.a.a.h.e.b;
import android.os.IBinder;
import android.os.Parcel;

public final class m0 extends b implements l0 {
    public m0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final a b() {
        Parcel g = g(1, e());
        a g2 = a.C0063a.g(g.readStrongBinder());
        g.recycle();
        return g2;
    }

    public final int c() {
        Parcel g = g(2, e());
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }
}
