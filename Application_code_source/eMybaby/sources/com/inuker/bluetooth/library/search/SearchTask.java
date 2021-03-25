package com.inuker.bluetooth.library.search;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchTask implements Parcelable {
    public static final Parcelable.Creator<SearchTask> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f4339a;

    /* renamed from: b  reason: collision with root package name */
    public int f4340b;

    public static class a implements Parcelable.Creator<SearchTask> {
        public Object createFromParcel(Parcel parcel) {
            return new SearchTask(parcel);
        }

        public Object[] newArray(int i) {
            return new SearchTask[i];
        }
    }

    public SearchTask() {
    }

    public SearchTask(Parcel parcel) {
        this.f4339a = parcel.readInt();
        this.f4340b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4339a);
        parcel.writeInt(this.f4340b);
    }
}
