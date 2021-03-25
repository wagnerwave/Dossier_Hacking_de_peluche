package com.google.android.gms.common.internal;

import a.c.a.f.b;
import a.d.a.a.e.m.c0;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new c0();

    /* renamed from: a  reason: collision with root package name */
    public final int f4222a;

    /* renamed from: b  reason: collision with root package name */
    public final Account f4223b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4224c;

    /* renamed from: d  reason: collision with root package name */
    public final GoogleSignInAccount f4225d;

    public ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f4222a = i;
        this.f4223b = account;
        this.f4224c = i2;
        this.f4225d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.f4222a = 2;
        this.f4223b = account;
        this.f4224c = i;
        this.f4225d = googleSignInAccount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.E0(parcel, 1, this.f4222a);
        b.G0(parcel, 2, this.f4223b, i, false);
        b.E0(parcel, 3, this.f4224c);
        b.G0(parcel, 4, this.f4225d, i, false);
        b.u1(parcel, b2);
    }
}
