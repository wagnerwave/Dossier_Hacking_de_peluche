package com.google.android.gms.auth.api.signin.internal;

import a.d.a.a.c.a.d.c.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f4179a;

    /* renamed from: b  reason: collision with root package name */
    public int f4180b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f4181c;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.f4179a = i;
        this.f4180b = i2;
        this.f4181c = bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = a.c.a.f.b.b(parcel);
        a.c.a.f.b.E0(parcel, 1, this.f4179a);
        a.c.a.f.b.E0(parcel, 2, this.f4180b);
        a.c.a.f.b.C0(parcel, 3, this.f4181c, false);
        a.c.a.f.b.u1(parcel, b2);
    }
}
