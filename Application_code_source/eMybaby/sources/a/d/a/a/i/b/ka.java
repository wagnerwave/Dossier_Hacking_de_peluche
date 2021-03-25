package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.e.r.c;
import a.d.a.a.h.g.t9;
import a.d.a.a.h.g.wb;
import a.d.a.a.h.g.zb;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import com.nineoldandroids.util.ReflectiveProperty;
import java.lang.reflect.InvocationTargetException;

public final class ka extends v5 {

    /* renamed from: b  reason: collision with root package name */
    public Boolean f2330b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public b f2331c = c.f2114a;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f2332d;

    public ka(c5 c5Var) {
        super(c5Var);
    }

    public static long z() {
        return q.D.a(null).longValue();
    }

    public final boolean A(String str) {
        return "1".equals(this.f2331c.h(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    public final boolean B() {
        if (this.f2330b == null) {
            Boolean v = v("app_measurement_lite");
            this.f2330b = v;
            if (v == null) {
                this.f2330b = Boolean.FALSE;
            }
        }
        return this.f2330b.booleanValue() || !this.f2563a.f2127e;
    }

    @Nullable
    public final Bundle C() {
        try {
            if (this.f2563a.f2123a.getPackageManager() == null) {
                i().f.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = c.a(this.f2563a.f2123a).a(this.f2563a.f2123a.getPackageName(), 128);
            if (a2 != null) {
                return a2.metaData;
            }
            i().f.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            i().f.b("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    public final String h(String str, String str2) {
        String str3;
        z3 z3Var;
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(ReflectiveProperty.PREFIX_GET, new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e2) {
            e = e2;
            z3Var = i().f;
            str3 = "Could not find SystemProperties class";
            z3Var.b(str3, e);
            return str2;
        } catch (NoSuchMethodException e3) {
            e = e3;
            z3Var = i().f;
            str3 = "Could not find SystemProperties.get() method";
            z3Var.b(str3, e);
            return str2;
        } catch (IllegalAccessException e4) {
            e = e4;
            z3Var = i().f;
            str3 = "Could not access SystemProperties.get()";
            z3Var.b(str3, e);
            return str2;
        } catch (InvocationTargetException e5) {
            e = e5;
            z3Var = i().f;
            str3 = "SystemProperties.get() threw an exception";
            z3Var.b(str3, e);
            return str2;
        }
    }

    public final int l(@Size(min = 1) String str) {
        return Math.max(Math.min(q(str, q.I), 100), 25);
    }

    @WorkerThread
    public final long n(String str, @NonNull n3<Long> n3Var) {
        if (str != null) {
            String h = this.f2331c.h(str, n3Var.f2393a);
            if (!TextUtils.isEmpty(h)) {
                try {
                    return n3Var.a(Long.valueOf(Long.parseLong(h))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return n3Var.a(null).longValue();
    }

    public final boolean o(n3<Boolean> n3Var) {
        return t((String) null, n3Var);
    }

    public final int p(@Size(min = 1) String str) {
        if (!t9.b() || !t((String) null, q.E0)) {
            return 500;
        }
        return Math.max(Math.min(q(str, q.H), RecyclerView.MAX_SCROLL_DURATION), 500);
    }

    @WorkerThread
    public final int q(String str, @NonNull n3<Integer> n3Var) {
        if (str != null) {
            String h = this.f2331c.h(str, n3Var.f2393a);
            if (!TextUtils.isEmpty(h)) {
                try {
                    return n3Var.a(Integer.valueOf(Integer.parseInt(h))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return n3Var.a(null).intValue();
    }

    @WorkerThread
    public final int r(@Size(min = 1) String str) {
        return q(str, q.o);
    }

    public final int s() {
        if (!t9.b() || !this.f2563a.g.t((String) null, q.F0)) {
            return 25;
        }
        v9 e2 = e();
        Boolean bool = e2.f2563a.x().f2550e;
        return e2.z0() >= 201500 || (bool != null && !bool.booleanValue()) ? 100 : 25;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [a.d.a.a.i.b.n3, a.d.a.a.i.b.n3<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(java.lang.String r4, @androidx.annotation.NonNull a.d.a.a.i.b.n3<java.lang.Boolean> r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x000e
        L_0x0003:
            java.lang.Object r4 = r5.a(r0)
        L_0x0007:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L_0x000e:
            a.d.a.a.i.b.b r1 = r3.f2331c
            java.lang.String r2 = r5.f2393a
            java.lang.String r4 = r1.h(r4, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x001d
            goto L_0x0003
        L_0x001d:
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = r5.a(r4)
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.ka.t(java.lang.String, a.d.a.a.i.b.n3):boolean");
    }

    public final boolean u(String str, n3<Boolean> n3Var) {
        return t(str, n3Var);
    }

    @Nullable
    public final Boolean v(@Size(min = 1) String str) {
        b.h(str);
        Bundle C = C();
        if (C == null) {
            i().f.a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!C.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(C.getBoolean(str));
        }
    }

    public final boolean w() {
        Boolean v = v("firebase_analytics_collection_deactivated");
        return v != null && v.booleanValue();
    }

    public final Boolean x() {
        Boolean v = v("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(v == null || v.booleanValue());
    }

    public final Boolean y() {
        if (!((zb) wb.f2015b.a()).a() || !o(q.w0)) {
            return Boolean.TRUE;
        }
        Boolean v = v("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(v == null || v.booleanValue());
    }
}
