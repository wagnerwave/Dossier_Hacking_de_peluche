package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.b.f;
import android.text.TextUtils;
import android.util.Log;
import com.tuya.smart.common.OO000o0;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final h f1490a;

    public e(h hVar) {
        b.k(hVar);
        this.f1490a = hVar;
    }

    public static String c(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    public static String e(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String c2 = c(obj);
        String c3 = c(obj2);
        String c4 = c(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(c2)) {
            sb.append(str2);
            sb.append(c2);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(c3)) {
            sb.append(str2);
            sb.append(c3);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(c4)) {
            sb.append(str3);
            sb.append(c4);
        }
        return sb.toString();
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        h hVar = this.f1490a;
        u0 u0Var = null;
        r0 r0Var = hVar != null ? hVar.f1507e : null;
        if (r0Var != null) {
            String str2 = (String) i0.f1511b.f1517a;
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, e(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                synchronized (r0Var) {
                    b.k(str);
                    if (i < 0) {
                        i = 0;
                    }
                    if (i >= 9) {
                        i = 8;
                    }
                    char c2 = r0Var.f1490a.f1506d.a() ? 'C' : 'c';
                    char charAt = "01VDIWEA?".charAt(i);
                    String str3 = g.f1496a;
                    String e2 = e(str, r0.w(obj), r0.w(obj2), r0.w(obj3));
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 4 + String.valueOf(e2).length());
                    sb.append(OO000o0.O00000o);
                    sb.append(charAt);
                    sb.append(c2);
                    sb.append(str3);
                    sb.append(":");
                    sb.append(e2);
                    String sb2 = sb.toString();
                    if (sb2.length() > 1024) {
                        sb2 = sb2.substring(0, 1024);
                    }
                    h hVar2 = r0Var.f1490a;
                    u0 u0Var2 = hVar2.j;
                    if (u0Var2 != null) {
                        if (u0Var2.r()) {
                            u0Var = hVar2.j;
                        }
                    }
                    if (u0Var != null) {
                        u0Var.f.a(sb2);
                    }
                }
                return;
            }
            return;
        }
        String str4 = (String) i0.f1511b.f1517a;
        if (Log.isLoggable(str4, i)) {
            Log.println(i, str4, e(str, obj, obj2, obj3));
        }
    }

    public final void b(String str, Object obj) {
        a(2, str, obj, (Object) null, (Object) null);
    }

    public final void d(String str, Object obj) {
        a(3, str, obj, (Object) null, (Object) null);
    }

    public final void f(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, (Object) null);
    }

    public final r0 g() {
        return this.f1490a.c();
    }

    public final f h() {
        return this.f1490a.d();
    }

    public final b i() {
        return this.f1490a.e();
    }

    public final f1 j() {
        h hVar = this.f1490a;
        h.a(hVar.i);
        return hVar.i;
    }

    public final u0 k() {
        h hVar = this.f1490a;
        h.a(hVar.j);
        return hVar.j;
    }

    public final void l(String str, Object obj) {
        a(5, str, obj, (Object) null, (Object) null);
    }

    public final void m(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, (Object) null);
    }

    public final void n(String str, Object obj) {
        a(6, str, obj, (Object) null, (Object) null);
    }

    public final void o(String str) {
        a(2, str, (Object) null, (Object) null, (Object) null);
    }

    public final void p(String str) {
        a(5, str, (Object) null, (Object) null, (Object) null);
    }

    public final void q(String str) {
        a(6, str, (Object) null, (Object) null, (Object) null);
    }
}
