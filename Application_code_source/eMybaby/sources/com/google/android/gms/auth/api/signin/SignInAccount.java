package com.google.android.gms.auth.api.signin;

import a.c.a.f.b;
import a.d.a.a.c.a.d.i;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new i();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public String f4176a;

    /* renamed from: b  reason: collision with root package name */
    public GoogleSignInAccount f4177b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public String f4178c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f4177b = googleSignInAccount;
        b.i(str, "8.3 and 8.4 SDKs require non-null email");
        this.f4176a = str;
        b.i(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.f4178c = str2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.H0(parcel, 4, this.f4176a, false);
        b.G0(parcel, 7, this.f4177b, i, false);
        b.H0(parcel, 8, this.f4178c, false);
        b.u1(parcel, b2);
    }
}
