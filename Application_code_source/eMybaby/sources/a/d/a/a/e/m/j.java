package a.d.a.a.e.m;

import a.d.a.a.h.e.b;
import a.d.a.a.h.e.c;
import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface j extends IInterface {

    public static abstract class a extends a.d.a.a.h.e.a implements j {

        /* renamed from: a.d.a.a.e.m.j$a$a  reason: collision with other inner class name */
        public static class C0061a extends b implements j {
            public C0061a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account d() {
                Parcel g = g(2, e());
                Account account = (Account) c.a(g, Account.CREATOR);
                g.recycle();
                return account;
            }
        }

        public static j g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof j ? (j) queryLocalInterface : new C0061a(iBinder);
        }
    }

    Account d();
}
