package a.d.a.a.e;

import a.c.a.f.b;
import a.d.a.a.e.m.l0;
import a.d.a.a.e.m.m0;
import a.d.a.a.h.e.a;
import a.d.a.a.h.e.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class v extends a implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public int f1449a;

    public v(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        b.d(bArr.length == 25);
        this.f1449a = Arrays.hashCode(bArr);
    }

    public static l0 U(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof l0 ? (l0) queryLocalInterface : new m0(iBinder);
    }

    public static byte[] h(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public final a.d.a.a.f.a b() {
        return new a.d.a.a.f.b(g());
    }

    public final int c() {
        return this.f1449a;
    }

    public final boolean e(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            a.d.a.a.f.a b2 = b();
            parcel2.writeNoException();
            c.b(parcel2, b2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int c2 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c2);
            return true;
        }
    }

    public boolean equals(Object obj) {
        a.d.a.a.f.a b2;
        if (obj != null && (obj instanceof l0)) {
            try {
                l0 l0Var = (l0) obj;
                if (l0Var.c() != this.f1449a || (b2 = l0Var.b()) == null) {
                    return false;
                }
                return Arrays.equals(g(), (byte[]) a.d.a.a.f.b.h(b2));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public abstract byte[] g();

    public int hashCode() {
        return this.f1449a;
    }
}
