package com.google.android.gms.common.internal;

import a.c.a.f.b;
import a.d.a.a.e.m.e0;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new e0();

    /* renamed from: a  reason: collision with root package name */
    public final int f4231a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4232b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4233c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public final Scope[] f4234d;

    public SignInButtonConfig(int i, int i2) {
        this.f4231a = 1;
        this.f4232b = i;
        this.f4233c = i2;
        this.f4234d = null;
    }

    public SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f4231a = i;
        this.f4232b = i2;
        this.f4233c = i3;
        this.f4234d = scopeArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4231a);
        b.E0(parcel, 2, this.f4232b);
        b.E0(parcel, 3, this.f4233c);
        b.I0(parcel, 4, this.f4234d, i, false);
        b.u1(parcel, b2);
    }
}
