package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.h.g.k0;
import a.d.a.a.h.g.m0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class ia {

    /* renamed from: a  reason: collision with root package name */
    public String f2279a;

    /* renamed from: b  reason: collision with root package name */
    public int f2280b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f2281c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f2282d;

    /* renamed from: e  reason: collision with root package name */
    public Long f2283e;
    public Long f;

    public ia(String str, int i) {
        this.f2279a = str;
        this.f2280b = i;
    }

    public static Boolean b(long j, k0 k0Var) {
        try {
            return f(new BigDecimal(j), k0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean c(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public static Boolean d(String str, k0 k0Var) {
        if (!s9.P(str)) {
            return null;
        }
        try {
            return f(new BigDecimal(str), k0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean e(String str, m0 m0Var, x3 x3Var) {
        String str2;
        List<String> list;
        boolean z;
        m0.b bVar = m0.b.REGEXP;
        b.k(m0Var);
        if (str == null) {
            return null;
        }
        boolean z2 = true;
        int i = 0;
        if (!((m0Var.zzc & 1) != 0) || m0Var.s() == m0.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (m0Var.s() != m0.b.IN_LIST) {
            if ((m0Var.zzc & 2) == 0) {
                z2 = false;
            }
            if (!z2) {
                return null;
            }
        } else if (m0Var.t() == 0) {
            return null;
        }
        m0.b s = m0Var.s();
        boolean z3 = m0Var.zzf;
        if (z3 || s == bVar || s == m0.b.IN_LIST) {
            str2 = m0Var.zze;
        } else {
            str2 = m0Var.zze.toUpperCase(Locale.ENGLISH);
        }
        if (m0Var.t() == 0) {
            list = null;
        } else {
            list = m0Var.zzg;
            if (!z3) {
                ArrayList arrayList = new ArrayList(list.size());
                for (String upperCase : list) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                list = Collections.unmodifiableList(arrayList);
            }
        }
        String str3 = s == bVar ? str2 : null;
        if (s == m0.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z3 && s != bVar) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (ea.f2175a[s.ordinal()]) {
            case 1:
                if (!z3) {
                    i = 66;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (x3Var == null) {
                        return null;
                    }
                    x3Var.i.b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                z = str.startsWith(str2);
                break;
            case 3:
                z = str.endsWith(str2);
                break;
            case 4:
                z = str.contains(str2);
                break;
            case 5:
                z = str.equals(str2);
                break;
            case 6:
                z = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (((r11.zzc & 16) != 0) == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008d, code lost:
        if (r4 != null) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean f(java.math.BigDecimal r10, a.d.a.a.h.g.k0 r11, double r12) {
        /*
            a.c.a.f.b.k(r11)
            int r0 = r11.zzc
            r1 = 1
            r0 = r0 & r1
            r2 = 0
            if (r0 == 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            r3 = 0
            if (r0 == 0) goto L_0x011b
            a.d.a.a.h.g.k0$a r0 = r11.s()
            a.d.a.a.h.g.k0$a r4 = a.d.a.a.h.g.k0.a.UNKNOWN_COMPARISON_TYPE
            if (r0 != r4) goto L_0x001a
            goto L_0x011b
        L_0x001a:
            a.d.a.a.h.g.k0$a r0 = r11.s()
            a.d.a.a.h.g.k0$a r4 = a.d.a.a.h.g.k0.a.BETWEEN
            r5 = 4
            if (r0 != r4) goto L_0x003a
            int r0 = r11.zzc
            r0 = r0 & 8
            if (r0 == 0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 == 0) goto L_0x0039
            int r0 = r11.zzc
            r0 = r0 & 16
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0045
        L_0x0039:
            return r3
        L_0x003a:
            int r0 = r11.zzc
            r0 = r0 & r5
            if (r0 == 0) goto L_0x0041
            r0 = 1
            goto L_0x0042
        L_0x0041:
            r0 = 0
        L_0x0042:
            if (r0 != 0) goto L_0x0045
            return r3
        L_0x0045:
            a.d.a.a.h.g.k0$a r0 = r11.s()
            a.d.a.a.h.g.k0$a r4 = r11.s()
            a.d.a.a.h.g.k0$a r6 = a.d.a.a.h.g.k0.a.BETWEEN
            if (r4 != r6) goto L_0x0074
            java.lang.String r4 = r11.zzg
            boolean r4 = a.d.a.a.i.b.s9.P(r4)
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = r11.zzh
            boolean r4 = a.d.a.a.i.b.s9.P(r4)
            if (r4 != 0) goto L_0x0062
            goto L_0x0073
        L_0x0062:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0073 }
            java.lang.String r6 = r11.zzg     // Catch:{ NumberFormatException -> 0x0073 }
            r4.<init>(r6)     // Catch:{ NumberFormatException -> 0x0073 }
            java.math.BigDecimal r6 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0073 }
            java.lang.String r11 = r11.zzh     // Catch:{ NumberFormatException -> 0x0073 }
            r6.<init>(r11)     // Catch:{ NumberFormatException -> 0x0073 }
            r11 = r4
            r4 = r3
            goto L_0x0086
        L_0x0073:
            return r3
        L_0x0074:
            java.lang.String r4 = r11.zzf
            boolean r4 = a.d.a.a.i.b.s9.P(r4)
            if (r4 != 0) goto L_0x007d
            return r3
        L_0x007d:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x011b }
            java.lang.String r11 = r11.zzf     // Catch:{ NumberFormatException -> 0x011b }
            r4.<init>(r11)     // Catch:{ NumberFormatException -> 0x011b }
            r11 = r3
            r6 = r11
        L_0x0086:
            a.d.a.a.h.g.k0$a r7 = a.d.a.a.h.g.k0.a.BETWEEN
            if (r0 != r7) goto L_0x008d
            if (r11 != 0) goto L_0x008f
            return r3
        L_0x008d:
            if (r4 == 0) goto L_0x011b
        L_0x008f:
            int[] r7 = a.d.a.a.i.b.ea.f2176b
            int r0 = r0.ordinal()
            r0 = r7[r0]
            r7 = -1
            if (r0 == r1) goto L_0x010e
            r8 = 2
            if (r0 == r8) goto L_0x0101
            r9 = 3
            if (r0 == r9) goto L_0x00b7
            if (r0 == r5) goto L_0x00a4
            goto L_0x011b
        L_0x00a4:
            int r11 = r10.compareTo(r11)
            if (r11 == r7) goto L_0x00b1
            int r10 = r10.compareTo(r6)
            if (r10 == r1) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x00b7:
            r5 = 0
            int r11 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r11 == 0) goto L_0x00f4
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r0)
            java.math.BigDecimal r11 = r4.subtract(r11)
            int r11 = r10.compareTo(r11)
            if (r11 != r1) goto L_0x00ee
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r12)
            java.math.BigDecimal r11 = r4.add(r11)
            int r10 = r10.compareTo(r11)
            if (r10 != r7) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r1 = 0
        L_0x00ef:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x00f4:
            int r10 = r10.compareTo(r4)
            if (r10 != 0) goto L_0x00fb
            goto L_0x00fc
        L_0x00fb:
            r1 = 0
        L_0x00fc:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x0101:
            int r10 = r10.compareTo(r4)
            if (r10 != r1) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r1 = 0
        L_0x0109:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x010e:
            int r10 = r10.compareTo(r4)
            if (r10 != r7) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r1 = 0
        L_0x0116:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            return r10
        L_0x011b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.ia.f(java.math.BigDecimal, a.d.a.a.h.g.k0, double):java.lang.Boolean");
    }

    public abstract int a();

    public abstract boolean g();

    public abstract boolean h();
}
