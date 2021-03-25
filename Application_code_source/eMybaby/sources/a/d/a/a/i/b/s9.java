package a.d.a.a.i.b;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.a1;
import a.d.a.a.h.g.aa;
import a.d.a.a.h.g.b1;
import a.d.a.a.h.g.d1;
import a.d.a.a.h.g.e1;
import a.d.a.a.h.g.f1;
import a.d.a.a.h.g.f6;
import a.d.a.a.h.g.h7;
import a.d.a.a.h.g.j0;
import a.d.a.a.h.g.k0;
import a.d.a.a.h.g.l0;
import a.d.a.a.h.g.l5;
import a.d.a.a.h.g.m0;
import a.d.a.a.h.g.q4;
import a.d.a.a.h.g.v0;
import a.d.a.a.h.g.w0;
import a.d.a.a.h.g.w5;
import a.d.a.a.h.g.x0;
import a.d.a.a.h.g.y5;
import a.d.a.a.h.g.z0;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzn;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.sdk.bean.ProductBean;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class s9 extends m9 {
    public s9(o9 o9Var) {
        super(o9Var);
    }

    public static String A(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static List<Long> B(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List<z0> D(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                z0.a E = z0.E();
                for (String str : bundle.keySet()) {
                    z0.a E2 = z0.E();
                    E2.q(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        E2.o(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        E2.r((String) obj);
                    } else if (obj instanceof Double) {
                        E2.n(((Double) obj).doubleValue());
                    }
                    if (E.f2048c) {
                        E.k();
                        E.f2048c = false;
                    }
                    z0.s((z0) E.f2047b, (z0) ((y5) E2.m()));
                }
                if (((z0) E.f2047b).D() > 0) {
                    arrayList.add((z0) ((y5) E.m()));
                }
            }
        }
        return arrayList;
    }

    public static void H(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(DpTimerBean.FILL);
        }
    }

    public static void J(StringBuilder sb, int i, String str, k0 k0Var) {
        if (k0Var != null) {
            H(sb, i);
            sb.append(str);
            sb.append(" {\n");
            boolean z = true;
            if ((k0Var.zzc & 1) != 0) {
                L(sb, i, "comparison_type", k0Var.s().name());
            }
            if ((k0Var.zzc & 2) != 0) {
                L(sb, i, "match_as_float", Boolean.valueOf(k0Var.zze));
            }
            if ((k0Var.zzc & 4) != 0) {
                L(sb, i, "comparison_value", k0Var.zzf);
            }
            if ((k0Var.zzc & 8) != 0) {
                L(sb, i, "min_comparison_value", k0Var.zzg);
            }
            if ((k0Var.zzc & 16) == 0) {
                z = false;
            }
            if (z) {
                L(sb, i, "max_comparison_value", k0Var.zzh);
            }
            H(sb, i);
            sb.append("}\n");
        }
    }

    public static void K(StringBuilder sb, int i, String str, d1 d1Var) {
        if (d1Var != null) {
            H(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (d1Var.zzd.size() != 0) {
                H(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : d1Var.zzd) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (d1Var.zzc.size() != 0) {
                H(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : d1Var.zzc) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (d1Var.w() != 0) {
                H(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (w0 next : d1Var.zze) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append((next.zzc & 1) != 0 ? Integer.valueOf(next.zzd) : null);
                    sb.append(":");
                    sb.append((next.zzc & 2) != 0 ? Long.valueOf(next.zze) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (d1Var.x() != 0) {
                H(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (e1 next2 : d1Var.zzf) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append((next2.zzc & 1) != 0 ? Integer.valueOf(next2.zzd) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next2.zze) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            H(sb, 3);
            sb.append("}\n");
        }
    }

    public static void L(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            H(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    @WorkerThread
    public static boolean O(zzar zzar, zzn zzn) {
        b.k(zzar);
        b.k(zzn);
        return !TextUtils.isEmpty(zzn.f4286b) || !TextUtils.isEmpty(zzn.r);
    }

    public static boolean P(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean Q(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    public static int s(b1.a aVar, String str) {
        for (int i = 0; i < ((b1) aVar.f2047b).zzg.size(); i++) {
            if (str.equals(((b1) aVar.f2047b).zzg.get(i).zze)) {
                return i;
            }
        }
        return -1;
    }

    public static z0 w(x0 x0Var, String str) {
        for (z0 next : x0Var.zzd) {
            if (next.zzd.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static <Builder extends h7> Builder x(Builder builder, byte[] bArr) {
        Class<l5> cls = l5.class;
        l5 l5Var = l5.f1802c;
        if (l5Var == null) {
            synchronized (cls) {
                l5Var = l5.f1802c;
                if (l5Var == null) {
                    l5Var = w5.b(cls);
                    l5.f1802c = l5Var;
                }
            }
        }
        Builder builder2 = (q4) builder;
        if (l5Var != null) {
            if (builder2 != null) {
                Builder builder3 = (y5.b) builder2;
                builder3.j(bArr, bArr.length, l5Var);
                return builder3;
            }
            throw null;
        } else if (builder2 != null) {
            Builder builder4 = (y5.b) builder2;
            builder4.j(bArr, bArr.length, l5.a());
            return builder4;
        } else {
            throw null;
        }
    }

    public final List<Long> C(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                i().i.b("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    i().i.c("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (next.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    public final void E(x0.a aVar, String str, Object obj) {
        List<z0> s = aVar.s();
        int i = 0;
        while (true) {
            if (i >= s.size()) {
                i = -1;
                break;
            } else if (str.equals(s.get(i).zzd)) {
                break;
            } else {
                i++;
            }
        }
        z0.a E = z0.E();
        E.q(str);
        if (obj instanceof Long) {
            E.o(((Long) obj).longValue());
        } else if (obj instanceof String) {
            E.r((String) obj);
        } else if (obj instanceof Double) {
            E.n(((Double) obj).doubleValue());
        } else if (aa.b() && this.f2563a.g.o(q.A0) && (obj instanceof Bundle[])) {
            E.p(D((Bundle[]) obj));
        }
        if (i >= 0) {
            if (aVar.f2048c) {
                aVar.k();
                aVar.f2048c = false;
            }
            x0 x0Var = (x0) aVar.f2047b;
            z0 z0Var = (z0) ((y5) E.m());
            if (x0Var != null) {
                z0Var.getClass();
                x0Var.D();
                x0Var.zzd.set(i, z0Var);
                return;
            }
            throw null;
        }
        aVar.p(E);
    }

    public final void F(z0.a aVar, Object obj) {
        b.k(obj);
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        z0 z0Var = (z0) aVar.f2047b;
        z0Var.zzc &= -3;
        z0Var.zze = z0.zzj.zze;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        z0 z0Var2 = (z0) aVar.f2047b;
        z0Var2.zzc &= -5;
        z0Var2.zzf = 0;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        z0 z0Var3 = (z0) aVar.f2047b;
        z0Var3.zzc &= -17;
        z0Var3.zzh = 0.0d;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        z0.y((z0) aVar.f2047b);
        if (obj instanceof String) {
            aVar.r((String) obj);
        } else if (obj instanceof Long) {
            aVar.o(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.n(((Double) obj).doubleValue());
        } else if (!aa.b() || !this.f2563a.g.o(q.A0) || !(obj instanceof Bundle[])) {
            i().f.b("Ignoring invalid (type) event param value", obj);
        } else {
            aVar.p(D((Bundle[]) obj));
        }
    }

    public final void G(f1.a aVar, Object obj) {
        b.k(obj);
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        f1 f1Var = (f1) aVar.f2047b;
        f1Var.zzc &= -5;
        f1Var.zzf = f1.zzj.zzf;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        f1 f1Var2 = (f1) aVar.f2047b;
        f1Var2.zzc &= -9;
        f1Var2.zzg = 0;
        if (aVar.f2048c) {
            aVar.k();
            aVar.f2048c = false;
        }
        f1 f1Var3 = (f1) aVar.f2047b;
        f1Var3.zzc &= -33;
        f1Var3.zzi = 0.0d;
        if (obj instanceof String) {
            String str = (String) obj;
            if (aVar.f2048c) {
                aVar.k();
                aVar.f2048c = false;
            }
            f1.t((f1) aVar.f2047b, str);
        } else if (obj instanceof Long) {
            aVar.p(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (aVar.f2048c) {
                aVar.k();
                aVar.f2048c = false;
            }
            f1 f1Var4 = (f1) aVar.f2047b;
            f1Var4.zzc |= 32;
            f1Var4.zzi = doubleValue;
        } else {
            i().f.b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void I(StringBuilder sb, int i, j0 j0Var) {
        if (j0Var != null) {
            H(sb, i);
            sb.append("filter {\n");
            boolean z = false;
            if ((j0Var.zzc & 4) != 0) {
                L(sb, i, "complement", Boolean.valueOf(j0Var.zzf));
            }
            if ((j0Var.zzc & 8) != 0) {
                L(sb, i, "param_name", d().x(j0Var.zzg));
            }
            if (j0Var.t()) {
                int i2 = i + 1;
                m0 u = j0Var.u();
                if (u != null) {
                    H(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if ((u.zzc & 1) != 0) {
                        L(sb, i2, "match_type", u.s().name());
                    }
                    if ((u.zzc & 2) != 0) {
                        L(sb, i2, "expression", u.zze);
                    }
                    if ((u.zzc & 4) != 0) {
                        z = true;
                    }
                    if (z) {
                        L(sb, i2, "case_sensitive", Boolean.valueOf(u.zzf));
                    }
                    if (u.t() > 0) {
                        H(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : u.zzg) {
                            H(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    H(sb, i2);
                    sb.append("}\n");
                }
            }
            if (j0Var.v()) {
                J(sb, i + 1, "number_filter", j0Var.w());
            }
            H(sb, i);
            sb.append("}\n");
        }
    }

    public final void M(StringBuilder sb, int i, List<z0> list) {
        if (list != null) {
            int i2 = i + 1;
            for (z0 next : list) {
                if (next != null) {
                    H(sb, i2);
                    sb.append("param {\n");
                    Double d2 = null;
                    if (!aa.b() || !this.f2563a.g.o(q.y0)) {
                        L(sb, i2, "name", d().x(next.zzd));
                        L(sb, i2, "string_value", next.zze);
                        L(sb, i2, "int_value", next.z() ? Long.valueOf(next.zzf) : null);
                        if (next.B()) {
                            d2 = Double.valueOf(next.zzh);
                        }
                        L(sb, i2, "double_value", d2);
                    } else {
                        L(sb, i2, "name", (next.zzc & 1) != 0 ? d().x(next.zzd) : null);
                        L(sb, i2, "string_value", next.w() ? next.zze : null);
                        L(sb, i2, "int_value", next.z() ? Long.valueOf(next.zzf) : null);
                        if (next.B()) {
                            d2 = Double.valueOf(next.zzh);
                        }
                        L(sb, i2, "double_value", d2);
                        if (next.D() > 0) {
                            M(sb, i2, next.zzi);
                        }
                    }
                    H(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    public final boolean N(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        if (((c) this.f2563a.n) == null) {
            throw null;
        } else if (Math.abs(System.currentTimeMillis() - j) > j2) {
            return true;
        } else {
            return false;
        }
    }

    public final Object R(x0 x0Var, String str) {
        z0 w = w(x0Var, str);
        if (w == null) {
            return null;
        }
        if (w.w()) {
            return w.zze;
        }
        if (w.z()) {
            return Long.valueOf(w.zzf);
        }
        if (w.B()) {
            return Double.valueOf(w.zzh);
        }
        if (!aa.b() || !this.f2563a.g.o(q.A0) || w.D() <= 0) {
            return null;
        }
        f6<z0> f6Var = w.zzi;
        ArrayList arrayList = new ArrayList();
        for (z0 next : f6Var) {
            if (next != null) {
                Bundle bundle = new Bundle();
                for (z0 next2 : next.zzi) {
                    if (next2.w()) {
                        bundle.putString(next2.zzd, next2.zze);
                    } else if (next2.z()) {
                        bundle.putLong(next2.zzd, next2.zzf);
                    } else if (next2.B()) {
                        bundle.putDouble(next2.zzd, next2.zzh);
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final byte[] S(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            i().f.b("Failed to ungzip content", e2);
            throw e2;
        }
    }

    public final byte[] T(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            i().f.b("Failed to gzip content", e2);
            throw e2;
        }
    }

    @Nullable
    public final List<Integer> U() {
        Map<String, String> c2 = q.c(this.f2386b.j.f2123a);
        if (c2 == null || c2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = q.P.a(null).intValue();
        Iterator<Map.Entry<String, String>> it = c2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            i().i.b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    i().i.b("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final long t(byte[] bArr) {
        b.k(bArr);
        e().b();
        MessageDigest y0 = v9.y0();
        if (y0 != null) {
            return v9.w(y0.digest(bArr));
        }
        i().f.a("Failed to get MD5");
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        i().f.a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T u(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ a -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ a -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ a -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ a -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ a -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002b
        L_0x001c:
            a.d.a.a.i.b.x3 r5 = r4.i()     // Catch:{ all -> 0x001a }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002b:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.s9.u(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    public final x0 v(j jVar) {
        x0.a C = x0.C();
        C.v(jVar.f2288e);
        zzam zzam = jVar.f;
        if (zzam != null) {
            for (String str : zzam.f4275a.keySet()) {
                z0.a E = z0.E();
                E.q(str);
                F(E, jVar.f.e(str));
                C.p(E);
            }
            return (x0) ((y5) C.m());
        }
        throw null;
    }

    public final String y(l0 l0Var) {
        StringBuilder n = a.n("\nproperty_filter {\n");
        if (l0Var.t()) {
            L(n, 0, "filter_id", Integer.valueOf(l0Var.zzd));
        }
        L(n, 0, "property_name", d().y(l0Var.zze));
        String A = A(l0Var.zzg, l0Var.zzh, l0Var.zzi);
        if (!A.isEmpty()) {
            L(n, 0, "filter_type", A);
        }
        j0 j0Var = l0Var.zzf;
        if (j0Var == null) {
            j0Var = j0.zzh;
        }
        I(n, 1, j0Var);
        n.append("}\n");
        return n.toString();
    }

    public final String z(a1 a1Var) {
        StringBuilder n = a.n("\nbatch {\n");
        for (b1 next : a1Var.zzc) {
            if (next != null) {
                H(n, 1);
                n.append("bundle {\n");
                if ((next.zzc & 1) != 0) {
                    L(n, 1, "protocol_version", Integer.valueOf(next.zze));
                }
                L(n, 1, TuyaApiParams.KEY_PLATFORM, next.zzm);
                if ((next.zzc & 16384) != 0) {
                    L(n, 1, "gmp_version", Long.valueOf(next.zzu));
                }
                if ((next.zzc & 32768) != 0) {
                    L(n, 1, "uploading_gmp_version", Long.valueOf(next.zzv));
                }
                if ((next.zzd & 16) != 0) {
                    L(n, 1, "dynamite_version", Long.valueOf(next.zzas));
                }
                if ((next.zzc & 536870912) != 0) {
                    L(n, 1, "config_version", Long.valueOf(next.zzak));
                }
                L(n, 1, "gmp_app_id", next.zzac);
                L(n, 1, "admob_app_id", next.zzap);
                L(n, 1, "app_id", next.zzs);
                L(n, 1, "app_version", next.zzt);
                if ((next.zzc & ProductBean.ATTR_HONGWAI_SUB) != 0) {
                    L(n, 1, "app_version_major", Integer.valueOf(next.zzag));
                }
                L(n, 1, "firebase_instance_id", next.zzaf);
                if ((next.zzc & 524288) != 0) {
                    L(n, 1, "dev_cert_hash", Long.valueOf(next.zzz));
                }
                L(n, 1, "app_store", next.zzr);
                if ((next.zzc & 2) != 0) {
                    L(n, 1, "upload_timestamp_millis", Long.valueOf(next.zzh));
                }
                if ((next.zzc & 4) != 0) {
                    L(n, 1, "start_timestamp_millis", Long.valueOf(next.zzi));
                }
                if ((next.zzc & 8) != 0) {
                    L(n, 1, "end_timestamp_millis", Long.valueOf(next.zzj));
                }
                if ((next.zzc & 16) != 0) {
                    L(n, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(next.zzk));
                }
                if ((next.zzc & 32) != 0) {
                    L(n, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(next.zzl));
                }
                L(n, 1, "app_instance_id", next.zzy);
                L(n, 1, "resettable_device_id", next.zzw);
                L(n, 1, oOO0O0O0.O0000Oo0, next.zzaj);
                L(n, 1, "ds_id", next.zzam);
                if ((next.zzc & 131072) != 0) {
                    L(n, 1, "limited_ad_tracking", Boolean.valueOf(next.zzx));
                }
                L(n, 1, "os_version", next.zzn);
                L(n, 1, "device_model", next.zzo);
                L(n, 1, "user_default_language", next.zzp);
                if ((next.zzc & 1024) != 0) {
                    L(n, 1, "time_zone_offset_minutes", Integer.valueOf(next.zzq));
                }
                if ((next.zzc & 1048576) != 0) {
                    L(n, 1, "bundle_sequential_index", Integer.valueOf(next.zzaa));
                }
                if ((next.zzc & 8388608) != 0) {
                    L(n, 1, "service_upload", Boolean.valueOf(next.zzad));
                }
                L(n, 1, "health_monitor", next.zzab);
                if (!this.f2563a.g.o(q.G0)) {
                    if ((next.zzc & 1073741824) != 0) {
                        long j = next.zzal;
                        if (j != 0) {
                            L(n, 1, "android_id", Long.valueOf(j));
                        }
                    }
                }
                if ((next.zzd & 2) != 0) {
                    L(n, 1, "retry_counter", Integer.valueOf(next.zzao));
                }
                if ((next.zzd & 128) != 0) {
                    L(n, 1, "consent_signals", next.zzav);
                }
                f6<f1> f6Var = next.zzg;
                if (f6Var != null) {
                    for (f1 next2 : f6Var) {
                        if (next2 != null) {
                            H(n, 2);
                            n.append("user_property {\n");
                            Double d2 = null;
                            L(n, 2, "set_timestamp_millis", (next2.zzc & 1) != 0 ? Long.valueOf(next2.zzd) : null);
                            L(n, 2, "name", d().y(next2.zze));
                            L(n, 2, "string_value", next2.zzf);
                            L(n, 2, "int_value", (next2.zzc & 8) != 0 ? Long.valueOf(next2.zzg) : null);
                            if ((next2.zzc & 32) != 0) {
                                d2 = Double.valueOf(next2.zzi);
                            }
                            L(n, 2, "double_value", d2);
                            H(n, 2);
                            n.append("}\n");
                        }
                    }
                }
                f6<v0> f6Var2 = next.zzae;
                if (f6Var2 != null) {
                    for (v0 next3 : f6Var2) {
                        if (next3 != null) {
                            H(n, 2);
                            n.append("audience_membership {\n");
                            if ((next3.zzc & 1) != 0) {
                                L(n, 2, "audience_id", Integer.valueOf(next3.zzd));
                            }
                            if ((next3.zzc & 8) != 0) {
                                L(n, 2, "new_audience", Boolean.valueOf(next3.zzg));
                            }
                            d1 d1Var = next3.zze;
                            if (d1Var == null) {
                                d1Var = d1.zzg;
                            }
                            K(n, 2, "current_data", d1Var);
                            if ((next3.zzc & 4) != 0) {
                                d1 d1Var2 = next3.zzf;
                                if (d1Var2 == null) {
                                    d1Var2 = d1.zzg;
                                }
                                K(n, 2, "previous_data", d1Var2);
                            }
                            H(n, 2);
                            n.append("}\n");
                        }
                    }
                }
                f6<x0> f6Var3 = next.zzf;
                if (f6Var3 != null) {
                    for (x0 next4 : f6Var3) {
                        if (next4 != null) {
                            H(n, 2);
                            n.append("event {\n");
                            L(n, 2, "name", d().u(next4.zze));
                            if (next4.A()) {
                                L(n, 2, "timestamp_millis", Long.valueOf(next4.zzf));
                            }
                            if ((next4.zzc & 4) != 0) {
                                L(n, 2, "previous_timestamp_millis", Long.valueOf(next4.zzg));
                            }
                            if ((next4.zzc & 8) != 0) {
                                L(n, 2, "count", Integer.valueOf(next4.zzh));
                            }
                            if (next4.zzd.size() != 0) {
                                M(n, 2, next4.zzd);
                            }
                            H(n, 2);
                            n.append("}\n");
                        }
                    }
                }
                H(n, 1);
                n.append("}\n");
            }
        }
        n.append("}\n");
        return n.toString();
    }
}
