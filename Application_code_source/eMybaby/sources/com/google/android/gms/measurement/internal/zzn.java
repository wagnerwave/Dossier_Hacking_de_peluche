package com.google.android.gms.measurement.internal;

import a.c.a.f.b;
import a.d.a.a.i.b.aa;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new aa();

    /* renamed from: a  reason: collision with root package name */
    public final String f4285a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4286b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4287c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4288d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4289e;
    public final long f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final long j;
    public final String k;
    public final long l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Boolean s;
    public final long t;
    public final List<String> u;
    public final String v;
    public final String w;

    public zzn(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8, String str9) {
        b.h(str);
        this.f4285a = str;
        this.f4286b = TextUtils.isEmpty(str2) ? null : str2;
        this.f4287c = str3;
        this.j = j2;
        this.f4288d = str4;
        this.f4289e = j3;
        this.f = j4;
        this.g = str5;
        this.h = z;
        this.i = z2;
        this.k = str6;
        this.l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
        this.v = str8;
        this.w = str9;
    }

    public zzn(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z, boolean z2, long j4, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list, String str8, String str9) {
        this.f4285a = str;
        this.f4286b = str2;
        this.f4287c = str3;
        this.j = j4;
        this.f4288d = str4;
        this.f4289e = j2;
        this.f = j3;
        this.g = str5;
        this.h = z;
        this.i = z2;
        this.k = str6;
        this.l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
        this.v = str8;
        this.w = str9;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.H0(parcel, 2, this.f4285a, false);
        b.H0(parcel, 3, this.f4286b, false);
        b.H0(parcel, 4, this.f4287c, false);
        b.H0(parcel, 5, this.f4288d, false);
        b.F0(parcel, 6, this.f4289e);
        b.F0(parcel, 7, this.f);
        b.H0(parcel, 8, this.g, false);
        b.B0(parcel, 9, this.h);
        b.B0(parcel, 10, this.i);
        b.F0(parcel, 11, this.j);
        b.H0(parcel, 12, this.k, false);
        b.F0(parcel, 13, this.l);
        b.F0(parcel, 14, this.m);
        b.E0(parcel, 15, this.n);
        b.B0(parcel, 16, this.o);
        b.B0(parcel, 17, this.p);
        b.B0(parcel, 18, this.q);
        b.H0(parcel, 19, this.r, false);
        Boolean bool = this.s;
        if (bool != null) {
            b.v1(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        b.F0(parcel, 22, this.t);
        List<String> list = this.u;
        if (list != null) {
            int P0 = b.P0(parcel, 23);
            parcel.writeStringList(list);
            b.u1(parcel, P0);
        }
        b.H0(parcel, 24, this.v, false);
        b.H0(parcel, 25, this.w, false);
        b.u1(parcel, b2);
    }
}
