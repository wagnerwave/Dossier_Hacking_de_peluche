package com.google.android.gms.common.internal;

import a.c.a.f.b;
import a.d.a.a.e.m.f0;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new f0();

    /* renamed from: a  reason: collision with root package name */
    public Bundle f4235a;

    /* renamed from: b  reason: collision with root package name */
    public Feature[] f4236b;

    /* renamed from: c  reason: collision with root package name */
    public int f4237c;

    public zza() {
    }

    public zza(Bundle bundle, Feature[] featureArr, int i) {
        this.f4235a = bundle;
        this.f4236b = featureArr;
        this.f4237c = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.C0(parcel, 1, this.f4235a, false);
        b.I0(parcel, 2, this.f4236b, i, false);
        b.E0(parcel, 3, this.f4237c);
        b.u1(parcel, b2);
    }
}
