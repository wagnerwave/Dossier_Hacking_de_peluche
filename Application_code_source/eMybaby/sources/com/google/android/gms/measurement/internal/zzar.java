package com.google.android.gms.measurement.internal;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.i.b.o;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public final String f4276a;

    /* renamed from: b  reason: collision with root package name */
    public final zzam f4277b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4278c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4279d;

    public zzar(zzar zzar, long j) {
        b.k(zzar);
        this.f4276a = zzar.f4276a;
        this.f4277b = zzar.f4277b;
        this.f4278c = zzar.f4278c;
        this.f4279d = j;
    }

    public zzar(String str, zzam zzam, String str2, long j) {
        this.f4276a = str;
        this.f4277b = zzam;
        this.f4278c = str2;
        this.f4279d = j;
    }

    public final String toString() {
        String str = this.f4278c;
        String str2 = this.f4276a;
        String valueOf = String.valueOf(this.f4277b);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str2).length() + String.valueOf(str).length() + 21);
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return a.m(sb, ",params=", valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.H0(parcel, 2, this.f4276a, false);
        b.G0(parcel, 3, this.f4277b, i, false);
        b.H0(parcel, 4, this.f4278c, false);
        b.F0(parcel, 5, this.f4279d);
        b.u1(parcel, b2);
    }
}
