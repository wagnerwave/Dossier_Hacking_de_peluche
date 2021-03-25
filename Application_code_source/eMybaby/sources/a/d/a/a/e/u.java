package a.d.a.a.e;

import a.c.a.f.b;
import a.d.a.a.e.m.n0;
import a.d.a.a.e.m.o0;
import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static volatile o0 f1446a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f1447b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static Context f1448c;

    public static c0 a(String str, v vVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return c(str, vVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static synchronized void b(Context context) {
        synchronized (u.class) {
            if (f1448c == null) {
                f1448c = context.getApplicationContext();
            } else {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            }
        }
    }

    public static c0 c(String str, v vVar, boolean z, boolean z2) {
        try {
            if (f1446a == null) {
                b.k(f1448c);
                synchronized (f1447b) {
                    if (f1446a == null) {
                        f1446a = n0.g(DynamiteModule.c(f1448c, DynamiteModule.j, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            b.k(f1448c);
            try {
                if (f1446a.K(new zzj(str, vVar, z, z2), new a.d.a.a.f.b(f1448c.getPackageManager()))) {
                    return c0.f1234d;
                }
                return new e0(new w(z, str, vVar), (f0) null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return new c0(false, "module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return new c0(false, valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }
}
