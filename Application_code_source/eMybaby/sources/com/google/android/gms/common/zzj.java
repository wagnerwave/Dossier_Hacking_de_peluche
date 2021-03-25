package com.google.android.gms.common;

import a.d.a.a.e.d0;
import a.d.a.a.e.v;
import a.d.a.a.e.y;
import a.d.a.a.f.a;
import a.d.a.a.f.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import javax.annotation.Nullable;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new d0();

    /* renamed from: a  reason: collision with root package name */
    public final String f4243a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final v f4244b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4245c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4246d;

    public zzj(String str, @Nullable v vVar, boolean z, boolean z2) {
        this.f4243a = str;
        this.f4244b = vVar;
        this.f4245c = z;
        this.f4246d = z2;
    }

    public zzj(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.f4243a = str;
        y yVar = null;
        if (iBinder != null) {
            try {
                a b2 = v.U(iBinder).b();
                byte[] bArr = b2 == null ? null : (byte[]) b.h(b2);
                if (bArr != null) {
                    yVar = new y(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e2) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            }
        }
        this.f4244b = yVar;
        this.f4245c = z;
        this.f4246d = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = a.c.a.f.b.b(parcel);
        a.c.a.f.b.H0(parcel, 1, this.f4243a, false);
        v vVar = this.f4244b;
        if (vVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            vVar = null;
        } else if (vVar == null) {
            throw null;
        }
        a.c.a.f.b.D0(parcel, 2, vVar, false);
        a.c.a.f.b.B0(parcel, 3, this.f4245c);
        a.c.a.f.b.B0(parcel, 4, this.f4246d);
        a.c.a.f.b.u1(parcel, b2);
    }
}
