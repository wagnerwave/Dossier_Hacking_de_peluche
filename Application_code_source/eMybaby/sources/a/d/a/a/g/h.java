package a.d.a.a.g;

import a.d.a.a.f.a;
import a.d.a.a.h.e.b;
import a.d.a.a.h.e.c;
import android.os.IBinder;
import android.os.Parcel;

public final class h extends b implements i {
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final a s(a aVar, String str, int i, a aVar2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i);
        c.b(e2, aVar2);
        Parcel g = g(2, e2);
        a g2 = a.C0063a.g(g.readStrongBinder());
        g.recycle();
        return g2;
    }

    public final a t(a aVar, String str, int i, a aVar2) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i);
        c.b(e2, aVar2);
        Parcel g = g(3, e2);
        a g2 = a.C0063a.g(g.readStrongBinder());
        g.recycle();
        return g2;
    }
}
