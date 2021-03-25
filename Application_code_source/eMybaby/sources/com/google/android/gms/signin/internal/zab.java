package com.google.android.gms.signin.internal;

import a.d.a.a.e.k.i;
import a.d.a.a.j.b.b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zab extends AbstractSafeParcelable implements i {
    public static final Parcelable.Creator<zab> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f4296a;

    /* renamed from: b  reason: collision with root package name */
    public int f4297b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Intent f4298c;

    public zab() {
        this.f4296a = 2;
        this.f4297b = 0;
        this.f4298c = null;
    }

    public zab(int i, int i2, @Nullable Intent intent) {
        this.f4296a = i;
        this.f4297b = i2;
        this.f4298c = intent;
    }

    public final Status getStatus() {
        return this.f4297b == 0 ? Status.f4205e : Status.i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = a.c.a.f.b.b(parcel);
        a.c.a.f.b.E0(parcel, 1, this.f4296a);
        a.c.a.f.b.E0(parcel, 2, this.f4297b);
        a.c.a.f.b.G0(parcel, 3, this.f4298c, i, false);
        a.c.a.f.b.u1(parcel, b2);
    }
}
