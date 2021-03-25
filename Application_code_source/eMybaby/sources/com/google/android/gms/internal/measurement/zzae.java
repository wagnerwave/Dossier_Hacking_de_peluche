package com.google.android.gms.internal.measurement;

import a.c.a.f.b;
import a.d.a.a.h.g.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public final long f4257a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4258b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4259c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4260d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4261e;
    public final String f;
    public final Bundle g;

    public zzae(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f4257a = j;
        this.f4258b = j2;
        this.f4259c = z;
        this.f4260d = str;
        this.f4261e = str2;
        this.f = str3;
        this.g = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.F0(parcel, 1, this.f4257a);
        b.F0(parcel, 2, this.f4258b);
        b.B0(parcel, 3, this.f4259c);
        b.H0(parcel, 4, this.f4260d, false);
        b.H0(parcel, 5, this.f4261e, false);
        b.H0(parcel, 6, this.f, false);
        b.C0(parcel, 7, this.g, false);
        b.u1(parcel, b2);
    }
}
