package com.google.android.gms.auth.api.signin.internal;

import a.c.a.f.b;
import a.d.a.a.c.a.d.c.s;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    public final String f4182a;

    /* renamed from: b  reason: collision with root package name */
    public GoogleSignInOptions f4183b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        b.h(str);
        this.f4182a = str;
        this.f4183b = googleSignInOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f4182a.equals(signInConfiguration.f4182a)) {
            GoogleSignInOptions googleSignInOptions = this.f4183b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f4183b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(googleSignInOptions2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f4182a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        GoogleSignInOptions googleSignInOptions = this.f4183b;
        int i2 = (hashCode + 31) * 31;
        if (googleSignInOptions != null) {
            i = googleSignInOptions.hashCode();
        }
        return i2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int b2 = b.b(parcel);
        b.H0(parcel, 2, this.f4182a, false);
        b.G0(parcel, 5, this.f4183b, i, false);
        b.u1(parcel, b2);
    }
}
