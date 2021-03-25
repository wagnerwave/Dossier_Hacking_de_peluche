package com.inuker.bluetooth.library.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class SearchRequest implements Parcelable {
    public static final Parcelable.Creator<SearchRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public List<SearchTask> f4335a;

    public static class a implements Parcelable.Creator<SearchRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new SearchRequest(parcel);
        }

        public Object[] newArray(int i) {
            return new SearchRequest[i];
        }
    }

    public SearchRequest() {
    }

    public SearchRequest(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f4335a = arrayList;
        parcel.readTypedList(arrayList, SearchTask.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4335a);
    }
}
