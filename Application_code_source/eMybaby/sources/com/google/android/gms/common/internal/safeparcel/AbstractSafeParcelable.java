package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

public abstract class AbstractSafeParcelable implements Parcelable {
    public final int describeContents() {
        return 0;
    }
}
