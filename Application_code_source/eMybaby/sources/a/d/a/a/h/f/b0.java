package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.e.q.f;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final h f1474a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Boolean f1475b;

    /* renamed from: c  reason: collision with root package name */
    public String f1476c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Integer> f1477d;

    public b0(h hVar) {
        b.k(hVar);
        this.f1474a = hVar;
    }

    public static long b() {
        return ((Long) i0.f1514e.f1517a).longValue();
    }

    public static int c() {
        return ((Integer) i0.g.f1517a).intValue();
    }

    public static String d() {
        return (String) i0.j.f1517a;
    }

    public static String e() {
        return (String) i0.i.f1517a;
    }

    public static String f() {
        return (String) i0.k.f1517a;
    }

    public final boolean a() {
        if (this.f1475b == null) {
            synchronized (this) {
                if (this.f1475b == null) {
                    ApplicationInfo applicationInfo = this.f1474a.f1503a.getApplicationInfo();
                    String a2 = f.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f1475b = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if ((this.f1475b == null || !this.f1475b.booleanValue()) && "com.google.android.gms.analytics".equals(a2)) {
                        this.f1475b = Boolean.TRUE;
                    }
                    if (this.f1475b == null) {
                        this.f1475b = Boolean.TRUE;
                        this.f1474a.c().q("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f1475b.booleanValue();
    }

    public final Set<Integer> g() {
        String str;
        String str2 = (String) i0.s.f1517a;
        if (this.f1477d == null || (str = this.f1476c) == null || !str.equals(str2)) {
            String[] split = TextUtils.split(str2, ",");
            HashSet hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException unused) {
                }
            }
            this.f1476c = str2;
            this.f1477d = hashSet;
        }
        return this.f1477d;
    }
}
