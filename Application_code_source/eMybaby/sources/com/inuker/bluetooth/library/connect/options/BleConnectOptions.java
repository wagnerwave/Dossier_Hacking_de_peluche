package com.inuker.bluetooth.library.connect.options;

import android.os.Parcel;
import android.os.Parcelable;

public class BleConnectOptions implements Parcelable {
    public static final Parcelable.Creator<BleConnectOptions> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f4317a;

    /* renamed from: b  reason: collision with root package name */
    public int f4318b;

    /* renamed from: c  reason: collision with root package name */
    public int f4319c;

    /* renamed from: d  reason: collision with root package name */
    public int f4320d;

    public static class a implements Parcelable.Creator<BleConnectOptions> {
        public Object createFromParcel(Parcel parcel) {
            return new BleConnectOptions(parcel);
        }

        public Object[] newArray(int i) {
            return new BleConnectOptions[i];
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4321a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f4322b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f4323c = 30000;

        /* renamed from: d  reason: collision with root package name */
        public int f4324d = 30000;
    }

    public BleConnectOptions(Parcel parcel) {
        this.f4317a = parcel.readInt();
        this.f4318b = parcel.readInt();
        this.f4319c = parcel.readInt();
        this.f4320d = parcel.readInt();
    }

    public BleConnectOptions(b bVar) {
        this.f4317a = bVar.f4321a;
        this.f4318b = bVar.f4322b;
        this.f4319c = bVar.f4323c;
        this.f4320d = bVar.f4324d;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("BleConnectOptions{connectRetry=");
        n.append(this.f4317a);
        n.append(", serviceDiscoverRetry=");
        n.append(this.f4318b);
        n.append(", connectTimeout=");
        n.append(this.f4319c);
        n.append(", serviceDiscoverTimeout=");
        n.append(this.f4320d);
        n.append('}');
        return n.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4317a);
        parcel.writeInt(this.f4318b);
        parcel.writeInt(this.f4319c);
        parcel.writeInt(this.f4320d);
    }
}
