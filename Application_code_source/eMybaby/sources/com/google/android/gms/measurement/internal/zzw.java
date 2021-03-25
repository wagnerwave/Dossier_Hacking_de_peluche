package com.google.android.gms.measurement.internal;

import a.c.a.f.b;
import a.d.a.a.i.b.la;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new la();

    /* renamed from: a  reason: collision with root package name */
    public String f4290a;

    /* renamed from: b  reason: collision with root package name */
    public String f4291b;

    /* renamed from: c  reason: collision with root package name */
    public zzkw f4292c;

    /* renamed from: d  reason: collision with root package name */
    public long f4293d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4294e;
    public String f;
    public zzar g;
    public long h;
    public zzar i;
    public long j;
    public zzar k;

    public zzw(zzw zzw) {
        b.k(zzw);
        this.f4290a = zzw.f4290a;
        this.f4291b = zzw.f4291b;
        this.f4292c = zzw.f4292c;
        this.f4293d = zzw.f4293d;
        this.f4294e = zzw.f4294e;
        this.f = zzw.f;
        this.g = zzw.g;
        this.h = zzw.h;
        this.i = zzw.i;
        this.j = zzw.j;
        this.k = zzw.k;
    }

    public zzw(String str, String str2, zzkw zzkw, long j2, boolean z, String str3, zzar zzar, long j3, zzar zzar2, long j4, zzar zzar3) {
        this.f4290a = str;
        this.f4291b = str2;
        this.f4292c = zzkw;
        this.f4293d = j2;
        this.f4294e = z;
        this.f = str3;
        this.g = zzar;
        this.h = j3;
        this.i = zzar2;
        this.j = j4;
        this.k = zzar3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.H0(parcel, 2, this.f4290a, false);
        b.H0(parcel, 3, this.f4291b, false);
        b.G0(parcel, 4, this.f4292c, i2, false);
        b.F0(parcel, 5, this.f4293d);
        b.B0(parcel, 6, this.f4294e);
        b.H0(parcel, 7, this.f, false);
        b.G0(parcel, 8, this.g, i2, false);
        b.F0(parcel, 9, this.h);
        b.G0(parcel, 10, this.i, i2, false);
        b.F0(parcel, 11, this.j);
        b.G0(parcel, 12, this.k, i2, false);
        b.u1(parcel, b2);
    }
}
