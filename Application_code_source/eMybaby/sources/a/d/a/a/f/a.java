package a.d.a.a.f;

import a.d.a.a.h.e.b;
import android.os.IBinder;
import android.os.IInterface;

public interface a extends IInterface {

    /* renamed from: a.d.a.a.f.a$a  reason: collision with other inner class name */
    public static abstract class C0063a extends a.d.a.a.h.e.a implements a {

        /* renamed from: a.d.a.a.f.a$a$a  reason: collision with other inner class name */
        public static class C0064a extends b implements a {
            public C0064a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public C0063a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0064a(iBinder);
        }
    }
}
