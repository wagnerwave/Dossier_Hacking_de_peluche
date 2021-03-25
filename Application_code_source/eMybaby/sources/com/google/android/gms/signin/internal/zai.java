package com.google.android.gms.signin.internal;

import a.c.a.f.b;
import a.d.a.a.j.b.h;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public final int f4299a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveAccountRequest f4300b;

    public zai(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f4299a = i;
        this.f4300b = resolveAccountRequest;
    }

    public zai(ResolveAccountRequest resolveAccountRequest) {
        this.f4299a = 1;
        this.f4300b = resolveAccountRequest;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4299a);
        b.G0(parcel, 2, this.f4300b, i, false);
        b.u1(parcel, b2);
    }
}
