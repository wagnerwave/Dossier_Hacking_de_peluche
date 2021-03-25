package a.d.a.a.g;

import a.d.a.a.f.a;
import a.d.a.a.h.e.b;
import a.d.a.a.h.e.c;
import android.os.IBinder;
import android.os.Parcel;

public final class f extends b implements g {
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final a B(a aVar, String str, int i) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i);
        Parcel g = g(4, e2);
        a g2 = a.C0063a.g(g.readStrongBinder());
        g.recycle();
        return g2;
    }

    public final a I(a aVar, String str, int i) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(i);
        Parcel g = g(2, e2);
        a g2 = a.C0063a.g(g.readStrongBinder());
        g.recycle();
        return g2;
    }

    public final int M() {
        Parcel g = g(6, e());
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }

    public final int i(a aVar, String str, boolean z) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(z ? 1 : 0);
        Parcel g = g(5, e2);
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }

    public final int v(a aVar, String str, boolean z) {
        Parcel e2 = e();
        c.b(e2, aVar);
        e2.writeString(str);
        e2.writeInt(z ? 1 : 0);
        Parcel g = g(3, e2);
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }
}
