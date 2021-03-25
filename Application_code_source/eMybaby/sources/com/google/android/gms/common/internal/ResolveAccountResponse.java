package com.google.android.gms.common.internal;

import a.c.a.f.b;
import a.d.a.a.e.m.d0;
import a.d.a.a.e.m.j;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new d0();

    /* renamed from: a  reason: collision with root package name */
    public final int f4226a;

    /* renamed from: b  reason: collision with root package name */
    public IBinder f4227b;

    /* renamed from: c  reason: collision with root package name */
    public ConnectionResult f4228c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4229d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4230e;

    public ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f4226a = i;
        this.f4227b = iBinder;
        this.f4228c = connectionResult;
        this.f4229d = z;
        this.f4230e = z2;
    }

    public j e() {
        return j.a.g(this.f4227b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f4228c.equals(resolveAccountResponse.f4228c) && e().equals(resolveAccountResponse.e());
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4226a);
        b.D0(parcel, 2, this.f4227b, false);
        b.G0(parcel, 3, this.f4228c, i, false);
        b.B0(parcel, 4, this.f4229d);
        b.B0(parcel, 5, this.f4230e);
        b.u1(parcel, b2);
    }
}
