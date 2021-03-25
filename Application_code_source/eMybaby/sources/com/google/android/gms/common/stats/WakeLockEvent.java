package com.google.android.gms.common.stats;

import a.c.a.f.b;
import a.d.a.a.e.p.d;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public final int f4238a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4239b;

    /* renamed from: c  reason: collision with root package name */
    public int f4240c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4241d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4242e;
    public final String f;
    public final int g;
    public final List<String> h;
    public final String i;
    public final long j;
    public int k;
    public final String l;
    public final float m;
    public final long n;
    public final boolean o;
    public long p = -1;

    public WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this.f4238a = i2;
        this.f4239b = j2;
        this.f4240c = i3;
        this.f4241d = str;
        this.f4242e = str3;
        this.f = str5;
        this.g = i4;
        this.h = list;
        this.i = str2;
        this.j = j3;
        this.k = i5;
        this.l = str4;
        this.m = f2;
        this.n = j4;
        this.o = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4238a);
        b.F0(parcel, 2, this.f4239b);
        b.H0(parcel, 4, this.f4241d, false);
        b.E0(parcel, 5, this.g);
        List<String> list = this.h;
        if (list != null) {
            int P0 = b.P0(parcel, 6);
            parcel.writeStringList(list);
            b.u1(parcel, P0);
        }
        b.F0(parcel, 8, this.j);
        b.H0(parcel, 10, this.f4242e, false);
        b.E0(parcel, 11, this.f4240c);
        b.H0(parcel, 12, this.i, false);
        b.H0(parcel, 13, this.l, false);
        b.E0(parcel, 14, this.k);
        float f2 = this.m;
        b.v1(parcel, 15, 4);
        parcel.writeFloat(f2);
        b.F0(parcel, 16, this.n);
        b.H0(parcel, 17, this.f, false);
        b.B0(parcel, 18, this.o);
        b.u1(parcel, b2);
    }
}
