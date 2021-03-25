package b.a;

import androidx.core.graphics.PaintCompat;
import b.a.b;
import com.tuya.smart.common.oOO0O0O0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.platform.AndroidPlatform;

public final class a implements Comparable<a>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public Integer f3722a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f3723b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f3724c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f3725d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f3726e;
    public Integer f;
    public Integer g;
    public boolean h = true;
    public int i;

    /* renamed from: b.a.a$a  reason: collision with other inner class name */
    public enum C0089a {
        LastDay,
        FirstDay,
        Spillover,
        Abort
    }

    public static final class b extends RuntimeException {
        public b(String str) {
            super(str);
        }
    }

    public static final class c extends RuntimeException {
        public c(String str) {
            super(str);
        }
    }

    public enum d {
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTE,
        SECOND,
        NANOSECONDS
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.f3722a = num;
        this.f3723b = num2;
        this.f3724c = num3;
        this.f3725d = num4;
        this.f3726e = num5;
        this.f = num6;
        this.g = num7;
        z();
    }

    public static Integer p(Integer num, Integer num2) {
        if (num == null || num2 == null) {
            return null;
        }
        boolean z = true;
        if (num2.intValue() != 1) {
            if (num2.intValue() == 2) {
                int intValue = num.intValue() % 100;
                int intValue2 = num.intValue();
                if (intValue != 0 ? intValue2 % 4 != 0 : intValue2 % 400 != 0) {
                    z = false;
                }
                return Integer.valueOf(z ? 29 : 28);
            } else if (num2.intValue() != 3) {
                if (num2.intValue() != 4) {
                    if (num2.intValue() != 5) {
                        if (num2.intValue() != 6) {
                            if (!(num2.intValue() == 7 || num2.intValue() == 8)) {
                                if (num2.intValue() != 9) {
                                    if (num2.intValue() != 10) {
                                        if (num2.intValue() != 11) {
                                            if (num2.intValue() != 12) {
                                                throw new AssertionError("Month is out of range 1..12:" + num2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return 30;
            }
        }
        return 31;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        throw new java.lang.IllegalArgumentException("This method does not currently support arrays.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r7.n()
            if (r7 != r8) goto L_0x0008
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x0014
        L_0x0008:
            java.lang.Class<b.a.a> r0 = b.a.a.class
            boolean r0 = r0.isInstance(r8)
            if (r0 != 0) goto L_0x0013
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x007e
            b.a.a r8 = (b.a.a) r8
            r8.n()
            java.lang.Object[] r0 = r7.q()
            java.lang.Object[] r8 = r8.q()
            int r1 = r0.length
            int r2 = r8.length
            if (r1 != r2) goto L_0x005c
            r1 = 0
            r2 = 0
        L_0x0029:
            int r3 = r0.length
            r4 = 1
            if (r2 >= r3) goto L_0x0056
            r3 = r0[r2]
            r5 = r8[r2]
            boolean r6 = a.e.a.a.r.b.I(r3)
            if (r6 != 0) goto L_0x004e
            boolean r6 = a.e.a.a.r.b.I(r5)
            if (r6 != 0) goto L_0x004e
            if (r3 != 0) goto L_0x0044
            if (r5 != 0) goto L_0x0042
            goto L_0x0048
        L_0x0042:
            r4 = 0
            goto L_0x0048
        L_0x0044:
            boolean r4 = r3.equals(r5)
        L_0x0048:
            if (r4 != 0) goto L_0x004b
            goto L_0x0057
        L_0x004b:
            int r2 = r2 + 1
            goto L_0x0029
        L_0x004e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "This method does not currently support arrays."
            r8.<init>(r0)
            throw r8
        L_0x0056:
            r1 = 1
        L_0x0057:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            goto L_0x007e
        L_0x005c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Array lengths do not match. 'This' length is "
            java.lang.StringBuilder r2 = a.a.a.a.a.n(r2)
            int r0 = r0.length
            r2.append(r0)
            java.lang.String r0 = ", while 'That' length is "
            r2.append(r0)
            int r8 = r8.length
            r2.append(r8)
            java.lang.String r8 = "."
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8)
            throw r1
        L_0x007e:
            boolean r8 = r0.booleanValue()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.equals(java.lang.Object):boolean");
    }

    public final void f(String str, Object obj, StringBuilder sb) {
        StringBuilder p = a.a.a.a.a.p(str, ":");
        p.append(String.valueOf(obj));
        p.append(" ");
        sb.append(p.toString());
    }

    public final String g() {
        d dVar = d.NANOSECONDS;
        d dVar2 = d.SECOND;
        d dVar3 = d.MINUTE;
        d dVar4 = d.HOUR;
        d dVar5 = d.DAY;
        d dVar6 = d.MONTH;
        d dVar7 = d.YEAR;
        if (y(dVar7)) {
            if (x(dVar6, dVar5, dVar4, dVar3, dVar2, dVar)) {
                return "YYYY";
            }
        }
        if (y(dVar7, dVar6)) {
            if (x(dVar5, dVar4, dVar3, dVar2, dVar)) {
                return "YYYY-MM";
            }
        }
        if (y(dVar7, dVar6, dVar5)) {
            if (x(dVar4, dVar3, dVar2, dVar)) {
                return "YYYY-MM-DD";
            }
        }
        if (y(dVar7, dVar6, dVar5, dVar4)) {
            if (x(dVar3, dVar2, dVar)) {
                return "YYYY-MM-DD hh";
            }
        }
        if (y(dVar7, dVar6, dVar5, dVar4, dVar3)) {
            if (x(dVar2, dVar)) {
                return "YYYY-MM-DD hh:mm";
            }
        }
        if (y(dVar7, dVar6, dVar5, dVar4, dVar3, dVar2)) {
            if (x(dVar)) {
                return "YYYY-MM-DD hh:mm:ss";
            }
        }
        if (y(dVar7, dVar6, dVar5, dVar4, dVar3, dVar2, dVar)) {
            return "YYYY-MM-DD hh:mm:ss.fffffffff";
        }
        if (x(dVar7, dVar6, dVar5)) {
            if (y(dVar4, dVar3, dVar2, dVar)) {
                return "hh:mm:ss.fffffffff";
            }
        }
        if (x(dVar7, dVar6, dVar5, dVar)) {
            if (y(dVar4, dVar3, dVar2)) {
                return "hh:mm:ss";
            }
        }
        if (x(dVar7, dVar6, dVar5, dVar2, dVar)) {
            if (y(dVar4, dVar3)) {
                return "hh:mm";
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.i == 0) {
            n();
            int i2 = 23;
            for (Object F : q()) {
                i2 = a.e.a.a.r.b.F(i2, F);
            }
            this.i = i2;
        }
        return this.i;
    }

    public final int i() {
        int intValue = this.f3722a.intValue();
        int intValue2 = this.f3723b.intValue();
        int i2 = (intValue2 - 14) / 12;
        return (((((((intValue2 - 2) - (i2 * 12)) * 367) / 12) + ((((intValue + 4800) + i2) * 1461) / 4)) - (((((intValue + 4900) + i2) / 100) * 3) / 4)) + this.f3724c.intValue()) - 32075;
    }

    public final void j(Integer num, int i2, int i3, String str) {
        if (num == null) {
            return;
        }
        if (num.intValue() < i2 || num.intValue() > i3) {
            throw new b(str + " is not in the range " + i2 + ".." + i3 + ". Value is:" + num);
        }
    }

    /* renamed from: k */
    public int compareTo(a aVar) {
        if (this == aVar) {
            return 0;
        }
        n();
        aVar.n();
        e eVar = e.FIRST;
        int e2 = a.e.a.a.r.b.e(this.f3722a, aVar.f3722a, eVar);
        if (e2 != 0) {
            return e2;
        }
        int e3 = a.e.a.a.r.b.e(this.f3723b, aVar.f3723b, eVar);
        if (e3 != 0) {
            return e3;
        }
        int e4 = a.e.a.a.r.b.e(this.f3724c, aVar.f3724c, eVar);
        if (e4 != 0) {
            return e4;
        }
        int e5 = a.e.a.a.r.b.e(this.f3725d, aVar.f3725d, eVar);
        if (e5 != 0) {
            return e5;
        }
        int e6 = a.e.a.a.r.b.e(this.f3726e, aVar.f3726e, eVar);
        if (e6 != 0) {
            return e6;
        }
        int e7 = a.e.a.a.r.b.e(this.f, aVar.f, eVar);
        if (e7 != 0) {
            return e7;
        }
        int e8 = a.e.a.a.r.b.e(this.g, aVar.g, eVar);
        if (e8 != 0) {
            return e8;
        }
        return 0;
    }

    public final void m() {
        n();
        if (!y(d.YEAR, d.MONTH, d.DAY)) {
            throw new c("DateTime does not include year/month/day.");
        }
    }

    public void n() {
        if (!this.h) {
            throw new NullPointerException("DateTime string is null");
        }
    }

    public String o(String str) {
        boolean z;
        String str2;
        Integer num;
        String str3;
        Integer num2;
        int i2;
        List list;
        b bVar = new b(str);
        bVar.f3740d = new ArrayList();
        bVar.f3739c = new ArrayList();
        Matcher matcher = b.i.matcher(bVar.f3737a);
        while (matcher.find()) {
            b.c cVar = new b.c((b.a) null);
            cVar.f3742a = matcher.start();
            cVar.f3743b = matcher.end() - 1;
            bVar.f3740d.add(cVar);
        }
        String str4 = bVar.f3737a;
        Iterator<String> it = b.k.iterator();
        while (true) {
            int i3 = 0;
            if (it.hasNext()) {
                String next = it.next();
                Matcher matcher2 = Pattern.compile(next).matcher(str4);
                while (matcher2.find()) {
                    b.d dVar = new b.d((b.a) null);
                    dVar.f3744a = matcher2.start();
                    dVar.f3745b = matcher2.end() - 1;
                    Iterator<b.c> it2 = bVar.f3740d.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        b.c next2 = it2.next();
                        int i4 = next2.f3742a;
                        int i5 = dVar.f3744a;
                        if (i4 <= i5 && i5 <= next2.f3743b) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        String group = matcher2.group();
                        if ("YYYY".equals(group)) {
                            n();
                            num = this.f3722a;
                        } else {
                            if ("YY".equals(group)) {
                                n();
                                String g2 = bVar.g(this.f3722a);
                                if (a.e.a.a.r.b.b0(g2)) {
                                    str2 = g2.substring(2);
                                    dVar.f3746c = str2;
                                    bVar.f3739c.add(dVar);
                                }
                            } else {
                                if ("MMMM".equals(group)) {
                                    n();
                                    str2 = bVar.c(Integer.valueOf(this.f3723b.intValue()));
                                } else {
                                    if ("MMM".equals(group)) {
                                        n();
                                        str3 = bVar.c(Integer.valueOf(this.f3723b.intValue()));
                                    } else {
                                        if ("MM".equals(group)) {
                                            n();
                                            num2 = this.f3723b;
                                        } else if ("M".equals(group)) {
                                            n();
                                            num = this.f3723b;
                                        } else if ("DD".equals(group)) {
                                            n();
                                            num2 = this.f3724c;
                                        } else if ("D".equals(group)) {
                                            n();
                                            num = this.f3724c;
                                        } else if ("WWWW".equals(group)) {
                                            str2 = bVar.d(Integer.valueOf(r().intValue()));
                                        } else if ("WWW".equals(group)) {
                                            str3 = bVar.d(Integer.valueOf(r().intValue()));
                                        } else if ("hh".equals(group)) {
                                            n();
                                            num2 = this.f3725d;
                                        } else if ("h".equals(group)) {
                                            n();
                                            num = this.f3725d;
                                        } else if ("h12".equals(group)) {
                                            n();
                                            num = bVar.f(this.f3725d);
                                        } else if ("hh12".equals(group)) {
                                            n();
                                            num2 = bVar.f(this.f3725d);
                                        } else if ("a".equals(group)) {
                                            n();
                                            Integer valueOf = Integer.valueOf(this.f3725d.intValue());
                                            if (valueOf != null) {
                                                Locale locale = bVar.f3738b;
                                                if (locale != null) {
                                                    if (!bVar.g.containsKey(locale)) {
                                                        ArrayList arrayList = new ArrayList();
                                                        arrayList.add(bVar.e(6));
                                                        arrayList.add(bVar.e(18));
                                                        bVar.g.put(bVar.f3738b, arrayList);
                                                    }
                                                    if (valueOf.intValue() < 12) {
                                                        list = bVar.g.get(bVar.f3738b);
                                                        i2 = 0;
                                                    } else {
                                                        list = bVar.g.get(bVar.f3738b);
                                                        i2 = 1;
                                                    }
                                                    str2 = (String) list.get(i2);
                                                } else {
                                                    StringBuilder n = a.a.a.a.a.n("Your date pattern requires either a Locale, or your own custom localizations for text:");
                                                    n.append(a.e.a.a.r.b.V(bVar.f3737a));
                                                    throw new IllegalArgumentException(n.toString());
                                                }
                                            }
                                        } else if ("mm".equals(group)) {
                                            n();
                                            num2 = this.f3726e;
                                        } else if (PaintCompat.EM_STRING.equals(group)) {
                                            n();
                                            num = this.f3726e;
                                        } else if ("ss".equals(group)) {
                                            n();
                                            num2 = this.f;
                                        } else if ("s".equals(group)) {
                                            n();
                                            num = this.f;
                                        } else if (!group.startsWith("f")) {
                                            throw new IllegalArgumentException(a.a.a.a.a.k("Unknown token in date formatting pattern: ", group));
                                        } else if (b.j.matcher(group).matches()) {
                                            n();
                                            String g3 = bVar.g(this.g);
                                            while (g3.length() < 9) {
                                                g3 = a.a.a.a.a.k(oOO0O0O0.O0000oO0, g3);
                                            }
                                            int length = group.length();
                                            str2 = (!a.e.a.a.r.b.b0(g3) || g3.length() < length) ? g3 : g3.substring(0, length);
                                        } else {
                                            throw new IllegalArgumentException(a.a.a.a.a.k("Unknown token in date formatting pattern: ", group));
                                        }
                                        str2 = bVar.a(bVar.g(num2));
                                    }
                                    str2 = bVar.b(str3);
                                }
                                dVar.f3746c = str2;
                                bVar.f3739c.add(dVar);
                            }
                            str2 = "";
                            dVar.f3746c = str2;
                            bVar.f3739c.add(dVar);
                        }
                        str2 = bVar.g(num);
                        dVar.f3746c = str2;
                        bVar.f3739c.add(dVar);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i6 = 1; i6 <= next.length(); i6++) {
                    sb.append("@");
                }
                str4 = str4.replace(next, sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                while (i3 < bVar.f3737a.length()) {
                    String substring = bVar.f3737a.substring(i3, i3 + 1);
                    b.d dVar2 = null;
                    for (b.d next3 : bVar.f3739c) {
                        if (next3.f3744a == i3) {
                            dVar2 = next3;
                        }
                    }
                    if (dVar2 != null) {
                        sb2.append(dVar2.f3746c);
                        i3 = dVar2.f3745b;
                    } else if (!"|".equals(substring)) {
                        sb2.append(substring);
                    }
                    i3++;
                }
                return sb2.toString();
            }
        }
    }

    public final Object[] q() {
        return new Object[]{this.f3722a, this.f3723b, this.f3724c, this.f3725d, this.f3726e, this.f, this.g};
    }

    public Integer r() {
        m();
        return Integer.valueOf(((i() + 1) % 7) + 1);
    }

    public boolean s(a aVar) {
        return compareTo(aVar) > 0;
    }

    public boolean t(a aVar) {
        return compareTo(aVar) < 0;
    }

    public String toString() {
        if (a.e.a.a.r.b.b0((String) null)) {
            return null;
        }
        if (g() != null) {
            return o(g());
        }
        StringBuilder sb = new StringBuilder();
        f("Y", this.f3722a, sb);
        f("M", this.f3723b, sb);
        f("D", this.f3724c, sb);
        f("h", this.f3725d, sb);
        f(PaintCompat.EM_STRING, this.f3726e, sb);
        f("s", this.f, sb);
        f("f", this.g, sb);
        return sb.toString().trim();
    }

    public a u(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, C0089a aVar) {
        c cVar = new c(this, aVar);
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        int intValue3 = num3.intValue();
        int intValue4 = num4.intValue();
        int intValue5 = num5.intValue();
        int intValue6 = num6.intValue();
        int intValue7 = num7.intValue();
        return cVar.b(false, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue4), Integer.valueOf(intValue5), Integer.valueOf(intValue6), Integer.valueOf(intValue7));
    }

    public a v(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, C0089a aVar) {
        c cVar = new c(this, aVar);
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        int intValue3 = num3.intValue();
        int intValue4 = num4.intValue();
        int intValue5 = num5.intValue();
        int intValue6 = num6.intValue();
        int intValue7 = num7.intValue();
        return cVar.b(true, Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3), Integer.valueOf(intValue4), Integer.valueOf(intValue5), Integer.valueOf(intValue6), Integer.valueOf(intValue7));
    }

    public a w(Integer num) {
        m();
        m();
        int intValue = num.intValue() + Integer.valueOf((i() - 1) - 2400000).intValue() + 1 + 2400000 + 68569;
        int i2 = (intValue * 4) / 146097;
        int i3 = intValue - (((146097 * i2) + 3) / 4);
        int i4 = ((i3 + 1) * AndroidPlatform.MAX_LOG_LENGTH) / 1461001;
        int i5 = (i3 - ((i4 * 1461) / 4)) + 31;
        int i6 = (i5 * 80) / 2447;
        int i7 = i5 - ((i6 * 2447) / 80);
        int i8 = i6 / 11;
        a aVar = new a(Integer.valueOf(((i2 - 49) * 100) + i4 + i8), Integer.valueOf((i6 + 2) - (i8 * 12)), Integer.valueOf(i7), (Integer) null, (Integer) null, (Integer) null, (Integer) null);
        aVar.n();
        Integer num2 = aVar.f3722a;
        aVar.n();
        Integer num3 = aVar.f3723b;
        aVar.n();
        return new a(num2, num3, aVar.f3724c, this.f3725d, this.f3726e, this.f, this.g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r7.f == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r7.f3726e == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r7.f3725d == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        if (r7.f3724c == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        if (r7.f3723b == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        if (r7.f3722a == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r7.g == null) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x(b.a.a.d... r8) {
        /*
            r7 = this;
            r7.n()
            int r0 = r8.length
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x0008:
            if (r3 >= r0) goto L_0x005e
            r5 = r8[r3]
            b.a.a$d r6 = b.a.a.d.NANOSECONDS
            if (r6 != r5) goto L_0x0017
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.g
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x0017:
            b.a.a$d r6 = b.a.a.d.SECOND
            if (r6 != r5) goto L_0x0022
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x0022:
            b.a.a$d r6 = b.a.a.d.MINUTE
            if (r6 != r5) goto L_0x002d
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3726e
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x002d:
            b.a.a$d r6 = b.a.a.d.HOUR
            if (r6 != r5) goto L_0x0038
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3725d
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x0038:
            b.a.a$d r6 = b.a.a.d.DAY
            if (r6 != r5) goto L_0x0043
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3724c
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x0043:
            b.a.a$d r6 = b.a.a.d.MONTH
            if (r6 != r5) goto L_0x004e
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3723b
            if (r4 != 0) goto L_0x005a
            goto L_0x0058
        L_0x004e:
            b.a.a$d r6 = b.a.a.d.YEAR
            if (r6 != r5) goto L_0x005b
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3722a
            if (r4 != 0) goto L_0x005a
        L_0x0058:
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.x(b.a.a$d[]):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r7.f != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r7.f3726e != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r7.f3725d != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        if (r7.f3724c != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        if (r7.f3723b != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        if (r7.f3722a != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r7.g != null) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean y(b.a.a.d... r8) {
        /*
            r7 = this;
            r7.n()
            int r0 = r8.length
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x0008:
            if (r3 >= r0) goto L_0x005e
            r5 = r8[r3]
            b.a.a$d r6 = b.a.a.d.NANOSECONDS
            if (r6 != r5) goto L_0x0017
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.g
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x0017:
            b.a.a$d r6 = b.a.a.d.SECOND
            if (r6 != r5) goto L_0x0022
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x0022:
            b.a.a$d r6 = b.a.a.d.MINUTE
            if (r6 != r5) goto L_0x002d
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3726e
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x002d:
            b.a.a$d r6 = b.a.a.d.HOUR
            if (r6 != r5) goto L_0x0038
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3725d
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x0038:
            b.a.a$d r6 = b.a.a.d.DAY
            if (r6 != r5) goto L_0x0043
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3724c
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x0043:
            b.a.a$d r6 = b.a.a.d.MONTH
            if (r6 != r5) goto L_0x004e
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3723b
            if (r4 == 0) goto L_0x005a
            goto L_0x0058
        L_0x004e:
            b.a.a$d r6 = b.a.a.d.YEAR
            if (r6 != r5) goto L_0x005b
            if (r4 == 0) goto L_0x005a
            java.lang.Integer r4 = r7.f3722a
            if (r4 == 0) goto L_0x005a
        L_0x0058:
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.y(b.a.a$d[]):boolean");
    }

    public final void z() {
        boolean z = true;
        j(this.f3722a, 1, 9999, "Year");
        j(this.f3723b, 1, 12, "Month");
        j(this.f3724c, 1, 31, "Day");
        j(this.f3725d, 0, 23, "Hour");
        j(this.f3726e, 0, 59, "Minute");
        j(this.f, 0, 59, "Second");
        j(this.g, 0, 999999999, "Nanosecond");
        Integer num = this.f3722a;
        Integer num2 = this.f3723b;
        Integer num3 = this.f3724c;
        Object[] objArr = {num, num2, num3};
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            } else if (objArr[i2] == null) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z && num3.intValue() > p(num, num2).intValue()) {
            throw new b("The day-of-the-month value '" + num3 + "' exceeds the number of days in the month: " + p(num, num2));
        }
    }
}
