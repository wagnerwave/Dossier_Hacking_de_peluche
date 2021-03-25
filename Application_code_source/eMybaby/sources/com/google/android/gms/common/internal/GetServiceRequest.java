package com.google.android.gms.common.internal;

import a.c.a.f.b;
import a.d.a.a.e.d;
import a.d.a.a.e.m.a;
import a.d.a.a.e.m.g0;
import a.d.a.a.e.m.j;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new g0();

    /* renamed from: a  reason: collision with root package name */
    public final int f4217a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4218b;

    /* renamed from: c  reason: collision with root package name */
    public int f4219c;

    /* renamed from: d  reason: collision with root package name */
    public String f4220d;

    /* renamed from: e  reason: collision with root package name */
    public IBinder f4221e;
    public Scope[] f;
    public Bundle g;
    public Account h;
    public Feature[] i;
    public Feature[] j;
    public boolean k;
    public int l;

    public GetServiceRequest(int i2) {
        this.f4217a = 4;
        this.f4219c = d.f1238a;
        this.f4218b = i2;
        this.k = true;
    }

    public GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i5) {
        this.f4217a = i2;
        this.f4218b = i3;
        this.f4219c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f4220d = "com.google.android.gms";
        } else {
            this.f4220d = str;
        }
        if (i2 < 2) {
            this.h = iBinder != null ? a.h(j.a.g(iBinder)) : null;
        } else {
            this.f4221e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
        this.i = featureArr;
        this.j = featureArr2;
        this.k = z;
        this.l = i5;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4217a);
        b.E0(parcel, 2, this.f4218b);
        b.E0(parcel, 3, this.f4219c);
        b.H0(parcel, 4, this.f4220d, false);
        b.D0(parcel, 5, this.f4221e, false);
        b.I0(parcel, 6, this.f, i2, false);
        b.C0(parcel, 7, this.g, false);
        b.G0(parcel, 8, this.h, i2, false);
        b.I0(parcel, 10, this.i, i2, false);
        b.I0(parcel, 11, this.j, i2, false);
        b.B0(parcel, 12, this.k);
        b.E0(parcel, 13, this.l);
        b.u1(parcel, b2);
    }
}
