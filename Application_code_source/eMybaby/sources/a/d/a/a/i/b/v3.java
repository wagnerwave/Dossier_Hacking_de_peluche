package a.d.a.a.i.b;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.h.g.aa;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;
import com.tuya.smart.common.o0ooo00oo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

public final class v3 extends y5 {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference<String[]> f2557c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference<String[]> f2558d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReference<String[]> f2559e = new AtomicReference<>();

    public v3(c5 c5Var) {
        super(c5Var);
    }

    @Nullable
    public static String v(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        b.k(strArr);
        b.k(strArr2);
        b.k(atomicReference);
        b.d(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (v9.r0(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    public final boolean q() {
        return false;
    }

    @Nullable
    public final String s(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!z()) {
            return bundle.toString();
        }
        StringBuilder n = a.n("Bundle[{");
        for (String str : bundle.keySet()) {
            if (n.length() != 8) {
                n.append(", ");
            }
            n.append(x(str));
            n.append(o0ooo00oo.O0000Oo0);
            if (!aa.b() || !this.f2563a.g.o(q.y0)) {
                n.append(bundle.get(str));
            } else {
                Object obj = bundle.get(str);
                n.append(obj instanceof Bundle ? w(new Object[]{obj}) : obj instanceof Object[] ? w((Object[]) obj) : obj instanceof ArrayList ? w(((ArrayList) obj).toArray()) : String.valueOf(obj));
            }
        }
        n.append("}]");
        return n.toString();
    }

    @Nullable
    public final String t(zzar zzar) {
        if (!z()) {
            return zzar.toString();
        }
        StringBuilder n = a.n("origin=");
        n.append(zzar.f4278c);
        n.append(",name=");
        n.append(u(zzar.f4276a));
        n.append(",params=");
        zzam zzam = zzar.f4277b;
        n.append(zzam == null ? null : !z() ? zzam.toString() : s(zzam.h()));
        return n.toString();
    }

    @Nullable
    public final String u(String str) {
        if (str == null) {
            return null;
        }
        return !z() ? str : v(str, z5.f2664c, z5.f2662a, f2557c);
    }

    @Nullable
    public final String w(Object[] objArr) {
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder n = a.n("[");
        for (Bundle bundle : objArr) {
            String s = bundle instanceof Bundle ? s(bundle) : String.valueOf(bundle);
            if (s != null) {
                if (n.length() != 1) {
                    n.append(", ");
                }
                n.append(s);
            }
        }
        n.append("]");
        return n.toString();
    }

    @Nullable
    public final String x(String str) {
        if (str == null) {
            return null;
        }
        return !z() ? str : v(str, c6.f2129b, c6.f2128a, f2558d);
    }

    @Nullable
    public final String y(String str) {
        if (str == null) {
            return null;
        }
        if (!z()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return v(str, b6.f2101b, b6.f2100a, f2559e);
        }
        return "experiment_id" + "(" + str + ")";
    }

    public final boolean z() {
        return this.f2563a.v() && this.f2563a.i().x(3);
    }
}
