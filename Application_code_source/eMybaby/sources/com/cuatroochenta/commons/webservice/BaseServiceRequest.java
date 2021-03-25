package com.cuatroochenta.commons.webservice;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class BaseServiceRequest implements Parcelable {
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString((String) null);
    }
}
