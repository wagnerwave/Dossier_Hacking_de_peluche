package com.inuker.bluetooth.library.model;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;

@RequiresApi(18)
public class BleGattDescriptor implements Parcelable {
    public static final Parcelable.Creator<BleGattDescriptor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public ParcelUuid f4329a;

    /* renamed from: b  reason: collision with root package name */
    public int f4330b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f4331c;

    public static class a implements Parcelable.Creator<BleGattDescriptor> {
        public Object createFromParcel(Parcel parcel) {
            return new BleGattDescriptor(parcel);
        }

        public Object[] newArray(int i) {
            return new BleGattDescriptor[i];
        }
    }

    public BleGattDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.f4329a = new ParcelUuid(bluetoothGattDescriptor.getUuid());
        this.f4330b = bluetoothGattDescriptor.getPermissions();
        this.f4331c = bluetoothGattDescriptor.getValue();
    }

    public BleGattDescriptor(Parcel parcel) {
        this.f4329a = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
        this.f4330b = parcel.readInt();
        this.f4331c = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder n = a.a.a.a.a.n("BleGattDescriptor{mUuid=");
        n.append(this.f4329a);
        n.append(", mPermissions=");
        n.append(this.f4330b);
        n.append(", mValue=");
        n.append(Arrays.toString(this.f4331c));
        n.append('}');
        return n.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4329a, i);
        parcel.writeInt(this.f4330b);
        parcel.writeByteArray(this.f4331c);
    }
}
