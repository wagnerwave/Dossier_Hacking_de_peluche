package a.d.a.a.i.b;

import a.c.a.f.b;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f2333a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2334b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2335c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2336d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2337e;
    public final long f;
    public final long g;
    public final Long h;
    public final Long i;
    public final Long j;
    public final Boolean k;

    public l(String str, String str2, long j2) {
        this(str, str2, 0, 0, 0, j2, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
    }

    public l(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, Long l3, Boolean bool) {
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j6;
        b.h(str);
        b.h(str2);
        boolean z = true;
        b.d(j7 >= 0);
        b.d(j8 >= 0);
        b.d(j9 >= 0);
        b.d(j10 < 0 ? false : z);
        this.f2333a = str;
        this.f2334b = str2;
        this.f2335c = j7;
        this.f2336d = j8;
        this.f2337e = j9;
        this.f = j5;
        this.g = j10;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    public final l a(long j2) {
        return new l(this.f2333a, this.f2334b, this.f2335c, this.f2336d, this.f2337e, j2, this.g, this.h, this.i, this.j, this.k);
    }

    public final l b(long j2, long j3) {
        return new l(this.f2333a, this.f2334b, this.f2335c, this.f2336d, this.f2337e, this.f, j2, Long.valueOf(j3), this.i, this.j, this.k);
    }

    public final l c(Long l, Long l2, Boolean bool) {
        return new l(this.f2333a, this.f2334b, this.f2335c, this.f2336d, this.f2337e, this.f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
