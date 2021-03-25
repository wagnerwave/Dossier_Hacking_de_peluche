package a.d.a.a.e.m;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;

public final class e0 implements Parcelable.Creator<SignInButtonConfig> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i4 == 2) {
                i2 = b.b0(parcel, readInt);
            } else if (i4 == 3) {
                i3 = b.b0(parcel, readInt);
            } else if (i4 != 4) {
                b.v0(parcel, readInt);
            } else {
                scopeArr = (Scope[]) b.v(parcel, readInt, Scope.CREATOR);
            }
        }
        b.A(parcel, A0);
        return new SignInButtonConfig(i, i2, i3, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
