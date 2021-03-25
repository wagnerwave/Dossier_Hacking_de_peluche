package com.google.android.gms.signin.internal;

import a.c.a.f.b;
import a.d.a.a.j.b.i;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public final int f4301a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectionResult f4302b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ResolveAccountResponse f4303c;

    public zak() {
        ConnectionResult connectionResult = new ConnectionResult(8, (PendingIntent) null);
        this.f4301a = 1;
        this.f4302b = connectionResult;
        this.f4303c = null;
    }

    public zak(int i, ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this.f4301a = i;
        this.f4302b = connectionResult;
        this.f4303c = resolveAccountResponse;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4301a);
        b.G0(parcel, 2, this.f4302b, i, false);
        b.G0(parcel, 3, this.f4303c, i, false);
        b.u1(parcel, b2);
    }
}
