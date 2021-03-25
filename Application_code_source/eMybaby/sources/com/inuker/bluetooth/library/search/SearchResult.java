package com.inuker.bluetooth.library.search;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

public class SearchResult implements Parcelable {
    public static final Parcelable.Creator<SearchResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public BluetoothDevice f4336a;

    /* renamed from: b  reason: collision with root package name */
    public int f4337b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f4338c;

    public static class a implements Parcelable.Creator<SearchResult> {
        public Object createFromParcel(Parcel parcel) {
            return new SearchResult(parcel);
        }

        public Object[] newArray(int i) {
            return new SearchResult[i];
        }
    }

    public SearchResult(BluetoothDevice bluetoothDevice) {
        this.f4336a = bluetoothDevice;
        this.f4337b = 0;
        this.f4338c = null;
    }

    public SearchResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.f4336a = bluetoothDevice;
        this.f4337b = i;
        this.f4338c = bArr;
    }

    public SearchResult(Parcel parcel) {
        this.f4336a = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f4337b = parcel.readInt();
        this.f4338c = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SearchResult.class != obj.getClass()) {
            return false;
        }
        return this.f4336a.equals(((SearchResult) obj).f4336a);
    }

    public int hashCode() {
        return this.f4336a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder n = a.a.a.a.a.n(", mac = ");
        n.append(this.f4336a.getAddress());
        sb.append(n.toString());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4336a, 0);
        parcel.writeInt(this.f4337b);
        parcel.writeByteArray(this.f4338c);
    }
}
